package com.portfolio.flux.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun userDetailService(): ReactiveUserDetailsService {
        val userDetails = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user")
            .roles("User")
            .build()
        return MapReactiveUserDetailsService(userDetails)
    }


    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.
            authorizeExchange().
            anyExchange().
            authenticated().
            and().
            build()


    }
}