package com.portfolio.flux.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority
import java.time.Instant

@Table
data class Member(@Id
                  val id: String? = null,
                  val userName: String? = null,
                  val password: String? = null,
                  val email: String? = null,
                  val role: Role = Role.USER,
                  @CreatedDate val reg_date: Instant = Instant.now(),
                  @LastModifiedDate val upt_date: Instant = Instant.now()): GrantedAuthority {
    override fun equals(other: Any?): Boolean {
        if (this == other) return true
        if ( javaClass != other?.javaClass) return false

        other as Member

        if ( id != other.id) return false
        if ( userName != other.userName) return false
        if ( password != other.password) return false

        return true
    }

    override fun getAuthority(): String {
        return "Role_$role"
    }

    override fun hashCode(): Int = id.hashCode()
}

enum class Role {
    ADMIN, USER
}