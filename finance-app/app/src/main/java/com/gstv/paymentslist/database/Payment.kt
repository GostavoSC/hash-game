package com.gstv.paymentslist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val date: Date,
    val title: String,
    @ColumnInfo("is_done") val isDone: Boolean
)
