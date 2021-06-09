package com.alphabangkit.socialdistancing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alphabangkit.socialdistancing.databinding.ActivityDashboardBinding
import com.alphabangkit.socialdistancing.databinding.ActivityProfileBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var dashboardbinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardbinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardbinding.root)

        dashboardbinding.btnProfil.setOnClickListener {
            val intentprof = Intent(this@DashboardActivity, ProfileActivity::class.java)
            startActivity(intentprof)
        }

        dashboardbinding.cvList.setOnClickListener {
            val intentlist = Intent(this@DashboardActivity, ListActivity::class.java)
            startActivity(intentlist)
        }

        dashboardbinding.cvAbout.setOnClickListener {
            val intentabout = Intent(this@DashboardActivity, AboutActivity::class.java)
            startActivity(intentabout)
        }
    }
}