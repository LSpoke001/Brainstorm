package com.example.brainstorm.domain.usecases

import com.example.brainstorm.domain.entity.GameSettings
import com.example.brainstorm.domain.entity.Level
import com.example.brainstorm.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}