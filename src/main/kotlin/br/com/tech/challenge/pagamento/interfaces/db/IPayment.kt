package br.com.tech.challenge.pagamento.interfaces.db

import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.springframework.data.annotation.Id

@DynamoDBTable(tableName = "pagamento")
interface IPayment {
  @get:DynamoDBHashKey
  @get:Id
  val id: String?
  @get:DynamoDBAttribute
  val event: PaymentEvent
}