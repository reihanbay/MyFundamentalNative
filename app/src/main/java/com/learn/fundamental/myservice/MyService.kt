package com.learn.fundamental.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {


    companion object {
        internal val TAG = MyService::class.simpleName
    }
    
    private val serviceJob = Job()
    private val serviceScope= CoroutineScope(Dispatchers.Main + serviceJob)
    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not Yet Implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service dijalankan...")
        serviceScope.launch { 
            delay(5000)
            stopSelf()
            Log.d(TAG, "Service Berhenti")
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceJob.cancel()
        Log.d(TAG, "onDestroy: ")
    }
}