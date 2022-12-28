package com.portfolio.flux.security

import com.portfolio.flux.repository.MemberRepository
import kotlinx.coroutines.reactor.mono
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomReactiveUserDetailService(
    private val memberRepository: MemberRepository
): ReactiveUserDetailsService {

    override fun findByUsername(username: String?): Mono<UserDetails> = mono {
        val member = memberRepository.findByUserName(username!!) ?: throw BadCredentialsException("Invalid Credentials")
        return@mono User(member.userName, member.password, listOf(member))
    }
}