package com.mercans.fizzbuzz.service.impl.printer

import com.mercans.fizzbuzz.service.IPrinter

class InMemoryPrinter : IPrinter {
    private val result = mutableListOf<String>()

    override fun print(output: String) {
        result.add(output)
    }

    fun getResult() = this.result
}