package com.prado.lembrete.data.local.dao

import androidx.room.*
import com.prado.lembrete.data.local.model.ReminderDb
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
	
	@Query("SELECT * FROM reminder")
	fun getAllReminders(): Flow<List<ReminderDb>>
	
	@Query("SELECT * FROM reminder WHERE reminder_id LIKE :mID")
	fun getReminderById(mID: Int): Flow<ReminderDb?>
	
	@Update
	fun updateReminder(vararg reminder: ReminderDb)
	
	@Delete
	fun deleteReminder(vararg reminder: ReminderDb)
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertReminder(vararg reminder: ReminderDb)
	
}