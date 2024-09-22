package br.com.tech.challenge.pagamento.core.entity

import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.interfaces.db.IPayment

data class Payment(
  override val id: String?,
  val event: PaymentEvent
): IPayment
