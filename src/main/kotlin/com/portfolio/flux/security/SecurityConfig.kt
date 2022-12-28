package com.portfolio.flux.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers

@Configuration
@EnableWebFluxSecurity
class SecurityConfig(

) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun userDetailService(): ReactiveUserDetailsService {
        return MapReactiveUserDetailsService(
            User
                .withUsername("user")
                .password("user")
                .roles("USER")
                .build()
        )
    }


    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain = http.build();

    @Bean
    fun configureSecurity(http: ServerHttpSecurity, jwtAuthenticationFilter: AuthenticationWebFilter): SecurityWebFilterChain {
        return http
                .csrf().disable()
                .logout().disable()
                .addFilterAfter(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .build()
    }

    @Bean
    fun authenticationWebFilter(
        reactiveAuthenticationManager: ReactiveAuthenticationManager,
        jwtConverter: ServerAuthenticationConverter,
        serverAuthenticationSuccessHandler: ServerAuthenticationSuccessHandler,
        jwtServerAuthenticationFailureHandler: ServerAuthenticationFailureHandler
    ): AuthenticationWebFilter {
        val authenticationWebFilter = AuthenticationWebFilter(reactiveAuthenticationManager)
        authenticationWebFilter.setRequiresAuthenticationMatcher {
            ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/login").matches(it)
        }
        authenticationWebFilter.setServerAuthenticationConverter(jwtConverter)
        authenticationWebFilter.setAuthenticationFailureHandler(jwtServerAuthenticationFailureHandler)
        authenticationWebFilter.setSecurityContextRepository(NoOpServerSecurityContextRepository.getInstance())
        return authenticationWebFilter
    }

    @Bean
    fun reactiveAuthenticationManager(
        reactiveUserDetailsService: ReactiveUserDetailsService,
        passwordEncoder: PasswordEncoder
    ): ReactiveAuthenticationManager {
        val manager = UserDetailsRepositoryReactiveAuthenticationManager(reactiveUserDetailsService)
        manager.setPasswordEncoder(passwordEncoder)
        return manager
    }
}