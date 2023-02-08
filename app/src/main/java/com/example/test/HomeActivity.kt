package com.example.test

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var nameTV: TextView
    private lateinit var passwordTV: TextView
    private lateinit var dobTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        getData()
    }

    private fun initViews() {
        nameTV = findViewById(R.id.nameTV)
        passwordTV = findViewById(R.id.passwordTV)
        dobTV = findViewById(R.id.dobTV)
    }

    private fun getData() {
        intent?.extras?.let { bundle ->
            val user = bundle.get("user") as? User?
            user?.let {
                nameTV.text = it.name
                passwordTV.text = it.password
                dobTV.text = it.dob
            }
        } ?: run {
            Toast.makeText(
                this@HomeActivity,
                "Failed to get data from intent", Toast.LENGTH_SHORT
            ).show()
        }
    }
}