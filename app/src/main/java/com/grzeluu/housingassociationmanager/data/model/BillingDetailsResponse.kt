package com.grzeluu.housingassociationmanager.data.model

data class BillingDetailsResponse(
    val flatBillId: Long,
    val coldWater: Double,
    val hotWater: Double,
    val centralHeating: Double,
    val wasteDisposal: Double,
    val estateOperation: Double,
    val renovationFund: Double,
    val managerSalary: Double,
    val overpayment: Double,
    val sum: Double,
    val meterState: MeterState
)