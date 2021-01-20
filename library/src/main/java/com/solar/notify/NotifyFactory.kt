package com.solar.notify

import android.app.Notification
import android.content.Context
import android.graphics.Color
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat

/**
 * Copyright 2020 Kenneth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
class NotifyFactory(private val context: Context,
                    private val channelId: String) {

    fun getNotifyBuilder(content: NotifyContent): Notification = run {
        when(content) {
            is NotifyContent.Standard -> getStandardNotification(content)
            is NotifyContent.BigText -> getBigTextNotification(content)
            is NotifyContent.BigPicture -> getBigPictureNotification(content)
        }.build()
    }

    private fun getStandardNotification(content: NotifyContent.Standard) = run {
        getNotificationBuilder(context, channelId, content)
            .setSmallIcon(context.applicationInfo.icon)
            .setOptions()
    }

    private fun getBigTextNotification(content: NotifyContent.BigText) = run {
        getNotificationBuilder(context, channelId, content)
            .setSmallIcon(context.applicationInfo.icon)
            .setOptions()
            .setStyle(bigTextStyle(content))
    }

    private fun getBigPictureNotification(content: NotifyContent.BigPicture) = run {
        getNotificationBuilder(context, channelId, content)
            .setSmallIcon(context.applicationInfo.icon)
            .setOptions()
            .setStyle(bigPictureStyle(content))
    }

    private fun getNotificationBuilder(
        context: Context,
        channelId: String,
        content: NotifyContent.BasicNotify
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, channelId)
            .setContentTitle(content.title)
            .setContentText(content.text)
    }

    private fun NotificationCompat.Builder.setOptions() = run {
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        //setSmallIcon(iconRes)
        setColor(Color.parseColor("#7469C4"))  // small icon background color
        //.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
        //.setContentTitle(context.getResources().getString(R.string.app_name))
        //.setTicker("")
        .setWhen(NotifyOptions.whenNotify)
        .setAutoCancel(NotifyOptions.autoCancel)
        .setSound(defaultSoundUri)
        .setPriority(NotifyOptions.priority)
        .setDefaults(NotifyOptions.defaults)
        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
    }


    // Style
    private fun bigTextStyle(content: NotifyContent.BasicNotify) = run {
        NotificationCompat.BigTextStyle()
            .bigText(content.text)
            .setBigContentTitle(content.title)
    }

    private fun bigPictureStyle(content: NotifyContent.BigPicture) = run {
        NotificationCompat.BigPictureStyle()
            .setSummaryText(content.text)
            .setBigContentTitle(content.title)
            .bigPicture(content.bitmap)
    }
}