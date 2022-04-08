package com.grzeluu.housingassociationmanager.ui.utils.snap

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class SnapUtils {
    companion object {
        fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
            val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
            val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
            return layoutManager.getPosition(snapView)
        }
    }
}