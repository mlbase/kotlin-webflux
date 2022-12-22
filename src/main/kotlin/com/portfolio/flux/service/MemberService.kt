package com.portfolio.flux.service

import com.portfolio.flux.repository.MemberRepository
import org.springframework.stereotype.Service


@Service
class MemberService(
    meberRepository: MemberRepository,
    ) {


    suspend fun register(userName: String, password: String, email:String) {


    }
}