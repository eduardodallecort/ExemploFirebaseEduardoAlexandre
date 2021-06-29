package br.edu.unisep.exemplofb.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import br.edu.unisep.exemplofb.R
import br.edu.unisep.exemplofb.databinding.ActivityHomeBinding
import br.edu.unisep.exemplofb.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private lateinit var fbAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fbAuth = Firebase.auth

        binding.tvMessage.text = getString(R.string.homeMessage, fbAuth.currentUser?.email)
        binding.btnLogout.setOnClickListener { logout() }
    }

    private fun logout() {
        fbAuth.signOut()

        val prefs = getSharedPreferences("example-firebase-prefs", MODE_PRIVATE)
        prefs.edit {
            remove("user-id")
            remove("user-email")
            remove("user-password")
        }

        startActivity(LoginActivity.newIntent(this))
        finish()
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

}