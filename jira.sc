import upickle.default.{ReadWriter => RW, macroRW}
import upickle.default._
import requests.RequestAuth._


val pw = sys.env.get("JIRA_API_TOKEN").get

println("read env var JIRA_API_TOKEN")

case class ComponentRequest(
    name: String = "Directory",
    description: String = "This is Directory",
    project: String = "",
	leadAccountId: String = "6145da6a1238e800715abbd1",
	assigneeType: String = "PROJECT_DEFAULT",
	isAssigneeTypeValid: Boolean = false)

object ComponentRequest {
	implicit val rw: RW[ComponentRequest] = macroRW
}
  

def sendReq(componentReq: ComponentRequest, user: String, password: String) = {
	val req = requests.post("https://joraya.atlassian.net/rest/api/3/component"
	, auth = new Basic(user, password)
	, headers = Map("Accept" -> "application/json", "Content-Type" ->"application/json")
	, data = write(componentReq))
}
  
val req = ComponentRequest(name = "Name4", description="Desc4", project = "PRJ13")

println(write(req))

sendReq(req, "jackhclee@gmail.com", pw)