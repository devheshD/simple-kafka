package com.application.simplekafka.controller

import com.application.simplekafka.consumer.KafkaConsumer
import com.application.simplekafka.producer.KafkaProducer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Rasung Ki
 */
@RestController
class KafkaController(
    private val kafkaProducer: KafkaProducer,
    private val kafkaConsumer: KafkaConsumer,
) {
    @PostMapping
    fun createMessage(
        @RequestParam("valueMessage") valueMessage: String
    ): String {
        kafkaProducer.sendTopicMessage(valueMessage)
        return "createSuccess"
    }
}
