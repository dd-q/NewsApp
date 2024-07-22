package com.loc.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    // app entry when the user clicks on get started in onboarding screen.
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}