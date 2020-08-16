package org.js.denisvieira.featureplayground.commons.utils

interface Base64 {

    fun encode(byteArray: ByteArray): String

    fun decode(string: String): ByteArray
}
