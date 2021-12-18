package com.application.simplekafka.producer

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer(
    val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun sendTopicMessage() {
        try {
            log.info("======== Start Producer ========")
            kafkaTemplate.send("create-spring-topic", "input-value")
            log.info("======== Close Producer ========")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
