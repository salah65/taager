package com.Tagger.taager.data.core

import java.text.SimpleDateFormat
import java.util.*

fun Int.convertIntToTime(): String {
    val date = Date(this.toLong())
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.ENGLISH)
    return try {

        format.format(date)
    } catch (e: Exception) {
        ""
    }
}