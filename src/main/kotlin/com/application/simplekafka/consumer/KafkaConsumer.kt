package com.application.simplekafka.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {
    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["create-spring-topic"], groupId = "foo")
    fun consumeMessage(message: String) {
        log.info("======== Start Consumer ========")
        log.info("Receive Consumer Message : $message")
        log.info("======== End Consumer ========")
    }
}
