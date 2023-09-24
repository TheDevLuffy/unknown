package dev.milzipmoza.unknown

sealed interface PostEvent : DomainEvent

data class CreatePostEvent(
    val no: String,
    val content: String,
    val writerId: String,
) : PostEvent {

    companion object {
        fun from(post: Post) =
            CreatePostEvent(
                no = post.no,
                content = post.content,
                writerId = post.writerId,
            )
    }
}
