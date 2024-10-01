package br.com.tech.challenge.pagamento.config

import br.com.tech.challenge.pagamento.interfaces.gateway.IPaymentGateway
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = [IPaymentGateway::class])
class DynamoDbConfig {

  @Bean
  fun amazonDynamoDB(): AmazonDynamoDB = AmazonDynamoDBClientBuilder
    .standard()
    .withRegion(Regions.US_EAST_1)
    .build()
}