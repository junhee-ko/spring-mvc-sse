package jko.springmvcsse

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
@RequestMapping
class SseController(
    private val sseService: SseService
) {
    private val logger = LoggerFactory.getLogger(this::class.java)


    @GetMapping("/sse")
    fun sse(): SseEmitter {
        logger.info("Start sse")

        val emitter = SseEmitter()
        sseService.sse(emitter)

        logger.info("Start end")
        return emitter
    }
}
