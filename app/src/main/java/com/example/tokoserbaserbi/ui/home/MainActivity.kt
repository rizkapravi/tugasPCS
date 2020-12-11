package com.example.tokoserbaserbi.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tokoserbaserbi.R
import com.example.tokoserbaserbi.databinding.ActivityMainBinding
import com.example.tokoserbaserbi.ui.auth.AuthActivity
import com.example.tokoserbaserbi.ui.auth.TokoAuth

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            TokoAuth.logout(this) {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}