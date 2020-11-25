package az.fct.demo.urlencoding

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/test")
class Controller {

    @Post(uri="/text", produces=["text/plain"])
    fun demoText(@Body payload:String): String {
        return "Example Response [$payload]"
    }

    @Post(uri="/json", produces=["text/plain"], consumes = ["application/json"])
    fun demoJson(@Body payload:Payload): String {
        return "Example Response [$payload]"
    }

    @Post(uri="/urlencoded", produces=["text/plain"], consumes = ["application/x-www-form-urlencoded"])
    fun demoUrlencoded(@Body payload:Payload): String {
        return "Example Response [$payload]"
    }
}

@Introspected
data class Payload(var name:String, var text:String)