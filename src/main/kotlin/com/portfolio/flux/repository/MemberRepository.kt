package com.portfolio.flux.repository

import com.portfolio.flux.model.Member
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: CoroutineCrudRepository<Member, Long> {
}