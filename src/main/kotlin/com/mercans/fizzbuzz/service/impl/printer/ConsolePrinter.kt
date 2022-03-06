package com.mercans.fizzbuzz.service.impl.printer

import com.mercans.fizzbuzz.service.IPrinter
import org.springframework.stereotype.Service

@Service
class ConsolePrinter : IPrinter {
    override fun print(output: String) {
        System.out.print(" $output")
    }
}