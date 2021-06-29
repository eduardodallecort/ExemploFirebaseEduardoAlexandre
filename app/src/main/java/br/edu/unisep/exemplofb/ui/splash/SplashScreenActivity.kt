package br.edu.unisep.exemplofb.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import br.edu.unisep.exemplofb.databinding.ActivitySplashScreenBinding
import br.edu.unisep.exemplofb.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(binding.root)

        Handler().postDelayed( {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }, 3000)

    }

}