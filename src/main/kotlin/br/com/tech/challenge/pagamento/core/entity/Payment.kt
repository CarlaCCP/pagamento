package br.com.tech.challenge.pagamento.core.entity

import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "pagamento")
data class Payment(
  @Id
  var id: String? = null,

  @Enumerated(EnumType.ORDINAL)
  var event: PaymentEvent? = null,
//  val orderId: String? = null
) {

}
