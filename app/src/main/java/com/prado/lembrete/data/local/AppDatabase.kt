package com.prado.lembrete.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prado.lembrete.data.local.dao.ReminderDao
import com.prado.lembrete.data.local.model.ReminderDb

@Database(
	entities = [
		ReminderDb::class
	],
	version = 1
)
@TypeConverters(AppDatabaseTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
	
	abstract fun reminderDao(): ReminderDao
	
	companion object {
		private var INSTANCE: AppDatabase? = null
		
		fun getInstance(context: Context): AppDatabase {
			if (INSTANCE == null) {
				synchronized(AppDatabase::class) {
					INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "app.db")
						.fallbackToDestructiveMigration()
						.build()
				}
			}
			
			return INSTANCE!!
		}
	}
}