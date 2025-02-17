package com.prado.lembrete.data.local

import com.prado.lembrete.data.DayOfWeek
import com.prado.lembrete.data.model.Reminder

object LocalRemindersDataProvider {
	
	val allReminders = listOf(
		Reminder(
			id = 0,
			name = "Ngodinh",
			hour = 18,
			minute = 23,
			messages = listOf("Message 1", "Looooooooonnnnggggggggg Messageeeee", "Message 2"),
			repeatOnDays = listOf(DayOfWeek.Sunday, DayOfWeek.Tuesday, DayOfWeek.Thursday, DayOfWeek.Friday),
			randomMessage = true,
			isActive = true
		),
		Reminder(
			id = 1,
			name = "Bangun",
			hour = 18,
			minute = 23,
			messages = listOf("Message 1", "Looooooooonnnnggggggggg Messageeeee", "Message 2"),
			repeatOnDays = listOf(DayOfWeek.Monday, DayOfWeek.Thursday, DayOfWeek.Saturday),
			randomMessage = false,
			isActive = false
		),
	)
	
}