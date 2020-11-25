# Sample 

Related to: https://github.com/micronaut-projects/micronaut-azure

Sample demonstrating issue with HTTP Azure Function and content type `application/x-www-form-urlencoded``.

## How to reproduce

```bash
./gradlew clean build 
```
This test fails
```kotlin
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
```

Same issue with `curl` and function running locally and /or in Azure

```bash

./gradlew clean build azureFunctionsRun -x test

curl -v --trace dump.log POST /
     --header "Content-Type: application/x-www-form-urlencoded" /
     --data-urlencode "name=some_name" /
     --data-urlencode "text=some_text" /
     "http://localhost:7071/api/test/urlencoded"
```

Response 
```
{"message":"Unable to decode request body: Error decoding JSON stream for type [payload]: Unrecognized token /
'name': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\n at /
[Source: (ByteArrayInputStream); line: 1, column: 6]","_links":{"self":{"href":"/api/test/urlencoded","templated":false}}}
```