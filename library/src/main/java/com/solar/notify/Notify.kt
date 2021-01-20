package com.solar.notify

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

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
class Notify {

    var content: NotifyContent? = null
    var iconRes: Int = 0
    var appName: String = ""

    fun show(context: Context) {
        content?.let { content ->
            notify(context, NotifyFactory(context, NotifyOptions.channelId).getNotifyBuilder(content))
        }
    }

    private fun notify(context: Context, notification: Notification) {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NotifyOptions.channelId,
                NotifyOptions.channelName,
                NotificationManager.IMPORTANCE_HIGH).apply {

                description = NotifyOptions.channelDesc
                //enableLights(true)
                //enableVibration(true)
                //lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                //lightColor = Color.GREEN
                //vibrationPattern = longArrayOf(100, 200, 100, 200)
                //setShowBadge(true)
            }

            nm.createNotificationChannel(notificationChannel)
        }

        nm.notify(Util.getRandomInt(), notification)
    }

    companion object {
        fun with(init: NotifyBuilder.() -> Unit): NotifyBuilder {
            return NotifyBuilder(init)
        }
    }
}

