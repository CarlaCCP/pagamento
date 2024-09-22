package br.com.tech.challenge.pagamento.interfaces.gateway

import br.com.tech.challenge.pagamento.core.entity.Payment
import org.springframework.stereotype.Repository

@Repository
interface IPaymentGateway {

  fun findById(id: String) : Payment?

  fun save(payment: Payment): Payment

}