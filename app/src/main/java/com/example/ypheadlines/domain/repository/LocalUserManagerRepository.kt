package com.example.ypheadlines.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalUserManagerRepository {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}