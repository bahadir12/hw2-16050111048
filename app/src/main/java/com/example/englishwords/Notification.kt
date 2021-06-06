package com.example.englishwords

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import androidx.core.app.NotificationCompat
import java.util.*

class Notification:Service() {
    val NOTIFICATION_CHANNEL_ID = "10001"
    private val default_notification_channel_id = "default"
    var timer: Timer? = null
    var timerTask: TimerTask? = null
    var Your_X_SECS: Long = 43200000

    override fun onBind(arg0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        startTimer()
        return START_STICKY
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
        stopTimerTask()
        super.onDestroy()
    }

    //we are going to use a handler to be able to run in our TimerTask
    val handler: Handler = Handler()

    private fun startTimer() {
        timer = Timer()
        initializeTimerTask()
        timer!!.schedule(timerTask, 200000, Your_X_SECS) //

    }

    private fun stopTimerTask() {
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }

    private fun initializeTimerTask() {
        timerTask = object : TimerTask() {
            override fun run() {
                handler.post(Runnable { createNotification() })
            }
        }
    }

    private fun createNotification(){
        val intent = PendingIntent.getActivity(this,1, Intent(applicationContext, Memorize::class.java), PendingIntent.FLAG_UPDATE_CURRENT)
        val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val mBuilder = NotificationCompat.Builder(applicationContext, default_notification_channel_id)
        mBuilder.setContentTitle("Reminding!!")
            mBuilder.setContentText("English Words waiting for you.")
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground)
        mBuilder.addAction(R.drawable.ic_launcher_background, "Open English Words", intent)
        mBuilder.setAutoCancel(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "NOTIFICATION_CHANNEL_NAME",
                importance
            )
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
            mNotificationManager.createNotificationChannel(notificationChannel)
        }
        mNotificationManager.notify(System.currentTimeMillis().toInt(), mBuilder.build())
    }
}