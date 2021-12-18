package com.application.simplekafka.producer

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun sendTopicMessage(valueMessage: String) {
        try {
            log.info("======== Start Producer ========")
            log.info("sendMessage : $valueMessage")
            kafkaTemplate.send("create-spring-topic", valueMessage)
            log.info("======== Close Producer ========")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
