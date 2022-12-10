package com.portfolio.flux.client

import org.springframework.web.reactive.function.client.WebClient

class RegisterClient(val builder: WebClient.Builder) {

    private final val client: WebClient

    init {
        this.client = builder.baseUrl("http://localhost:8001").build()
    }

    public fun registerMember(){

    }
}