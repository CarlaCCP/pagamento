package br.com.tech.challenge.pagamento.interfaces.db

import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//@Entity(name = "pagamento")
interface IPayment {
//  @get:Id
//  @get:GeneratedValue(strategy = GenerationType.AUTO)
  var id: String?
  var event: PaymentEvent
}