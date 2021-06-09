package com.alphabangkit.socialdistancing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alphabangkit.socialdistancing.databinding.ActivityMainBinding
import com.alphabangkit.socialdistancing.util.SharedPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var pre: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        pre = SharedPreferences(this)
        activityMainBinding.login.setOnClickListener{
            val username = activityMainBinding.name.text.toString()
            val password = activityMainBinding.pass.text.toString()
            if(username =="admin" && password =="admin"){
                pre.firstlogin = true
                val intent = Intent(this,DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{Toast.makeText(this,"username/password salah",Toast.LENGTH_SHORT).show()}
        }
    }
}