package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.widget.Toast
import android.content.pm.PackageManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Check and request permission
        val permission = "com.example.assignment2.MSE412"
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 100)
        } else {
            startSecondActivity()
        }
    }

    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    // Handle the permission request result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show()
            startSecondActivity()
        } else {
            Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show()
        }
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