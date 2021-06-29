package br.edu.unisep.exemplofb.app

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class FbApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Firebase.messaging.token.addOnSuccessListener { token ->
            println("Firebase Messaging Token: $token")
        }
    }
}