package com.abdullah996.rest.webservices.restfulwebservices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.abdullah996.rest.webservices.restfulwebservices"])
class RestfulWebServicesApplication

fun main(args: Array<String>) {
	runApplication<RestfulWebServicesApplication>(*args)
}
