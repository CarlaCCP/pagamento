package br.com.tech.challenge.pagamento.interfaces.db

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("pagamento")
interface IPayment {
  @get:Id
  val id: String?
}