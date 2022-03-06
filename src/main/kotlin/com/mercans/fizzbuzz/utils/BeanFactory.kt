package com.mercans.fizzbuzz.utils

import com.mercans.fizzbuzz.enums.PrinterType
import com.mercans.fizzbuzz.exception.PrinterNotFound
import com.mercans.fizzbuzz.service.IPrinter
import com.mercans.fizzbuzz.service.impl.printer.ConsolePrinter
import com.mercans.fizzbuzz.service.impl.printer.InMemoryPrinter

class BeanFactory {
    companion object {
        @Throws(PrinterNotFound::class)
        fun getPrinterInstance(printerType: PrinterType): IPrinter {
            return when (printerType) {
                PrinterType.CONSOLE -> ConsolePrinter()
                PrinterType.IN_MEMORY -> InMemoryPrinter()
                else -> throw PrinterNotFound("printer not available")
            }
        }
    }
}