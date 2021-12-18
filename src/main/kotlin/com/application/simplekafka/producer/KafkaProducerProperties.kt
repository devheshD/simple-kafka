package com.application.simplekafka.producer

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.*

@Component
class KafkaProducerProperties{
    @Bean
    fun producerConfigs(): Properties {
        val configs = Properties()

        return configs.apply {
            this[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
            this[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
            this[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        }
    }
}
