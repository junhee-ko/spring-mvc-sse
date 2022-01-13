package jko.springmvcsse

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.time.LocalTime

@Service
class SseService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Async
    fun sse(emitter: SseEmitter) {
        try {
            var i = 0
            while (true) {
                val event = SseEmitter.event()
                    .data("SSE MVC - " + LocalTime.now().toString())
                    .id(i.toString())
                    .name("SSE Event")
                logger.info("Event: $event")

                emitter.send(event)
                Thread.sleep(1000)
                i++
            }
        } catch (ex: Exception) {
            emitter.completeWithError(ex)
        }
    }
}
