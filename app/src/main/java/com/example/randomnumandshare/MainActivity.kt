package com.example.randomnumandshare

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.submit_btn)
        val name: EditText = findViewById(R.id.editText)

        btn.setOnClickListener() {
            var it = Intent(this, MainActivity2::class.java)

            var username = name.text

            it.putExtra("name", username)

            startActivity(it)

        }


    }
}