package br.com.tech.challenge.pagamento.config

import br.com.tech.challenge.pagamento.usecase.PaymentUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

@Configuration
class PaymentConfig {

  @Bean
  fun paymentUseCase(): PaymentUseCase {
    return PaymentUseCase()
  }
}