package com.gstv.paymentslist.database

import com.gstv.paymentslist.database.Payment
import com.gstv.paymentslist.database.PaymentsDao

class PaymentsRepository(private val paymentsDao: PaymentsDao) {
    val allPayments = paymentsDao.getAllPayments()
    suspend fun insert(payment: Payment) = paymentsDao.insertPayment(payment)
    suspend fun delete(payment: Payment) = paymentsDao.deletePayment(payment)
    suspend fun update(payment: Payment) = paymentsDao.updatePayment(payment)
}