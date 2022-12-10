package com.portfolio.flux

import com.portfolio.flux.config.ServerConfig
import com.portfolio.flux.repository.MemberRepository
import jdk.internal.vm.vector.VectorSupport.test
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@ContextConfiguration(classes = [MemberRepository::class, ServerConfig::class])
class MemberRepositoryTest(memberRepository: MemberRepository) : FunSpec({
    test() {

    }
})