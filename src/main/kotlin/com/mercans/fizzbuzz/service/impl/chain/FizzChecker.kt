package com.mercans.fizzbuzz.service.impl.chain

import com.mercans.fizzbuzz.Constants
import com.mercans.fizzbuzz.service.IFizzBuzzChecker
import com.mercans.fizzbuzz.service.INumberIsMultiple
import com.mercans.fizzbuzz.service.IPrinter
import org.springframework.stereotype.Service

@Service
class FizzChecker(val checkNumberIsMultiple: INumberIsMultiple) : IFizzBuzzChecker {
    private var nextFizzBuzzCheker: IFizzBuzzChecker? = null
    override fun setNext(nextFizzBuzzChecker: IFizzBuzzChecker) {
        this.nextFizzBuzzCheker = nextFizzBuzzChecker
    }

    override fun check(number: Int, printer: IPrinter) {
        val numberIsMuipleOfAnother =
            checkNumberIsMultiple.checkNumberIsMuipleOfAnother(Constants.NUMBER_THREE, number)
        if (numberIsMuipleOfAnother) {
            printer.print(Constants.PRINT_FIZZ)
        } else {
            nextFizzBuzzCheker!!.check(number, printer)
        }
    }
}