package com.portfolio.flux

import com.portfolio.flux.config.ServerConfig
import com.portfolio.flux.repository.MemberRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [ServerConfig::class, MemberRepository::class])
class MemberRepositoryTest() : FunSpec({

    extensions(SpringExtension)
})
