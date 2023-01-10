package com.rezanazari.core.utils

import android.content.Context
import com.rezanazari.core.R
import java.math.BigDecimal
import java.text.DecimalFormat
import kotlin.math.abs
import kotlin.math.ln


object NumberUtils {

    fun separateThousands(price: BigDecimal?): String? {
        if (price == null) return null
        val dec = DecimalFormat("#,###")
        return dec.format(price)
    }


    fun generatePercentNumber(price: Double, context: Context): String {
        val positiveNumber = abs(price)
        return if (price < 0) context.getString(R.string.number_percent_negative, positiveNumber)
        else context.getString(R.string.number_percent_positive, positiveNumber)
    }


    fun addRialAndFormat(price: BigDecimal, context: Context): String {
        return context.getString(R.string.number_rial, separateThousands(price))
    }

    fun isAllDigits(str: String) =
        str.matches("-?\\d+(\\.\\d+)?".toRegex())

    fun convertStringToBigDecimal(str: String?): BigDecimal {
        val defaultBigDecimal = BigDecimal(0)
        if (str == null) return defaultBigDecimal
        return if (isAllDigits(str)) BigDecimal(str) else defaultBigDecimal
    }

    fun suffixedNumberFormat(count: Double): String {
        if (count < 1000) return "" + count
        val exp = (ln(count) / ln(1000.0)).toInt()
        val format = DecimalFormat("0.#")
        val value = format.format(count / Math.pow(1000.0, exp.toDouble()))
        return String.format("%s %c", value, "kMBTPE"[exp - 1])
    }

}