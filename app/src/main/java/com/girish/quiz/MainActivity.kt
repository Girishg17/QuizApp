package com.girish.quiz

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
        val btn_s=findViewById<Button>(R.id.btn_start)
        val btn_e=findViewById<EditText>(R.id.inpt)

        btn_s.setOnClickListener(){
if(btn_e.text.isEmpty()){
    Toast.makeText(this,"Name is required",Toast.LENGTH_LONG).show()
}else{
//    val usn=btn_e.text
    val intent= Intent(this,QuizQUestionActivity::class.java)
      intent. putExtra(constant.USER_NAME,btn_e.text.toString())
    startActivity(intent)
    finish()

}
        }
    }
}