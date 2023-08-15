package com.example.ypheadlines.domain.usecase

import com.example.ypheadlines.domain.repository.LocalUserManagerRepository
import javax.inject.Inject

class SaveAppEntryUseCase @Inject constructor(
    private val localUserManagerRepository: LocalUserManagerRepository
) {
    suspend operator fun invoke() {
        localUserManagerRepository.saveAppEntry()
    }
}