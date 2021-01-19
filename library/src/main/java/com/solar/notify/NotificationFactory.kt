package com.solar.notify

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


/**
 *  Notification Channel
 *  사용자가 볼 수 있는 중요도 수준	                중요도(Android 8.0 이상)	우선순위(Android 7.1 이하)
 *  (긴급) 알림음이 울리며 헤드업 알림으로 표시됩니다.      IMPORTANCE_HIGH	        PRIORITY_HIGH 또는 PRIORITY_MAX
 *  (높음) 알림음이 울립니다.                         IMPORTANCE_DEFAULT	    PRIORITY_DEFAULT
 *  (중간) 알림음이 없습니다.	                        IMPORTANCE_LOW	        PRIORITY_LOW
 *  (낮음) 알림음이 없고 상태 표시줄에 표시되지 않습니다.	IMPORTANCE_MIN	        PRIORITY_MIN
 *  NotificationManager.IMPORTANCE_DEFAULT
 *
 *  - 단, Android 7.1 이하를 지원하려면 위에 표시된 대로 setPriority()를 사용하여 우선순위를 설정해야 합니다.
 *  - 채널을 Notification Manager 에 제출한 후에는 중요도 수준을 변경할 수 없습니다
 */

object NotificationFactory {

    /*fun makeNotification (context: Context, title: String, text: String) {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "channeld_id"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                getNotificationChannel(channelId, "Channel_name", "Channel_desc!")

            nm.createNotificationChannel(notificationChannel)
        }

        val pendingIntent = PendingIntent.getActivity(context, 0, getDestinyIntent(context), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context, channelId, title, text, pendingIntent)

        nm.notify(1, builder.build())
    }*/

    private fun notify(context: Context,
                       channelId: String,
                       notification: Notification) {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel =
                getNotificationChannel(channelId, "Channel_name", "Channel_desc!")

            nm.createNotificationChannel(notificationChannel)
        }

        nm.notify(Util.getRandomInt(), notification)
    }

    fun notifyNormal(context: Context, iconRes: Int, title: String, text: String) {
        val channelId = "channeld_id"
        val pendingIntent = PendingIntent.getActivity(context, 0, getDestinyIntent(context), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context, iconRes, channelId, title, text, pendingIntent)

        //builder.addAction(R.drawable.ic_baseline_access_time_24, "Snooze!", pendingIntent)
        //builder.addAction(R.drawable.ic_baseline_access_time_24, "Snooze 2", pendingIntent)
        //builder.addInvisibleAction(R.drawable.ic_baseline_access_time_24, "Snooze 3", pendingIntent)

        notify(context,  channelId, builder.build())
    }

    /*fun notifyBigText(context: Context, title: String, text: String) {
        val channelId = "channeld_id"
        val pendingIntent = PendingIntent.getActivity(context, 0, getDestinyIntent(context), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context, channelId, title, text, pendingIntent)


        notify(context,  channelId, builder.build())
    }*/

    /*private fun getBigStyleNotification() {
        val bigStyle = NotificationCompat.BigTextStyle()
            .bigText(text)
            .setBigContentTitle(title)
        builder.setStyle(bigStyle)
    }*/

    /*fun notifyBigPicture(context: Context, title: String, text: String, imgUrl: String) {
        val channelId = "channeld_id"
        val pendingIntent = PendingIntent.getActivity(context, 0, getDestinyIntent(context), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context, channelId, title, text, pendingIntent)

        Thread {
            val bitmap: Bitmap = urlToBitmap(imgUrl)
            builder.setLargeIcon(bitmap)
            val bigStyle = NotificationCompat.BigPictureStyle()
                .bigPicture(bitmap)
                .setBigContentTitle(title)

            builder.setStyle(bigStyle)
            notify(context,  channelId, builder.build())
        }.start()
    }

    fun notifyInbox(context: Context, title: String, text: String, line: List<String>) {
        val channelId = "channeld_id"
        val pendingIntent = PendingIntent.getActivity(context, 0, getDestinyIntent(context), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context, channelId, title, text, pendingIntent)
        val bigStyle = NotificationCompat.InboxStyle()
            .setBigContentTitle(title)

        line.forEach {
            bigStyle.addLine(it)
        }

        builder.setStyle(bigStyle)

        notify(context,  channelId, builder.build())
    }

    fun notifyMessage(context: Context, title: String, text: String) {
        val channelId = "channeld_id"
        val pendingIntent = PendingIntent.getActivity(context, 0, getDestinyIntent(context), PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context, channelId, title, text, pendingIntent)
        *//*val androidPerson = android.app.Person.Builder().setName("kenneth")
            .build()*//*
        val bundle = Bundle().apply {
            putCharSequence("name", "kenneth")
        }
        val person = Person.fromBundle(bundle)

        val message = NotificationCompat.MessagingStyle.Message("Hi Guys", System.currentTimeMillis(), person)
        val messageStyle = NotificationCompat.MessagingStyle(person)
            .addMessage(message)

        builder.setStyle(messageStyle)

        notify(context, channelId, builder.build())
    }

    private fun urlToBitmap(path: String): Bitmap {
        return try {
            val url = URL(path)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) { // Log exception
            Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888)
        }
    }*/

    private fun getDestinyIntent(context: Context): Intent {
        return Intent(Intent.ACTION_CALL)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getNotificationChannel(id: String, name: String, desc: String): NotificationChannel {
        return NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH).apply {
            description = desc
            //enableLights(true)
            //enableVibration(true)
            //lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            //lightColor = Color.GREEN
            //vibrationPattern = longArrayOf(100, 200, 100, 200)
            //setShowBadge(true)
        }
    }

    private fun getNotificationBuilder(context: Context,
                                       iconRes: Int,
                                       channelId: String,
                                       title: String,
                                       text: String,
                                       pendingIntent: PendingIntent?): NotificationCompat.Builder {
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        return NotificationCompat.Builder(context, channelId)
            .setSmallIcon(iconRes)
            .setColor(Color.parseColor("#7469C4"))  // small icon background color
            //.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
            //.setContentTitle(context.getResources().getString(R.string.app_name))
            .setTicker("")
            .setWhen(System.currentTimeMillis())
            .setContentTitle(title)
            .setContentText(text)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentIntent(pendingIntent)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setNumber(100)
    }
}