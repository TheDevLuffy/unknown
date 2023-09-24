package dev.milzipmoza.unknown

import org.springframework.context.event.EventListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Repository

@Repository
class PostEventKafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @EventListener
    fun produce(event: PostEvent) {
        when (event) {
            is CreatePostEvent -> CreatePostEventKafkaMessage.from(event)
        }.also {
            kafkaTemplate.send(TOPIC_NAME, it)
        }
    }

    companion object {
        const val TOPIC_NAME = "post.event.v1"
    }
}

data class CreatePostEventKafkaMessage(
    val no: String,
    val content: String,
    val writerId: String,
) {

    companion object {
        fun from(event: CreatePostEvent) = CreatePostEventKafkaMessage(
            no = event.no,
            content = event.content,
            writerId = event.writerId,
        )
    }
}