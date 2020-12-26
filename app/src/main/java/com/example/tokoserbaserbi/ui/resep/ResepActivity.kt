package com.example.tokoserbaserbi.ui.resep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokoserbaserbi.R

class ResepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep)
    }

    companion object {
        const val OPEN_RESEP = "open_resep"
    }
}