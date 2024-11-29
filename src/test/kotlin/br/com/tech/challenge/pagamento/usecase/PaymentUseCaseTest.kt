package br.com.tech.challenge.pagamento.usecase

import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.gateway.IPaymentGateway
import br.com.tech.challenge.pagamento.interfaces.IClient
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

class PaymentUseCaseTest : FunSpec ({

  lateinit var paymentGateway: IPaymentGateway
  lateinit var paymentIClient: IClient

  lateinit var paymentUseCase: PaymentUseCase

  beforeTest {
    paymentGateway = mockk<IPaymentGateway>()
    paymentIClient = mockk<IClient>()

    paymentUseCase = PaymentUseCase()
  }

  val payment = Payment("1", PaymentEvent.CREATED)

  test("Should create payment") {
    every {
      paymentGateway.save(
        payment
      )
    } returns payment

    shouldNotBeNull {
      paymentUseCase.createPayment(
        paymentGateway, "1"
      )
    }
  }


  test("Should update payment") {
    every { paymentGateway.findById("1") } returns Optional.of(payment)
    every {
      paymentGateway.save(
        payment.copy(event = PaymentEvent.APPROVED)
      )
    } returns payment

    every {
      paymentIClient.updatePayment(payment)
    } returns payment

    shouldNotBeNull {
      paymentUseCase.updatePayment(
        paymentGateway, "1", paymentIClient
      )
    }
  }


  test("Should not update when payment not found") {
    every { paymentGateway.findById("1") } returns Optional.empty()
    paymentUseCase.updatePayment(paymentGateway, "1", paymentIClient) shouldBe null
  }

  test("should get payment") {
    every {
      paymentGateway.findById("1")
    } returns Optional.of(payment)

    shouldNotBeNull {
      paymentUseCase.getPayment(paymentGateway, "1")
    }
  }
})