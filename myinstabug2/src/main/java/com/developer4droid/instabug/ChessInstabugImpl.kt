package com.developer4droid.instabug

import android.app.Application
import com.instabug.chat.Chats
import com.instabug.chat.Replies
import com.instabug.library.Feature
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent

import javax.inject.Inject

private const val LIVE_KEY = "2222222"
private const val BETA_KEY = "1111111"
private const val USERNAME = "username"
private const val USER_ID = "userId"
private const val PREMIUM_STATUS = "premiumStatus"

internal class ChessInstabugImpl @Inject constructor() : ChessInstabug {

    @Suppress("ConstantConditionIf")
    private val key = if (BuildConfig.DEBUG || BuildConfig.BUILD_TYPE == "qa") BETA_KEY else LIVE_KEY

    override fun init(application: Application) {
        Instabug.Builder(application, key)
            .setInvocationEvents(InstabugInvocationEvent.NONE)
            .build()
    }

    /**
     * Will disable Replies and Chat features and show popup for instabug.
     * Disable features here to avoid crashes, since their SDK require onResume lifecycle call.
     * Thus this has to be shown inside of [Activity#onResume]
     */
    override fun show() {
        Instabug.enable()
        try {
            Replies.setState(Feature.State.DISABLED) // It seems that they did disable this on iOS
        } catch (ex: Exception) {
            // crashes on first call presumably because `init` is not ready without onResume lifecycle call
        }
        try {
            Chats.setState(Feature.State.DISABLED) // It seems that they did disable this on iOS - it also may not be in our Instabug plan
        } catch (ex: Exception) {
            // crashes on first call presumably because `init` is not ready without onResume lifecycle call
        }

//        val session = sessionStore.getSession()
        // Fill out user information
//        Instabug.setUserAttribute(USERNAME, session.username)
//        Instabug.setUserAttribute(USER_ID, session.id.toString())
//        Instabug.setUserAttribute(PREMIUM_STATUS, MembershipLevel.of(session.premium_status).toString())

        Instabug.show()
    }
}

interface ChessInstabug {

    fun init(application: Application)

    fun show()
}