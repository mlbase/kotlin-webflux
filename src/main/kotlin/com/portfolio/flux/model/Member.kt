package com.portfolio.flux.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Member(@Id
                  val id: Long? = null,
                  val userName: String? = null,
                  var password: String? = null,
                  var email: String? = null) {
    override fun equals(other: Any?): Boolean {
        if (this == other) return true
        if ( javaClass != other?.javaClass) return false

        other as Member

        if ( id != other.id) return false
        if ( userName != other.userName) return false
        if ( password != other.password) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
}