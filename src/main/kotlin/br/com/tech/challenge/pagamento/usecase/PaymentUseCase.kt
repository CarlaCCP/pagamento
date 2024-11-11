package br.com.tech.challenge.pagamento.usecase

import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.interfaces.IClient
import br.com.tech.challenge.pagamento.gateway.IPaymentGateway
import org.springframework.stereotype.Service

@Service
class PaymentUseCase {

  fun createPayment(paymentGateway: IPaymentGateway, id: String): Payment =
    paymentGateway.save(
      Payment(id = id, PaymentEvent.CREATED)
    )

  fun updatePayment(paymentGateway: IPaymentGateway, id: String, paymentIClient: IClient): Payment? {
    val payment = paymentGateway.findById(id).get()
    return if (payment != null) {
      val paymentSaved = paymentGateway.save(
        payment.copy(event = PaymentEvent.APPROVED)
      )
      paymentIClient.updatePayment(paymentSaved)
    } else {
      null
    }
  }

  fun getPayment(paymentGateway: IPaymentGateway, id: String) : Payment? {
    return paymentGateway.findById(id).get()
  }

}