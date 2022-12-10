package com.portfolio.flux.client

import com.portfolio.flux.model.Greeting
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono



@Component
class GreetingClient( val builder: WebClient.Builder) {

    private final val client: WebClient

    init{
        this.client = builder.baseUrl("http://localhost:8080").build()
    }

    public fun getMessage():Mono<String>{
        return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting::class.java)
                .map(Greeting::getMessage)
    }
}