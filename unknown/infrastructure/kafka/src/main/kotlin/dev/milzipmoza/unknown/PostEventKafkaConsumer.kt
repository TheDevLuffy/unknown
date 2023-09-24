package dev.milzipmoza.unknown

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class PostEventKafkaConsumer {

    private val logger = KotlinLogging.logger {}

    @KafkaListener(
        topics = [
            PostEventKafkaProducer.TOPIC_NAME,
        ],
        groupId = "unknown"
    )
    fun consume(message: CreatePostEventKafkaMessage) {
        logger.info { "message consumed=$message" }
    }
}