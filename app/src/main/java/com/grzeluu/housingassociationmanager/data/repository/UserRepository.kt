package com.grzeluu.housingassociationmanager.data.repository

import android.util.Base64
import com.grzeluu.housingassociationmanager.data.network.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService
) {

    suspend fun loginUser(login: String, password: String) {
        //TODO check authorisation ???
        //TODO return something

        val authPayload = "$login:$password"
        val data = authPayload.toByteArray()
        val base64 = Base64.encodeToString(data, Base64.NO_WRAP)

        val call = userService.authUser("Basic $base64".trim())
    }

    suspend fun getBalance() = userService.getBalance()

    suspend fun getProfile() = userService.getProfile()

    suspend fun getFlats() = userService.getFlats()

    suspend fun getBillings() = userService.getBillings()

    suspend fun getBillingDetails(billingId: Long) = userService.getBillingDetails(billingId)
}