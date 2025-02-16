package com.prado.lembrete.extension

import com.prado.lembrete.data.local.model.ReminderDb
import com.prado.lembrete.data.model.Reminder

fun ReminderDb.toReminder(): Reminder {
	return Reminder(
		id = id,
		name = name,
		hour = hour,
		minute = minute,
		messages = messages,
		repeatOnDays = repeatOnDays,
		randomMessage = randomMessage,
		isActive = isActive
	)
}
