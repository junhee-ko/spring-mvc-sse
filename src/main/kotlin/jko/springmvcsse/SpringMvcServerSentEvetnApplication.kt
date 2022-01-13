package jko.springmvcsse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class SpringMvcServerSentEvetnApplication

fun main(args: Array<String>) {
    runApplication<SpringMvcServerSentEvetnApplication>(*args)
}
