package com.grzeluu.housingassociationmanager.data.model

data class MeterState(
    val flatBillId: Long,
    val coldWaterMeterState: Double,
    val hotWaterMeterState: Double,
    val centralHeatingMeterState: Double
)
