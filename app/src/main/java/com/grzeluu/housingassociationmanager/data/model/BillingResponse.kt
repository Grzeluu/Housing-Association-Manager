package com.grzeluu.housingassociationmanager.data.model

data class BillingResponse(
    val flatId: Long,
    val detailsId: Long,
    val title: String,
    val date: String,
    val endDate: String,
    val balance: Double,
    val chargedFee: Double,
    val payment: Double,
    val toPay: Double,
    val status: Boolean,
    val username: String,
)
