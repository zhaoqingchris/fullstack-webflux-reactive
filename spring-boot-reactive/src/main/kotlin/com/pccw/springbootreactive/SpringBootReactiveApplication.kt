package com.pccw.springbootreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootReactiveApplication

fun main(args: Array<String>) {
	runApplication<SpringBootReactiveApplication>(*args)
}
