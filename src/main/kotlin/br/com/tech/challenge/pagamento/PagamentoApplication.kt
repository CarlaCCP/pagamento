package br.com.tech.challenge.pagamento

import br.com.tech.challenge.pagamento.config.AwsProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(AwsProperties::class)
class PagamentoApplication

fun main(args: Array<String>) {
	runApplication<PagamentoApplication>(*args)
}
