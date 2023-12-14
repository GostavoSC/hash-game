package com.gstv.paymentslist.database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface PaymentsDao {
    @Insert
    suspend fun insertPayment(payment: Payment)

    @Delete
    suspend fun deletePayment(payment: Payment)

    @Update
    suspend fun updatePayment(payment: Payment)

    @Query("Select * from payments order by id ASC")
    fun getAllPayments(): LiveData<List<Payment>>

}