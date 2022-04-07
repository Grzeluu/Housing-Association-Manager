package com.grzeluu.housingassociationmanager.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.grzeluu.housingassociationmanager.data.model.LoginRequest
import com.grzeluu.housingassociationmanager.data.network.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService
) {

    fun loginUser(login: String, password: String) {
        TODO()
    }
}