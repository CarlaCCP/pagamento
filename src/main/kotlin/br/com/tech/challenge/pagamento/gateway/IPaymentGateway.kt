package br.com.tech.challenge.pagamento.gateway

import br.com.tech.challenge.pagamento.core.entity.Payment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IPaymentGateway : CrudRepository<Payment, String>