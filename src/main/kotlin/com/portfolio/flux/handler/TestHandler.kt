package com.portfolio.flux.handler

import com.portfolio.flux.model.Test
import com.portfolio.flux.repository.TestRepository
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.Month

class TestHandler {

    val testRepository: TestRepository

    constructor(testRepository: TestRepository) {
        this.testRepository = testRepository
    }

    fun getAllTest(req: ServerRequest): Mono<ServerResponse> {
        return testRepository.findAll().collectList()
                .flatMap { it ->
                    ServerResponse.ok().body(BodyInserters.fromValue(it))
                }
    }

    fun getTest(req: ServerRequest): Mono<ServerResponse> {
        var id = req.pathVariable("id")
        return testRepository.findById(id.toInt())
                .flatMap { it ->
                    ServerResponse.ok().body(BodyInserters.fromValue(it))
                }
    }

    fun createTest(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(Test::class.java).flatMap { it ->
            testRepository.save(it)
        }.flatMap {
            ServerResponse.ok().body(BodyInserters.fromValue("추가하였습니다."))
        }
    }

    fun putTest(req: ServerRequest): Mono<ServerResponse> {
        var id = req.pathVariable("id")

        var test = Test(id = id.toInt())
        return testRepository.delete(test)
                .then(ServerResponse.ok().body(BodyInserters.fromValue("삭제하였습니다.")))
    }
}