package com.mercans.fizzbuzz.service.impl.chain

import com.mercans.fizzbuzz.service.IFizzBuzzChecker
import com.mercans.fizzbuzz.service.INumberIsMultiple
import com.mercans.fizzbuzz.service.IPrinter
import org.springframework.stereotype.Service

@Service
class NumberChecker(val checkNumberIsMultiple: INumberIsMultiple) : IFizzBuzzChecker {
    private var nextFizzBuzzChecker: IFizzBuzzChecker? = null
    override fun setNext(nextFizzBuzzChecker: IFizzBuzzChecker) {
        this.nextFizzBuzzChecker = nextFizzBuzzChecker
    }

    override fun check(number: Int, printer: IPrinter) {
        printer.print(number.toString())
    }
}