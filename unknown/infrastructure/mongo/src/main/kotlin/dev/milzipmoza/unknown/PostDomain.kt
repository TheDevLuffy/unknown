package dev.milzipmoza.unknown

import org.bson.types.ObjectId
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Repository

@Repository
class PostOperationUsingMongo(
    private val postMongoRepository: PostMongoRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) : PostOperation {
    override fun write(post: Post) {
        postMongoRepository.save(
            PostMongoDocument(
                id = ObjectId(),
                no = post.no,
                content = post.content,
                writerId = post.writerId,
            )
        )
        post.forEachEvent {
            applicationEventPublisher.publishEvent(it)
        }
        post.clearEvents()
    }

    override fun overwrite(post: Post) {
        TODO("Not yet implemented")
    }

    override fun delete(no: String) {
        TODO("Not yet implemented")
    }
}

@Repository
class PostsUsingMongo(
    private val postMongoRepository: PostMongoRepository,
) : Posts {

    override fun get(no: String): Post {
        TODO("Not yet implemented")
    }

    override fun getAll(): Collection<Post> {
        TODO("Not yet implemented")
    }
}
