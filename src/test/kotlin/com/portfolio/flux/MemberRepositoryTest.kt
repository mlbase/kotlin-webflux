package com.portfolio.flux

import com.portfolio.flux.config.ServerConfig
import com.portfolio.flux.model.Member
import com.portfolio.flux.repository.MemberRepository
import io.kotest.core.spec.style.FunSpec
import jdk.internal.vm.vector.VectorSupport.test
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@WebFluxTest(FluxApplication::class)
@ContextConfiguration(classes = [MemberRepository::class, ServerConfig::class])
class MemberRepositoryTest(memberRepository: MemberRepository) : FunSpec({
    suspend fun create() {
        val member = Member(userName = "test", password = "1234", email = "test@test.com")
        memberRepository.save(member)
    }

    suspend fun login() {
        val request1 = Member(email="test@test.com", password = "1234")
        val request2 = Member(email="tes23@test.com", password = "11234")
        val request3 = Member(email="test@test.com", password = "11234")

        val resultEmail1 = memberRepository.findByEmail(request1.email)
        val resultEmail2 = memberRepository.findByEmail(request2.email)
        val resultEmail3 = memberRepository.findByEmail(request3.email)

//        if(resultEmail1 != null){
//            if(resultEmail1.password == request1.password){
//                println("request1: " + true)
//            } else {
//                println("request1: " + false)
//            }
//        }



    }
})