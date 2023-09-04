package com.semenchuk.utils

import android.util.Log
import java.util.regex.Pattern

class UrlIdExtractor {
    companion object {
        fun extractIdFromUrl(url: String?): Int? =
            url?.let {
                val pattern = Pattern.compile("\\d+")
                val matcher = pattern.matcher(it)
                if (matcher.find()) matcher.group().toInt() else null
            }

        fun bulkExtractIdsFromUrls(urls: List<String?>): List<Int?> {
            Log.d("TAG", "bulkExtractIdsFromUrls come: $urls")
            val res = urls.mapNotNull { url ->
                url?.let { nonNullUrl ->
                    val pattern = Pattern.compile("\\d+")
                    val matcher = pattern.matcher(nonNullUrl)
                    if (matcher.find()) matcher.group().toInt() else null
                }
            }
            Log.d("TAG", "bulkExtractIdsFromUrls out: $res")
            return res
        }


    }
}