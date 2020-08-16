package org.js.denisvieira.featureplayground.commons.utils

internal class Base64Impl : Base64 {

    override fun encode(byteArray: ByteArray): String =
        android.util.Base64.encodeToString(byteArray, android.util.Base64.NO_WRAP)

    override fun decode(string: String): ByteArray =
        android.util.Base64.decode(string, android.util.Base64.NO_WRAP)
}
