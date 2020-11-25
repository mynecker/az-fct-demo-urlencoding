package az.fct.demo.urlencoding
import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpStatus
import io.micronaut.http.MediaType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class FunctionTest {

    @Test
    fun `test text`() {
        Function().use { function ->
            val response = function.request(HttpMethod.POST, "/test/text")
                    .body("abc")
                    .invoke()
            Assertions.assertEquals(HttpStatus.OK, response.status)
        }
    }

    @Test
    fun `test json`() {
        Function().use { function ->
            val response = function.request(HttpMethod.POST, "/test/json")
                    .body("""{"name":"abc","text":"efg"}""")
                    .header("Content-Type",MediaType.APPLICATION_JSON)
                    .invoke()
            Assertions.assertEquals(HttpStatus.OK, response.status)
        }
    }

    /**
     * This test fails as MediaType.APPLICATION_FORM_URLENCODED seems to be not supported
     */
    @Test
    fun `test urlencoded`() {
        Function().use { function ->
            val response = function.request(HttpMethod.POST, "/test/urlencoded")
                    .body("""name=some_name&text=some_text""")
                    .header("Content-Type",MediaType.APPLICATION_FORM_URLENCODED)
                    .invoke()
            Assertions.assertEquals(HttpStatus.OK, response.status)
        }
    }
}
