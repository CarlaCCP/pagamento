package br.com.tech.challenge.pagamento.config

import br.com.tech.challenge.pagamento.usecase.PaymentUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PaymentConfig {

  @Bean
  fun paymentUseCase(): PaymentUseCase {
    return PaymentUseCase()
  }
}