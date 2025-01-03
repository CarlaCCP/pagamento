package br.com.tech.challenge.pagamento.interfaces

import br.com.tech.challenge.pagamento.core.entity.Payment
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(url = "svc-pedido", value = "pedido")
//@FeignClient(url = "localhost:8082", value = "pedido")
interface IClient {

  @RequestMapping(method = [RequestMethod.POST], value = ["/pedido/pagamento"])
  @ResponseBody
  fun updatePayment(@RequestBody payment: Payment): Payment
}