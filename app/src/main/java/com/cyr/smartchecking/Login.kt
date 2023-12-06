package com.cyr.smartchecking

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.cyr.smartchecking.MainActivity2

import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //
        val btn_connect = findViewById<Button>(R.id.connect)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

       btn_connect.setOnClickListener{
            startActivity(Intent(this,
                MainActivity::class.java))
        }

    }
}