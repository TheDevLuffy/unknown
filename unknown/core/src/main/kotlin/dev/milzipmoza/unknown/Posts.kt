package dev.milzipmoza.unknown

interface Posts {

    fun get(no: String): Post

    fun getAll(): Collection<Post>
}