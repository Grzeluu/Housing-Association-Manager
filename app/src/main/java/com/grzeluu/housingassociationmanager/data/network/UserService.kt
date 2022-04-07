package com.grzeluu.housingassociationmanager.data.network

import com.grzeluu.housingassociationmanager.data.model.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    @POST(ApiConstants.LOGIN_URL)
    suspend fun authUser(
        @Header("Authorization") authorization: String
    )

    @GET(ApiConstants.BALANCE_URL)
    suspend fun getBalance(): BalanceResponse

    @GET(ApiConstants.PROFILE_URL)
    suspend fun getProfile(): ProfileResponse

    @GET(ApiConstants.FLATS_URL)
    suspend fun getFlats(): List<FlatResponse>

    @GET(ApiConstants.BILLINGS_URL)
    suspend fun getBillings(): List<BillingResponse>

    @POST(ApiConstants.BILLING_DETAILS_URL)
    suspend fun getBillingDetails(
        @Field("billingId") billingId: Long
    ): Call<BillingDetailsResponse>
}