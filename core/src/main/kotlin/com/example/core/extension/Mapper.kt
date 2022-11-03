package com.example.core.extension

fun <I, O> I.convert(block: (I) -> O): O = block(this)