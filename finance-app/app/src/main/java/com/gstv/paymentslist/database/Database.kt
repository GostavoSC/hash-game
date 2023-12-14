package com.gstv.paymentslist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATA_BASE_NAME = "payment_database"
@Database(entities = [Payment::class], version = 1, exportSchema = false)
abstract class FinanceDatabase : RoomDatabase() {

    abstract fun getNotesDao(): PaymentsDao

    companion object {
        @Volatile
        private var INSTANCE: FinanceDatabase? = null

        fun getDatabase(context: Context): FinanceDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FinanceDatabase::class.java,
                    DATA_BASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}