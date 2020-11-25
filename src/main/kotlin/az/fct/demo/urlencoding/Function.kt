package az.fct.demo.urlencoding

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import io.micronaut.azure.function.AzureFunction
import io.micronaut.azure.function.http.AzureHttpFunction
import java.util.*

/**
 * Azure Functions with HTTP Trigger.
 */
class Function : AzureHttpFunction() {


    @FunctionName("demo-function")
    fun invoke(
            @HttpTrigger(name = "req",
                    methods = [HttpMethod.POST, HttpMethod.GET],
                    route = "{*route}",
                    authLevel = AuthorizationLevel.FUNCTION)
            request: HttpRequestMessage<Optional<String>>,
            context: ExecutionContext): HttpResponseMessage {

        return super.route(request, context)

    }

}

