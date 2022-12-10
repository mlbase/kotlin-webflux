package com.portfolio.flux.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.format.annotation.DateTimeFormat
import javax.annotation.processing.Generated
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass

@Table
data class Member(@Id
                  val id: String? = null,
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