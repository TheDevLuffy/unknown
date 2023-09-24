package dev.milzipmoza.unknown

interface PostOperation {

    fun write(post: Post)

    fun overwrite(post: Post)

    fun delete(no: String)
}