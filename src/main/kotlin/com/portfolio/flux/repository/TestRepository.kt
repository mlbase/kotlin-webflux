package com.portfolio.flux.repository

import com.portfolio.flux.model.Test
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TestRepository : ReactiveCrudRepository<Test, Int> {
}