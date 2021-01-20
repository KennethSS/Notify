package com.solar.notify

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
class NotifyBuilder constructor(init: NotifyBuilder.() -> Unit) {

    private var iconRes: Int = 0
    private var appName: String = "Notify"
    private var content: NotifyContent? = null

    init {
        init()
    }

    fun iconRes(init: () -> Int) {
        iconRes = init()
    }

    fun content(init: NotifyContentBuilder.() -> NotifyContent) {
        content = init(NotifyContentBuilder())
    }

    fun appName(init: () -> String) {
        appName = init()
    }

    fun build() = Notify().also { notify ->
        notify.iconRes = this.iconRes
        notify.appName = this.appName
        notify.content = this.content
    }
}