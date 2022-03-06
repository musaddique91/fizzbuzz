package com.mercans.fizzbuzz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FizzbuzzApplication

fun main(args: Array<String>) {
	runApplication<FizzbuzzApplication>(*args)
}
