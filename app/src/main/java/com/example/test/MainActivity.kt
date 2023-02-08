package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameET: EditText
    private lateinit var passwordET: EditText
    private lateinit var loginBtn: Button
    private lateinit var calendarView: CalendarView
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setupLoginListener()
    }

    private fun initViews() {
        nameET = findViewById(R.id.nameEt)
        passwordET = findViewById(R.id.passwordET)
        loginBtn = findViewById(R.id.loginButton)
        calendarView = findViewById(R.id.calendarView)
    }


    private fun setupLoginListener() {
        loginBtn.setOnClickListener {
            val name = nameET.text.toString()
            val password = passwordET.text.toString()
            val dob = calendarView.date.toString()
            login(name, password, dob)
        }
    }

    private fun login(name: String, password: String, dob: String) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Name can't be empty", Toast.LENGTH_SHORT).show()
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show()
            ///
        } else if (dob.isEmpty()) {
            Toast.makeText(this, "Date of birth can't be empty", Toast.LENGTH_SHORT).show()

        } else {
            loginUser(name, password, dob)
        }
    }

    private fun loginUser(name: String, password: String, dob: String) {
        user = User(name, password, dob)
        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }
}