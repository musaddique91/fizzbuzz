package com.mercans.fizzbuzz.utils

import com.mercans.fizzbuzz.Constants
import com.mercans.fizzbuzz.beans.Response
import com.mercans.fizzbuzz.enums.PrinterType
import com.mercans.fizzbuzz.service.IFizzBuzzChecker
import com.mercans.fizzbuzz.service.IPrinter
import com.mercans.fizzbuzz.service.impl.printer.InMemoryPrinter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class FizzBuzzExecutor(@Qualifier("fizzBuzzChecker") private val fizzBuzzChecker: IFizzBuzzChecker) {
    @Throws(Exception::class)
    fun execute(lastNumber: Int, printerType: PrinterType): Response? {
        val printerInstance = BeanFactory.getPrinterInstance(printerType)
        startExecution(Constants.START_LOOP_NUMBER, lastNumber, printerInstance)
        return when (printerInstance) {
            is InMemoryPrinter -> Response(printerInstance.getResult(), null, null)
            else -> null
        }
    }

    private fun startExecution(startNumber: Int = 0, lastNumber: Int, printer: IPrinter) {
        if (startNumber.equals(lastNumber)) {
            return
        } else {
            val nextNumber = startNumber + 1
            fizzBuzzChecker.check(nextNumber, printer)
            startExecution(nextNumber, lastNumber, printer)
        }
    }
}