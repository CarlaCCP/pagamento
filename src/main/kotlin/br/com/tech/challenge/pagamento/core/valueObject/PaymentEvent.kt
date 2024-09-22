package br.com.tech.challenge.pagamento.core.valueObject

enum class PaymentEvent(description: String) {
  CREATED("Pagamento criado"),
  DENIED("Pagamento negado"),
  APPROVED("Pagamento aprovado"),
}