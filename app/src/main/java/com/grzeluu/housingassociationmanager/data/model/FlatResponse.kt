package com.grzeluu.housingassociationmanager.data.model

data class FlatResponse(
    val id: Long,
    val street: String,
    val number: String,
    val postcode: String,
    val city: String,
    val username: String
)
