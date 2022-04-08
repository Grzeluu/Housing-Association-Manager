package com.grzeluu.housingassociationmanager.ui.settlements.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.grzeluu.housingassociationmanager.R
import com.grzeluu.housingassociationmanager.data.model.BillingResponse
import com.grzeluu.housingassociationmanager.databinding.ItemBillingBinding
import com.grzeluu.housingassociationmanager.ui.utils.TextColorUtils.Companion.setDependingOnPayment
import com.grzeluu.housingassociationmanager.ui.settlements.adapter.BillingAdapter.BillingViewHolder
import com.grzeluu.housingassociationmanager.ui.utils.ImageViewUtils.Companion.setStatusIcon

class BillingAdapter :
    ListAdapter<BillingResponse, BillingViewHolder>(
        BillingDiffUtilCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BillingViewHolder {
        val binding = ItemBillingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BillingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BillingViewHolder, position: Int) {
        getItem(position).let { billing ->
            holder.bind(billing)
        }
    }

    class BillingViewHolder(private val binding: ItemBillingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(billing: BillingResponse) {
            with(binding) {
                tvTitle.text = billing.title
                tvDate.text = billing.date
                tvEndDate.text = billing.endDate
                tvPayment.text = billing.payment.toString()

                lblToPay.text =
                    if (billing.toPay < 0) context.getString(R.string.excess_payment)
                    else context.getString(R.string.to_pay)

                tvBalance.setDependingOnPayment(billing.balance, context)
                tvChargedFee.setDependingOnPayment(-billing.chargedFee, context)
                tvToPay.setDependingOnPayment(-billing.toPay, context)

                ivStatus.setStatusIcon(billing.status, context)
            }
        }
    }
}

class BillingDiffUtilCallback : DiffUtil.ItemCallback<BillingResponse>() {
    override fun areItemsTheSame(oldItem: BillingResponse, newItem: BillingResponse): Boolean {
        return oldItem.detailsId == newItem.detailsId
    }

    override fun areContentsTheSame(oldItem: BillingResponse, newItem: BillingResponse): Boolean {
        return oldItem.date == newItem.date &&
                oldItem.endDate == newItem.endDate &&
                oldItem.flatId == newItem.flatId
    }
}
