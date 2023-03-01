package com.example.brainstorm.domain.repository

import com.example.brainstorm.domain.entity.GameSettings
import com.example.brainstorm.domain.entity.Level
import com.example.brainstorm.domain.entity.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question
    fun getGameSettings(level: Level): GameSettings
}