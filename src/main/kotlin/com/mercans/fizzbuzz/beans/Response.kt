package com.mercans.fizzbuzz.beans

data class Response(
    val inMemoryData: List<String>?,
    val filePath: String?,
    val error: String?
)