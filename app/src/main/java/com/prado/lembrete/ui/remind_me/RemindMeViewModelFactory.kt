package com.prado.lembrete.ui.remind_me

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prado.lembrete.common.RemindMeAlarmManager
import com.prado.lembrete.data.repository.ReminderRepository
import com.prado.lembrete.data.repository.UserPreferencesRepository

class RemindMeViewModelFactory(
	private val reminderRepository: ReminderRepository,
	private val remindMeAlarmManager: RemindMeAlarmManager,
	private val userPreferencesRepository: UserPreferencesRepository
): ViewModelProvider.Factory {
	
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if (RemindMeViewModel::class.java.isAssignableFrom(modelClass)) {
			return RemindMeViewModel(reminderRepository, remindMeAlarmManager, userPreferencesRepository) as T
		}
		
		return modelClass
			.getConstructor(
				ReminderRepository::class.java,
				RemindMeAlarmManager::class.java,
				UserPreferencesRepository::class.java
			)
			.newInstance(reminderRepository, remindMeAlarmManager, userPreferencesRepository)
	}
}