import upickle.default.{ReadWriter => RW, macroRW}
import upickle.default._
import requests.RequestAuth._


val pw = "ATATT3xFfGF0vrmjok3oZVCOsG3XgcQlrh4zoNPPnv7Jlge3ygTN0TYPCcVHFPlYDYNy34JD_F__gDl6TXQTXhPVtOqjlv4n2PxGoTu2S3LWsIjhLv0CnpueZsKZutBk2NWx4tLEazWi-YDDjgg-rX147MO4w3Hh94rBTfOdjzQjqIqriOqzBac=3C6DE322"
       //"ATATT3xFfGF0xim5v5Y2UaqcSZgcMOW6PQyN9Zwr2ibyu77y3waTPzOHfhQ0t2RVA5GMnPk8kdgDgU2-ggI10opcsIMgXPcquLwyaTMlCRUzmfZ0xrU3NbdpJAqsRHfOZn7bPBBFJt3uWC1woQ_iPxHHYvYOc8vFf9lasZBRkvli9ANZZo5SEiU=73649BCC"

case class ComponentRequest(
leadAccountId: String = "6145da6a1238e800715abbd1",
assigneeType: String = "PROJECT_DEFAULT",
description: String = "This is Directory",
isAssigneeTypeValid: Boolean = false,
name: String = "Directory",
project: String = "1000",
projectId: String = "PRJ13")

object ComponentRequest {
implicit val rw: RW[ComponentRequest] = macroRW
}
  

  def sendReq(componentReq: ComponentRequest, user: String, password: String) = {

  	val req = requests.post("https://joraya.atlassian.net/rest/api/3/component"
  	, auth = new Basic(user, password)
  	, headers = Map("Accept" -> "application/json", "Content-Type" ->"application/json")
  	, data = write(componentReq))
  }
  
val req = ComponentRequest(description="D", name = "Name1", project = "PRJ13")

sendReq(req, "jackhclee@gmail.com", pw)