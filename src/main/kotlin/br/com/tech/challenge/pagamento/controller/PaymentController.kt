package br.com.tech.challenge.pagamento.controller

import br.com.tech.challenge.pagamento.config.PaymentConfig
import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.interfaces.IClient
import br.com.tech.challenge.pagamento.interfaces.gateway.IPaymentGateway
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class PaymentController(

  private val paymentConfig: PaymentConfig
) {

  private val log = KotlinLogging.logger {}

  fun createPayment(paymentGateway: IPaymentGateway, id: String, paymentClient: IClient): PaymentEvent {
    paymentConfig.paymentUseCase().createPayment(paymentGateway, id)
    log.info { "Pagamento $id com status ${PaymentEvent.CREATED}" }
    val paymentWebhook = updatePayment(
      paymentGateway, id, paymentClient
    )
    log.info { "Webhook enviado para pedido ${paymentWebhook?.id}, com status ${paymentWebhook?.event}" }
    return PaymentEvent.CREATED
  }

  fun getPayment(paymentGateway: IPaymentGateway, id: String) : Payment? {
    return paymentConfig.paymentUseCase().getPayment(paymentGateway, id)
  }

  private fun updatePayment(paymentGateway: IPaymentGateway, id: String, paymentClient: IClient) =
    paymentConfig.paymentUseCase().updatePayment(
      paymentGateway, id, paymentClient
    )

}