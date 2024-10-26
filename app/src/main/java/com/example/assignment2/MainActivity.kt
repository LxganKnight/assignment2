package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explicit Intent
        val btnExplicit: Button = findViewById(R.id.btnExplicit)
        btnExplicit.setOnClickListener {
            val explicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        // Implicit Intent
        val btnImplicit: Button = findViewById(R.id.btnImplicit)
        btnImplicit.setOnClickListener {
            val implicitIntent = Intent().apply {
                action = Intent.ACTION_VIEW
                setClass(this@MainActivity, SecondActivity::class.java)
            }
            startActivity(implicitIntent)
        }

        val viewImageButton: Button = findViewById(R.id.viewImageActivityButton)
        viewImageButton.setOnClickListener {
            val intent = Intent(this, ViewImageActivity::class.java)
            startActivity(intent)
        }



    }
}