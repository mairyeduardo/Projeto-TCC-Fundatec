package com.example.projetotcc.splash.domain

import com.example.projetotcc.login.data.repository.LoginRepository
import java.util.Date
import java.util.concurrent.TimeUnit

private const val MINUTES_TO_CACHE = 1

class IsValidCacheUseCase {
    private val repository by lazy { LoginRepository() }

    suspend fun isValidCache(): Boolean {
        val cacheDate = repository.getDateCache() ?: return false
        val minutes = Date().minuteAfter(cacheDate)
        val isValidCache = minutes <= MINUTES_TO_CACHE
        if (!isValidCache) repository.clearDateCache()

        return isValidCache
    }

    private fun Date.minuteAfter(date: Date): Long {
        return (this.time - date.time) / TimeUnit.MINUTES.toMillis(1)
    }
}