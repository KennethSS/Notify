package com.solar.notify

import android.app.Notification
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
class NotifyOptions {
    companion object {
        val whenNotify: Long
            get() = System.currentTimeMillis()

        val priority: Int
            get() = NotificationCompat.PRIORITY_MAX

        val autoCancel: Boolean
            get() = true

        val defaults: Int
            get() = Notification.DEFAULT_ALL

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
        val channelId: String
            get() = "Notify"

        val channelName: String
            get() = "Notify"

        val channelDesc: String
            get() = "This is Notify channel"
    }
}