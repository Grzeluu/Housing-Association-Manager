package com.grzeluu.housingassociationmanager.ui.settlements.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.grzeluu.housingassociationmanager.R
import com.grzeluu.housingassociationmanager.data.model.FlatResponse
import com.grzeluu.housingassociationmanager.databinding.ItemFlatBinding
import com.grzeluu.housingassociationmanager.ui.settlements.adapter.FlatsAdapter.FlatViewHolder
import com.grzeluu.housingassociationmanager.ui.utils.TextColorUtils.Companion.setDependingOnPayment

class FlatsAdapter :
    ListAdapter<FlatResponse, FlatViewHolder>(
        FlatsDiffUtilCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FlatViewHolder {
        val binding = ItemFlatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FlatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlatViewHolder, position: Int) {
        getItem(position).let { flat ->
            holder.bind(flat)
        }
    }

    class FlatViewHolder(private val binding: ItemFlatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(billing: FlatResponse) {
            with(binding) {
                tvFullAddress.text = context.getString(
                    R.string.full_address,
                    billing.city,
                    billing.street,
                    billing.number
                )
            }
        }
    }
}

class FlatsDiffUtilCallback : DiffUtil.ItemCallback<FlatResponse>() {
    override fun areItemsTheSame(oldItem: FlatResponse, newItem: FlatResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FlatResponse, newItem: FlatResponse): Boolean {
        return oldItem.street == newItem.street &&
                oldItem.number == newItem.number &&
                oldItem.postcode == newItem.postcode
    }
}