package com.application.simplekafka.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class KafkaProducer(
    val properties: KafkaProducerProperties
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun create() {
        log.info("======== Start Producer ========")
        val kafkaProducer = KafkaProducer<String, String>(properties.producerConfigs())
        val kafkaRecord = ProducerRecord<String, String>("create-spring-topic", "input-value")
        kafkaProducer.send(kafkaRecord)
        kafkaProducer.close()
        log.info("======== Close Producer ========")
    }
}
