package com.girish.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Final : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

    val first=findViewById<TextView>(R.id.score)
    val name=findViewById<TextView>(R.id.name)
        val btn=findViewById<Button>(R.id.btn_finish)

        val bundle=intent.extras

        first?.text="you scored ${ bundle?.getString("Correct")} out of ${ bundle?.getString(constant.TOTAL_QSTION)}"
        name?.text="${bundle?.getString("Usr")}"
        btn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}