package br.edu.unisep.exemplofb.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        println(message.notification?.title)
        println(message.notification?.body)
    }
}