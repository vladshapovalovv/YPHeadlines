package com.example.ypheadlines.domain.usecase

import com.example.ypheadlines.domain.repository.LocalUserManagerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadAppEntryUseCase @Inject constructor(
    private val localUserManagerRepository: LocalUserManagerRepository
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManagerRepository.readAppEntry()
    }
}