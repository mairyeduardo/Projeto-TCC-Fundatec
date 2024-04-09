package com.example.projetotcc.cadastro.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.cadastro.presentation.model.CadastroViewState
import com.example.projetotcc.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class CadastroViewModel: ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }

    private val viewState: MutableLiveData<CadastroViewState> = MutableLiveData()
    val state: LiveData<CadastroViewState> = viewState

    fun validacaoPreenchimento(
        name: String,
        email: String,
        password: String
    ) {

        if (name.isNullOrBlank() && email.isNullOrBlank() && password.isNullOrBlank()) {
            viewState.value = CadastroViewState.ShowNameEmailPasswordError
            return
        }
        else if (name.isNullOrBlank()){
            viewState.value = CadastroViewState.ShowNameError
            return
        }
        else if (email.isNullOrBlank()) {
            viewState.value = CadastroViewState.ShowEmailError
            return
        }
        else if (password.isNullOrBlank()) {
            viewState.value = CadastroViewState.ShowPasswordError
            return
        }
        else if (email.contains("@") && email.contains(".com")
        ) {
            viewModelScope.launch {
                val isSuccess = useCase.createUser(
                    nome = name,
                    email = email,
                    senha = password,
                )
                if (isSuccess) {
                    viewState.value = CadastroViewState.ShowLoginScreen
                } else {
                    viewState.value = CadastroViewState.ShowGeralError
                }
            }
        }
        else {
            viewState.value = CadastroViewState.ShowEmailError
        }
    }
}