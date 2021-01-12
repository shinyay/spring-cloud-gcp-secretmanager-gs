package com.google.shinyay.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller

@Controller
class SecretManagerController {

    @Value("\${sm://app-secret}")
    lateinit var appSecret: String

}