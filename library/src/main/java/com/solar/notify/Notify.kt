package com.solar.notify

import android.content.Context

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
class Notify internal constructor(internal val context: Context){


    var iconRes: Int = 0

    var content: NotifyContent? = null

    fun notify(type: NotifyContent): Notify {
        this.content = type
        return this
    }

    @JvmName("setIconRes1")
    fun setIconRes(iconRes: Int) : Notify {
        this.iconRes = iconRes
        return this
    }

    fun show() {
        content?.let {
            when(it) {
                is NotifyContent.Standard -> {
                    NotificationFactory.notifyNormal(context, iconRes, it.title, it.text)
                }
            }
        }
    }


    fun getNormalContent() = also {

    }


    companion object {
        fun with(context: Context): Notify {
            return Notify(context)
        }
    }
}