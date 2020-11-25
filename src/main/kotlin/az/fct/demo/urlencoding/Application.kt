package az.fct.demo.urlencoding

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("az.fct.demo.urlencoding.*")
            .start()
}