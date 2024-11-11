package br.com.tech.challenge.pagamento.api

import br.com.tech.challenge.pagamento.controller.PaymentController
import br.com.tech.challenge.pagamento.interfaces.IClient
import br.com.tech.challenge.pagamento.gateway.IPaymentGateway
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/payment")
@Validated
@Controller
class PaymentApi(
  private val paymentGateway: IPaymentGateway,
  private val paymentController: PaymentController,
  private val client: IClient
) {

  @PostMapping("/create/{id}")
  fun createPayment(@PathVariable id: String) = paymentController.createPayment(paymentGateway, id, client)

  @GetMapping("/{id}")
  fun getPayment(@PathVariable id: String) = paymentController.getPayment(paymentGateway, id)

}