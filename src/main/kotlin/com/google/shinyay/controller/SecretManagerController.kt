package com.google.shinyay.controller

import com.google.cloud.spring.secretmanager.SecretManagerTemplate
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1")
class SecretManagerController(val secretManagerTemplate: SecretManagerTemplate) {

    @Value("\${sm://app-secret}")
    lateinit var appSecret: String

    @Value("\${my-app.my-env.secretmanager}")
    lateinit var myMessage: String

    @GetMapping("/hello")
    fun helloController(): String {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val currentTime = ZonedDateTime.now(ZoneId.of("Japan")).format(dateFormat)
        return "Hello [$appSecret] at $currentTime"
    }

    @GetMapping("/message")
    fun messageController(): String {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val currentTime = ZonedDateTime.now(ZoneId.of("Japan")).format(dateFormat)
        return "Message is [$myMessage] at $currentTime"
    }

    @GetMapping("/template")
    fun templateController(@RequestParam secret: String,
                           @RequestParam(required = false) projectId: String): String? {
        return if (StringUtils.isEmpty(projectId)) {
            val secretValue = secretManagerTemplate.getSecretString("sm://$secret")
            "Secret ID: $secret | Value: $secretValue"
        }else{
            val secretValue = secretManagerTemplate.getSecretString("sm://$projectId/$secret")
            "Secret ID: $secret | Value: $secretValue"
        }
    }
}