package com.portfolio.flux

import com.portfolio.flux.config.ServerConfig
import com.portfolio.flux.model.Member
import com.portfolio.flux.repository.MemberRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [ServerConfig::class, MemberRepository::class])
class MemberRepositoryTest(memberRepository: MemberRepository) : FunSpec({

    extensions(SpringExtension)

    test("create test") {
        var member: Member = Member(userName = "테스트", password = "1234", email = "test@example.ocm")
        val saved = memberRepository.save(member)
        saved.id shouldNotBe null
    }
})
