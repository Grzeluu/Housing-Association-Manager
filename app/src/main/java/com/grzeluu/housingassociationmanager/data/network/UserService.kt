package com.grzeluu.housingassociationmanager.data.network

import com.grzeluu.housingassociationmanager.data.model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface UserService {
    @POST(ApiConstants.LOGIN_URL)
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginRequest
}