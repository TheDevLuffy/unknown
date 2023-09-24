package dev.milzipmoza.unknown

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @PostMapping("/hellos")
    fun postHello(): String {
        return "hi"
    }
}