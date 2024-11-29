package br.com.tech.challenge.pagamento.controller

import br.com.tech.challenge.pagamento.config.PaymentConfig
import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.gateway.IPaymentGateway
import br.com.tech.challenge.pagamento.interfaces.IClient
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.mockk.every
import io.mockk.mockk

class PaymentControllerTest : FunSpec ({

  lateinit var paymentConfig: PaymentConfig
  lateinit var paymentGateway: IPaymentGateway
  lateinit var paymentClient: IClient
  lateinit var paymentController: PaymentController

  beforeTest {
    paymentConfig = mockk<PaymentConfig>()
    paymentGateway = mockk<IPaymentGateway>()
    paymentClient = mockk<IClient>()

    paymentController = PaymentController(paymentConfig)
  }

  val payment = Payment("1", PaymentEvent.APPROVED)

  test("Should create order") {
    every {
      paymentConfig.paymentUseCase().createPayment(
        paymentGateway, "1"
      )
    } returns payment

    every {
      paymentConfig.paymentUseCase().updatePayment(
        paymentGateway, "1", paymentClient
      )
    } returns payment

    shouldNotBeNull {
      paymentController.createPayment(
        paymentGateway, "1", paymentClient
      )
    }
  }


  test("Should get payment") {
    every {
      paymentConfig.paymentUseCase().getPayment(
        paymentGateway, "1"
      )
    } returns payment

    shouldNotBeNull {
      paymentController.getPayment(
        paymentGateway, "1"
      )
    }
  }

})