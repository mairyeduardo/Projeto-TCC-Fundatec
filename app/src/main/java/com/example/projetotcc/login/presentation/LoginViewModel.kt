package com.example.projetotcc.login.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState

    fun validacaoPreenchimento(
        email: String,
        password: String
    ) {
        if (email.isNullOrBlank() && password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowEmailPasswordError
            return
        } else if (email.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowEmailError
            return
        } else if (password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowPasswordError
            return
        } else if (email.contains("@") && email.contains(".com")) {
            viewState.value = LoginViewState.ShowHomeScreen
        } else {
            viewState.value = LoginViewState.ShowEmailError
        }
    }
}