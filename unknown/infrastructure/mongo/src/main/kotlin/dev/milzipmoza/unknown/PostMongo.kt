package dev.milzipmoza.unknown

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.MongoRepository


interface PostMongoRepository : MongoRepository<PostMongoDocument, ObjectId>

data class PostMongoDocument(
    @Id
    val id: ObjectId,
    val no: String,
    val content: String,
    val writerId: String
)