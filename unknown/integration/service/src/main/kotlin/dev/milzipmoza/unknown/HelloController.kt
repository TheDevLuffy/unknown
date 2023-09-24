package dev.milzipmoza.unknown

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val postOperation: PostOperation,
) {

    @PostMapping("/hellos/{postNo}")
    fun postHello(
        @PathVariable postNo: String,
    ): String {
        val post = Post.fromWrite(
            content = "콘텐트",
            writerId = "쓰기",
        )
        postOperation.write(post)
        return "success"
    }
}