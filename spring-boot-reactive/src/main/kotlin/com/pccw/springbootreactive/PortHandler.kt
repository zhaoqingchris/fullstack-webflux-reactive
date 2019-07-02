package com.pccw.springbootreactive

import org.apache.commons.lang3.RandomStringUtils
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDateTime

@Document
data class Port(@Id val id: String? = null, val name: String, val location: String)

@Repository
interface PortRepository : ReactiveMongoRepository<Port, String>

@Component
class PortHandler(private val repository: PortRepository) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun getAllPorts(request: ServerRequest): Mono<ServerResponse> {
        log.info("Reactive Call, current Thread {} at {}", Thread.currentThread().name, LocalDateTime.now())

        val ports = repository.findAll()
        return ok().bodyToServerSentEvents(ports.delayElements(Duration.ofMillis(10)))
    }
}

@Component
class DataLoader(private val repository: PortRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        if (repository.count().block() == 0L) {
            repository.saveAll(
                    (0..100).map {
                        Port(
                                name = RandomStringUtils.randomAlphabetic(6),
                                location = RandomStringUtils.randomAlphanumeric(8)
                        )
                    }
            ).thenMany(repository.findAll())
                    .subscribe { println(it) }
        }
    }
}