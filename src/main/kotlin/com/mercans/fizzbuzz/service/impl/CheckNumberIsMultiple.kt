package com.mercans.fizzbuzz.service.impl

import com.mercans.fizzbuzz.service.INumberIsMultiple
import org.springframework.stereotype.Service

@Service
class CheckNumberIsMultiple : INumberIsMultiple {
    override fun checkNumberIsMuipleOfAnother(firstNumber: Int, secondNumber: Int): Boolean {
        if (firstNumber.equals(secondNumber)) {
            return true;
        } else if (secondNumber < firstNumber) {
            return false
        }
        return checkNumberIsMuipleOfAnother(firstNumber + firstNumber, secondNumber)
    }
}