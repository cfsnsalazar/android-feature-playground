package org.js.denisvieira.featureplayground.commons.cache

interface TypeTransformable<DATABASE_VALUE, APP_VALUE> {

    fun from(input: DATABASE_VALUE?): APP_VALUE?

    fun to(response: APP_VALUE?): DATABASE_VALUE?
}
