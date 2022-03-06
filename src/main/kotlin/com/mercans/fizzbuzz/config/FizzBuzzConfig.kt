package com.mercans.fizzbuzz.config

import com.mercans.fizzbuzz.service.impl.chain.BuzzChecker
import com.mercans.fizzbuzz.service.impl.chain.FizzBuzzChecker
import com.mercans.fizzbuzz.service.impl.chain.FizzChecker
import com.mercans.fizzbuzz.service.impl.chain.NumberChecker
import org.springframework.context.annotation.Configuration

@Configuration
class FizzBuzzConfig(
    val fizzBuzzChecker: FizzBuzzChecker,
    val fizzChecker: FizzChecker,
    val buzzChecker: BuzzChecker,
    val numberChecker: NumberChecker
) {

    init {
        fizzBuzzChecker.setNext(fizzChecker)
        fizzChecker.setNext(buzzChecker)
        buzzChecker.setNext(numberChecker)
    }
}