package com.alphabangkit.socialdistancing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alphabangkit.socialdistancing.databinding.ActivityProfileBinding
import com.alphabangkit.socialdistancing.util.SharedPreferences

class ProfileActivity : AppCompatActivity() {
    private lateinit var profilebinding: ActivityProfileBinding
    private lateinit var pre: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profilebinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profilebinding.root)
        supportActionBar?.title = "Profil"
        pre = SharedPreferences(this)
        profilebinding.btnLogout.setOnClickListener {
            pre.firstlogin = false
            val intentprof = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(intentprof)
            finish()
        }
    }
}