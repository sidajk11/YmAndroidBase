package com.example.ymsamplexml

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val LOG_TAG = javaClass.simpleName
    // Activity에서 접근 가능
    companion object {
        const val ACTION_CREATE = "create"
        const val ACTION_DELETE = "delete"
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val action = intent?.action

        when(action) {
            ACTION_CREATE -> create()
            ACTION_DELETE -> delete()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun create() {
        Log.d(LOG_TAG, "create()가 호출 됨")
    }

    private fun delete() {
        Log.d(LOG_TAG, "delete()가 호출 됨")
    }
}