package com.prado.lembrete.data.repository.di

import androidx.datastore.core.DataStore
import com.prado.lembrete.UserPreferences
import com.prado.lembrete.data.local.AppDatabase
import com.prado.lembrete.data.repository.ReminderRepository
import com.prado.lembrete.data.repository.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
	
	@Provides
	@Singleton
	fun provideReminderRepository(
		appDatabase: AppDatabase
	): ReminderRepository = ReminderRepository(
		reminderDao = appDatabase.reminderDao()
	)
	
	@Provides
	@Singleton
	fun provideUserPreferencesRepository(
		userPreferencesDataStore: DataStore<UserPreferences>
	): UserPreferencesRepository = UserPreferencesRepository(
		userPreferencesDataStore = userPreferencesDataStore
	)
	
}