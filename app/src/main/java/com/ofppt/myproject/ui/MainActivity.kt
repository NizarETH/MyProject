package com.ofppt.myproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.FirebaseApp
import com.ofppt.myproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // throw RuntimeException("Test Crash") // Force a crash

         supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, StartFragment()).commit()
    }
}