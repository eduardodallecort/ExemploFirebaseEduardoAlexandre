package br.edu.unisep.exemplofb.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserRepository {

    private var fbAuth: FirebaseAuth = Firebase.auth

    suspend fun save(username: String, password: String): String {

        var message = "Usuário cadastrado com sucesso!"

        this.fbAuth.createUserWithEmailAndPassword(username, password)
            .addOnSuccessListener {
            }
            .addOnFailureListener { error ->
                error.printStackTrace()
                message = "Erro ao cadastrar usuário!"
            }

        return message
    }

}