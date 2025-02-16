package com.prado.lembrete.ui.remind_me

import com.prado.lembrete.UserPreferences
import com.prado.lembrete.data.model.Reminder

data class RemindMeUiState(
    val reminders: List<Reminder> = emptyList(),
    val userPreferences: UserPreferences = UserPreferences(),
    val selectedReminder: Reminder? = null,
    val isDetailOnlyOpen: Boolean = false,
    val showDeleteConfirmationDialog: Boolean = false,
    val error: String? = null
)
