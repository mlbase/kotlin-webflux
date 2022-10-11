package com.portfolio.flux.router

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept

import com.portfolio.flux.handler.GreetingHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType


@Configuration(proxyBeanMethods = false)
class GreetingRouter {

    @Bean
    public fun route(greetingHandler: GreetingHandler):RouterFunction<ServerResponse>{

        return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)),
                greetingHandler::hello)
    }
}