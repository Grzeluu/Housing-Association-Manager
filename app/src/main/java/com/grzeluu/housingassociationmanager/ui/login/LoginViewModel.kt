package com.grzeluu.housingassociationmanager.ui.login

import androidx.lifecycle.*
import com.grzeluu.housingassociationmanager.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()

    fun loginUser() = viewModelScope.launch {
        TODO()
    }
}