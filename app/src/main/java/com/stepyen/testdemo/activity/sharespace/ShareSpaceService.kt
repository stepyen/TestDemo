package com.stepyen.testdemo.activity.sharespace

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.text.TextUtils
import androidx.core.app.NotificationCompat
import com.orhanobut.logger.Logger
import com.stepyen.testdemo.R

/**
 * date：2020-03-17
 * author：stepyen
 * description：
 *
 */
class ShareSpaceService:Service()  {

    companion object{
        // 消息
        const val CHANNEL_ID_MESSAGE = "CHANNEL_ID_MESSAGE"
    }

    var messageChannel: NotificationChannel? = null


    override fun onCreate() {
        super.onCreate()
        Logger.d("onCreate")

        sentNotification()

    }

    private fun sentNotification() {
        messageChannel = createNotificationChannel(CHANNEL_ID_MESSAGE, "消息", "接收重要的消息", NotificationManager.IMPORTANCE_DEFAULT)

        var builder = NotificationCompat.Builder(this, CHANNEL_ID_MESSAGE)
            .setSmallIcon(R.drawable.icon_dog)
            .setContentTitle("通知标题")
            .setContentText("通知内容：无所不能")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(123, builder.build())

    }

    /**
     * 创建通知渠道
     */
    private fun createNotificationChannel(channelId: String, channelName: String, channelDescription: String, importance: Int, gruopId: String? = ""): NotificationChannel? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
                setShowBadge(true)  // 显示角标数量
                if (!TextUtils.isEmpty(gruopId)) {
                    group = gruopId
                }
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            return channel
        }

        return null
    }


    override fun onBind(intent: Intent?): IBinder? {
        Logger.d("onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Logger.d("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d("onDestroy")
    }
}