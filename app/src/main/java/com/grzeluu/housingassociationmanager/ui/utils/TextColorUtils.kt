package com.grzeluu.housingassociationmanager.ui.utils

import android.content.Context
import android.widget.TextView
import com.grzeluu.housingassociationmanager.R

class TextColorUtils {
    companion object {
        fun TextView.setDependingOnPayment(payment: Double, context: Context) {
            val color = if (payment >= 0) context.getColor(R.color.green)
            else context.getColor(R.color.red)

            this.setTextColor(color)
        }
    }
}