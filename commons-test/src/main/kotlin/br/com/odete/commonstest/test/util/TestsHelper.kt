package br.com.odete.commonstest.test.util

import androidx.test.InstrumentationRegistry
import com.google.gson.Gson
import java.io.IOException

object TestsHelper {

    fun readJsonFromResources(patch: String): String? {
        try {
            val inputStream = InstrumentationRegistry.getTargetContext().resources.assets.open(patch)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return null
    }

    fun readJsonFromAssets(patch: String): String {
        try {
            val inputStream = javaClass.classLoader!!.getResourceAsStream(patch)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            throw RuntimeException()
        }
    }

    fun <T> getObjectFromJson(patch: String, clazz: Class<T>): T = Gson().fromJson(readJsonFromResources(patch), clazz)

    fun <T> getObjectFromJsonUnit(patch: String, clazz: Class<T>): T = Gson().fromJson(readJsonFromAssets(patch), clazz)
}
