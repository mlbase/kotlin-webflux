package com.portfolio.flux.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("test")
data class Test(
        @Id
        @Column("id")
        var id: String?,
        @Column("name")
        var name: String?)
{
    constructor(id: String?) : this(id, null){

    }
}