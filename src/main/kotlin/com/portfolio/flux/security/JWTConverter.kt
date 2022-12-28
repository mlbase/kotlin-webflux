package com.portfolio.flux.security

import kotlinx.coroutines.reactor.mono
import org.springframework.http.codec.json.AbstractJackson2Decoder
import org.springframework.security.core.Authentication
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.lang.Exception
import javax.xml.validation.Validator

@Component
class JWTConverter(
    private val jackson2Decoder: AbstractJackson2Decoder,
    private val validator: Validator
): ServerAuthenticationConverter {

    override fun convert(exchange: ServerWebExchange?): Mono<Authentication> = mono {
        val loginRequest = getUsernameAndPassword(exchange!!) ?: throw Exception("SAD")
    }

    private suspend fun getUsernameAndPassword(exchange: ServerWebExchange): LoginRequest {

    }
}