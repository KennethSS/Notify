package com.solar.notify

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.solar.notify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

        bind.notificationNormal.setOnClickListener {
            val notify = Notify.with {
                iconRes { R.mipmap.ic_launcher }
                appName { "App" }
                content {
                    standard {
                        title = "[광고] 삼성 리워즈 출시 이벤트!"
                        text = "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자!"
                    }
                }

            }
            notify.build().show(this)
        }

        bind.notificationBigText.setOnClickListener {
            val notify = Notify.with {
                iconRes { R.mipmap.ic_launcher }
                appName { "App" }
                content {
                    bigText {
                        title = "[광고] 삼성 리워즈 출시 이벤트!"
                        text = "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자!"
                    }
                }

            }
            notify.build().show(this)
        }

        /*bind.notificationPicture.setOnClickListener {
            NotificationFactory.notifyBigPicture(
                it.context,
                "[광고] 삼성 리워즈 출시 이벤트!",
                "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자! " +
                        "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자! " +
                        "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자!" +
                        " 삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자!",
                "http://lh3.googleusercontent.com/LRlnScFymC03y0BD14um5McyDRZDM1NAX78unjqVDF9rZG__go2UwE6pxEGglqLdv13ZsVgUIZOPxTiRYLYQ_Mo"
            )
        }

        bind.notificationInbox.setOnClickListener {
            NotificationFactory.notifyInbox(
                it.context,
                "[광고] 삼성 리워즈 출시 이벤트!",
                "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자! ",
                listOf(
                    "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자! ",
                    "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자!",
                    "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자!"
                )
            )
        }

        bind.notificationMessage.setOnClickListener {
            NotificationFactory.notifyMessage(
                it.context,
                "[광고] 삼성 리워즈 출시 이벤트!",
                "삼성 리워즈로 뭉쳐야 쏜다! 방콕/파타야 여행가자! "
            )
        }*/
    }
}