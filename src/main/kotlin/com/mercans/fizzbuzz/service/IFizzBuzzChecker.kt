package com.mercans.fizzbuzz.service

interface IFizzBuzzChecker {
    fun setNext(nextFizzBuzzChecker: IFizzBuzzChecker)
    fun check(number: Int, printer: IPrinter)
}