package com.mercans.fizzbuzz

import com.mercans.fizzbuzz.enums.PrinterType
import com.mercans.fizzbuzz.exception.PrinterNotFound
import com.mercans.fizzbuzz.utils.FizzBuzzExecutor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FizzbuzzApplicationTests {

    @Autowired
    private lateinit var executor: FizzBuzzExecutor

    @Test
    fun `test fizzBuzzConsole`() {
        val result = executor.execute(30, PrinterType.CONSOLE)
        Assertions.assertNull(result)
    }

    @Test
    fun `test fizzBuzzInMemory`() {
        val result = executor.execute(30, PrinterType.IN_MEMORY)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(30, result?.inMemoryData?.size)
        Assertions.assertEquals("Fizz", result?.inMemoryData?.get(2))
    }

    @Test
    fun `test printer not available`() {
        val exception = Assertions.assertThrows(PrinterNotFound::class.java) {
            executor.execute(30, PrinterType.FILE_OUT)
        }
        Assertions.assertEquals("printer not available", exception.message)
    }

}
