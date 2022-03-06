package com.mercans.fizzbuzz.service.impl.chain

import com.mercans.fizzbuzz.Constants
import com.mercans.fizzbuzz.service.IFizzBuzzChecker
import com.mercans.fizzbuzz.service.INumberIsMultiple
import com.mercans.fizzbuzz.service.IPrinter
import org.springframework.stereotype.Service

@Service("fizzBuzzChecker")
class FizzBuzzChecker(val checkNumberIsMultiple: INumberIsMultiple) : IFizzBuzzChecker {
    private var nextCheker: IFizzBuzzChecker? = null
    override fun setNext(nextFizzBuzzChecker: IFizzBuzzChecker) {
        this.nextCheker = nextFizzBuzzChecker
    }

    override fun check(number: Int, printer: IPrinter) {
        val numberIsMultipleOfAnother =
            checkNumberIsMultiple.checkNumberIsMuipleOfAnother(Constants.NUMBER_FIFTEEN, number)
        if (numberIsMultipleOfAnother) {
            printer.print(Constants.PRINT_FIZZBUZZ)
        } else {
            nextCheker!!.check(number, printer)
        }
    }
}