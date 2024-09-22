package br.com.tech.challenge.pagamento.gateway

import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.interfaces.gateway.IPaymentGateway
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class PaymentGatewayImpl(
  private val mongoTemplate: MongoTemplate
) : IPaymentGateway {

  override fun findById(id: String): Payment? {
    return mongoTemplate.findById(id, Payment::class.java)
  }

  override fun save(payment: Payment): Payment {
    return mongoTemplate.save(payment)
  }

}