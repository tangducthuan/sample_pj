package com.example.core.converter


/**
 * Created by Thuan Tang on 04/10/2022.
 */
interface Converter<in I, out O> {
    fun map(input: I): O
}