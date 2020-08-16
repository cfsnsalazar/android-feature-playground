package org.js.denisvieira.featureplayground.commons.cache.converter

import androidx.room.TypeConverter
import org.js.denisvieira.featureplayground.commons.cache.TypeTransformable
import java.util.Date

class DateConverter : TypeTransformable<Long, Date> {

    @TypeConverter
    override fun from(input: Long?) = input?.let { Date(input) }

    @TypeConverter
    override fun to(response: Date?) = response?.time
}
