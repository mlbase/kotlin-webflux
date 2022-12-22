package com.portfolio.flux.repository

import com.portfolio.flux.model.Member
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: CoroutineCrudRepository<Member, String> {
    suspend fun findOne(id: String): Member

    fun findByUsername(username: String): Member

    suspend fun findByEmail(email: String): Member
}