package br.com.tech.challenge.pagamento.usecase.behavior

import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.gateway.IPaymentGateway
import br.com.tech.challenge.pagamento.interfaces.IClient
import br.com.tech.challenge.pagamento.usecase.PaymentUseCase
import io.kotest.core.annotation.Tags
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

@Tags("behavior")
class PaymentUseCaseBddTest : BehaviorSpec({


  lateinit var paymentGateway: IPaymentGateway
  lateinit var paymentIClient: IClient

  lateinit var paymentUseCase: PaymentUseCase

  beforeTest {
    paymentGateway = mockk<IPaymentGateway>()
    paymentIClient = mockk<IClient>()

    paymentUseCase = PaymentUseCase()
  }


  given("Um pagamento") {

    val payment = Payment("1", PaymentEvent.CREATED)

    `when`("Quando é criado") {

      then("Deve ser salvo e retornado") {
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
    }

    `when`("Quando é atualizado") {

      then("Deve ser atualizado pelo id e retornado") {
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

      then("Não deve ser atualizado se não encontrado") {
        every { paymentGateway.findById("1") } returns Optional.empty()
        paymentUseCase.updatePayment(paymentGateway, "1", paymentIClient) shouldBe null
      }
    }


    `when`("Quando é pesquisado") {

      then("Deve ser pesquisado por id e retornado") {
        every {
          paymentGateway.findById("1")
        } returns Optional.of(payment)

        shouldNotBeNull {
          paymentUseCase.getPayment(paymentGateway, "1")
        }
      }
    }

  }
})