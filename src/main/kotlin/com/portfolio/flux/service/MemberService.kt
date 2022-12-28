package com.portfolio.flux.service

import com.portfolio.flux.model.Member
import com.portfolio.flux.repository.MemberRepository
import org.springframework.stereotype.Service


@Service
class MemberService(
    private val memberRepository: MemberRepository
    ) {


    suspend fun register(userName: String, password: String, email:String) {
        val member = Member(userName = userName, password = password, email = email)

    }
}