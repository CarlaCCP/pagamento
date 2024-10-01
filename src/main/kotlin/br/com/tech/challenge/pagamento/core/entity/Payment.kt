package br.com.tech.challenge.pagamento.core.entity

import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.interfaces.db.IPayment
import java.util.*

data class Payment(
  override val id: String? = UUID.randomUUID().toString(),
  override val event: PaymentEvent
): IPayment
