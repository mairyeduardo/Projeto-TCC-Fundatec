package com.example.projetotcc.splash.view.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotcc.splash.domain.IsValidCacheUseCase
import com.example.projetotcc.splash.view.presentation.model.SplashViewState
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val useCase by lazy {
        IsValidCacheUseCase()
    }

    private val viewState: MutableLiveData<SplashViewState> = MutableLiveData()
    val state: LiveData<SplashViewState> = viewState

    private fun validateUserCache() {
        viewModelScope.launch {
            if (useCase.isValidCache()) {
                viewState.value = SplashViewState.ShowHome
            } else {
                viewState.value = SplashViewState.ShowLogin
            }
        }
    }

    init {
        validateUserCache()
    }
}