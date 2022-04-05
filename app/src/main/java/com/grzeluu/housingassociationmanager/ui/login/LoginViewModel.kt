package com.grzeluu.housingassociationmanager.ui.login

import androidx.lifecycle.ViewModel
import com.grzeluu.housingassociationmanager.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {

    private fun isLoginValid(login: String) =
        login.length >= Constants.MIN_USERNAME_LENGTH

    fun connectUser(login: String, password: String) {

    }
}