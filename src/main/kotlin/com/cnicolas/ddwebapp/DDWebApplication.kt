package com.cnicolas.ddwebapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DDWebApplication

fun main(args: Array<String>) {
	runApplication<DDWebApplication>(*args)
}

