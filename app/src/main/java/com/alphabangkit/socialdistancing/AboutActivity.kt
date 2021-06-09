package com.alphabangkit.socialdistancing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alphabangkit.socialdistancing.databinding.ActivityAboutBinding
import com.alphabangkit.socialdistancing.databinding.ActivityDetailBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var aboutbinding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aboutbinding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(aboutbinding.root)
        supportActionBar?.title = "Tentang"

    }
}