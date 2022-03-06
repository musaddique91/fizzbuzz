package com.mercans.fizzbuzz.controller

import com.mercans.fizzbuzz.Constants
import com.mercans.fizzbuzz.beans.Response
import com.mercans.fizzbuzz.enums.PrinterType
import com.mercans.fizzbuzz.utils.FizzBuzzExecutor
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.badRequest
import org.springframework.http.ResponseEntity.ok
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/fizzBuzz")
class FizzBuzzController(val fizzBuzzExecutor: FizzBuzzExecutor) {

    @GetMapping(value = ["execute"])
    @Secured("ROLE_ADMIN")
    fun fizzBuzz(
        @RequestParam("lastNumber") lastNumber: Int,
        @RequestParam("printerType") printerType: String
    ): ResponseEntity<Response> {
        return try {
            ok(fizzBuzzExecutor.execute(lastNumber, PrinterType.valueOf(printerType)))
        } catch (e: Exception) {
            badRequest().body(Response(null, null, e.message))
        }
    }
}