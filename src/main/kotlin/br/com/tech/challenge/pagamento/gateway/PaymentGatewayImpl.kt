package br.com.tech.challenge.pagamento.gateway

import br.com.tech.challenge.pagamento.core.entity.Payment
import br.com.tech.challenge.pagamento.core.valueObject.PaymentEvent
import br.com.tech.challenge.pagamento.interfaces.gateway.IPaymentGateway
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.Item
import com.amazonaws.services.dynamodbv2.document.Table
import org.springframework.stereotype.Repository

@Repository
class PaymentGatewayImpl(
  private val dynamoDB: AmazonDynamoDB
) : IPaymentGateway {


  private val tableName = "pagamento"
  private val dynamoDBClient = DynamoDB(dynamoDB)
  private val table: Table? = dynamoDBClient.getTable(tableName)

  override fun findById(id: String): Payment? {
    val item = table?.getItem("id", id)
    return item?.let {
      Payment(
        id = item.getString("id"),
        event = PaymentEvent.valueOf(item.getString("event"))
      )
    }
  }

  override fun save(payment: Payment): Payment {
    val item = Item()
      .withPrimaryKey("id", payment.id)
      .withString("event", payment.event.name)
    table?.putItem(item)
    return payment
  }

}