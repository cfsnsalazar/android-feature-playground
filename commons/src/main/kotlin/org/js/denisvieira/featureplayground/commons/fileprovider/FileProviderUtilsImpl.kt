package org.js.denisvieira.featureplayground.commons.fileprovider

object FileProviderUtilsImpl : FileProviderUtils {

    private const val FILE_PROVIDER_SUFFIX = ".fileprovider"

    override fun getAuthority(flavorTypeSuffix: String): String {

        return "${getApplicationId(flavorTypeSuffix)}$FILE_PROVIDER_SUFFIX"
    }
}
