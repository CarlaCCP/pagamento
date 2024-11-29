package br.com.tech.challenge.pagamento.api

import br.com.tech.challenge.pagamento.controller.PaymentController
import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.gateway.IPaymentGateway
import br.com.tech.challenge.pagamento.interfaces.IClient
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.mockk.every
import io.mockk.mockk

class PaymentApiTest : FunSpec({

  lateinit var paymentGateway: IPaymentGateway
  lateinit var paymentController: PaymentController
  lateinit var client: IClient

  lateinit var paymentApi: PaymentApi

  beforeTest {
    paymentGateway = mockk<IPaymentGateway>()
    paymentController = mockk<PaymentController>()
    client = mockk<IClient>()

    paymentApi = PaymentApi(
      paymentGateway, paymentController, client
    )
  }

  test("Should create payment") {
    every {
      paymentController.createPayment(paymentGateway, "1", client)
    } returns PaymentEvent.APPROVED

    shouldNotBeNull {
      paymentApi.createPayment("1")
    }
  }

  test("Should get payment by id ") {
    every {
      paymentController.getPayment(paymentGateway, "1")
    } returns Payment("1", PaymentEvent.APPROVED)

    shouldNotBeNull {
      paymentApi.getPayment("1")
    }
  }
})