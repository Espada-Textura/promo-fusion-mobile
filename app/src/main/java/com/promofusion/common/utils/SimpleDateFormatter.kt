package com.promofusion.common.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun getFormattedDate(dateString: String, format: String = "MMM dd, yyyy"): String {
    return try {
        val parser = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formatter = SimpleDateFormat(format, Locale.getDefault())
        val parsedDate = parser.parse(dateString)
        formatter.format(parsedDate ?: return "Invalid date")
    } catch (e: Exception) {
        "Invalid date"
    }
}