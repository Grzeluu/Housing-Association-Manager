package com.grzeluu.housingassociationmanager.ui.utils

import android.content.Context
import android.widget.TextView
import com.grzeluu.housingassociationmanager.R

class TextColorUtils {
    companion object {
        fun TextView.setDependingOnPayment(payment: Double, context: Context) {
            val color =
                when {
                    (payment > 0) -> context.getColor(R.color.green)
                    (payment < 0) -> context.getColor(R.color.red)
                    else -> context.getColor(R.color.black)
                }

            this.text = payment.toString()
            this.setTextColor(color)
        }
    }
}