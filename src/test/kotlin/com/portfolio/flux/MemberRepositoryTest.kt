package com.portfolio.flux

import com.portfolio.flux.config.ServerConfig
import com.portfolio.flux.model.Member
import com.portfolio.flux.repository.MemberRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.Test
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


//@WebFluxTest(FluxApplication::class)
@ContextConfiguration(classes = [MemberRepository::class, ServerConfig::class, FluxApplication::class])
class MemberRepositoryTest(memberRepository: MemberRepository) : FunSpec() {

    init {
        test("create test") {
            var member: Member = Member(userName = "테스트", password = "1234", email = "test@example.ocm")
            memberRepository.save(member)
            member.id shouldNotBe null
        }
    }
}
