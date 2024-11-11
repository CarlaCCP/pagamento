package br.com.tech.challenge.pagamento.core.entity

import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "pagamento")
data class Payment(
  @Id
  var id: String? = null,
  var event: PaymentEvent? = null,
  val orderId: String? = null
) {

}
