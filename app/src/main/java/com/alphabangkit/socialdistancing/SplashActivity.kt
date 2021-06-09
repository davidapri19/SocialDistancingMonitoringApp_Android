package com.alphabangkit.socialdistancing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.alphabangkit.socialdistancing.util.SharedPreferences

class SplashActivity : AppCompatActivity() {
    private lateinit var pre: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        pre = SharedPreferences(this)
        Handler(Looper.getMainLooper()).postDelayed({
            var i : Intent
            if (!pre.firstlogin){
                i = Intent(this, MainActivity::class.java)
            }else {
                i = Intent(this, DashboardActivity::class.java)
            }
            startActivity(i)
            finish()
        }, 3000)
    }
}