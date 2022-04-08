package com.grzeluu.housingassociationmanager.ui.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import com.grzeluu.housingassociationmanager.R

class ImageViewUtils {
    companion object {
        fun ImageView.setStatusIcon(status: Boolean, context: Context) {
            val icon: Drawable
            val color: Int

            if (status) {
                icon = AppCompatResources.getDrawable(context, R.drawable.ic_cancel)!!
                color = context.getColor(R.color.red)
            } else {
                icon = AppCompatResources.getDrawable(context, R.drawable.ic_checkbox)!!
                color = context.getColor(R.color.green)
            }
            this.setImageDrawable(icon)
            this.setColorFilter(color)
        }
    }
}