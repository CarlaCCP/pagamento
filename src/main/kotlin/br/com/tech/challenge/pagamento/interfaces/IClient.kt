package br.com.tech.challenge.pagamento.interfaces

import br.com.tech.challenge.pagamento.core.entity.Payment
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(url = "svc-loja", value = "loja")
//@FeignClient(url = "localhost:8080", value = "loja")
interface IClient {

  @RequestMapping(method = [RequestMethod.POST], value = ["/pedido/pagamento"])
  @ResponseBody
  fun updatePayment(@RequestBody payment: Payment): Payment
}