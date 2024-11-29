package br.com.tech.challenge.pagamento.core.valueObject

enum class PaymentEvent(val description: String) {
  CREATED("Pagamento criado"),
  DENIED("Pagamento negado"),
  APPROVED("Pagamento aprovado"),
}