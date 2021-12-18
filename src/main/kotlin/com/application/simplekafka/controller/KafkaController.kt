package com.application.simplekafka.controller

import com.application.simplekafka.producer.KafkaProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(
    private val kafkaProducer: KafkaProducer,
) {
    @PostMapping
    fun createMessage(
        @RequestParam("valueMessage") valueMessage: String
    ): String {
        kafkaProducer.sendTopicMessage(valueMessage)
        return "Success Create Message"
    }
}
