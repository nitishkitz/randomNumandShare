package com.example.randomnumandshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val randomnum: TextView = findViewById(R.id.randomnum)
        receiveusername()
        generaterandomnumber()
        var luckyname: TextView = findViewById(R.id.name)
        var randomnumber = generaterandomnumber().toString()
        randomnum.setText(randomnumber)


        var name = receiveusername().toString()

        luckyname.setText(name)

        val share: Button = findViewById(R.id.sharebtn)
        share.setOnClickListener(){
            sharedata(name, randomnumber)
        }

    }

    fun generaterandomnumber(): Int {
        var randomnumber = Random.nextInt(1000)
        return randomnumber
    }

    fun receiveusername(): String {
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }

    fun sharedata(username: String, num: String) {


        var it = Intent(Intent.ACTION_SEND)
        it.setType("")
        it.putExtra(Intent.EXTRA_SUBJECT, "$username your lucky number")
        it.putExtra(Intent.EXTRA_TEXT, "$num")
        startActivity(it)
    }
}