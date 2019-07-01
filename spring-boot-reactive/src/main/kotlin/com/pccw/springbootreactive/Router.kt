package com.pccw.springbootreactive

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class Router {

    @Bean
    fun portRouter(handler: PortHandler): RouterFunction<ServerResponse> = router {
        ("/ports").nest {
            GET("/", handler::getAllPorts)
        }
    }
}