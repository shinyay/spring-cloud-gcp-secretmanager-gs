package com.google.shinyay.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1")
class SecretManagerController {

    @Value("\${sm://app-secret}")
    lateinit var appSecret: String

    @GetMapping("hello")
    fun helloController(): String {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val currentTime = ZonedDateTime.now(ZoneId.of("Japan")).format(dateFormat)
        return "Hello [$appSecret] at $currentTime"
    }

}