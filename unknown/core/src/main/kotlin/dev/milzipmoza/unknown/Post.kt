package dev.milzipmoza.unknown

import java.util.UUID

class Post(
    val no: String,
    val content: String,
    val writerId: String,
) : DomainEventPublishable<PostEvent> {
    private val events: MutableList<PostEvent> = mutableListOf()

    private fun addEvent(event: PostEvent) {
        this.events.add(event)
    }

    override fun getEvents() = events

    override fun clearEvents() = events.clear()

    companion object {
        fun fromWrite(content: String, writerId: String) =
            Post(
                no = UUID.randomUUID().toString(),
                content = content,
                writerId = writerId
            ).also {
                it.addEvent(CreatePostEvent.from(it))
            }
    }
}
