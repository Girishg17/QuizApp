package com.girish.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel

import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuizQUestionActivity() : AppCompatActivity(),View.OnClickListener{
    private var mcurrentp:Int=1
    private var mQuestionList:ArrayList<Questions>?=null
    private var selectedOp:Int=0
    private var musername:String?=null
    var crrt :Int=0
//    var username=intent.getStringExtra("Username")


    private var progressbar:ProgressBar? =null
    private var tvProgress:TextView?= null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var option1:TextView?=null
    private var option2:TextView?=null
    private var option3:TextView?=null
    private var option4:TextView?=null
    private  var sbutton:Button?=null


    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        progressbar = findViewById(R.id.prgrs_bar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_questions)
        ivImage = findViewById(R.id.iv_image)
        option1 = findViewById(R.id.op1)
        option2 = findViewById(R.id.op2)
        option3 = findViewById(R.id.op3)
        option4 = findViewById(R.id.op4)
        mQuestionList = constant.getQuestion()
        sbutton=findViewById(R.id.button1)
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        sbutton?.setOnClickListener(this)
        musername=intent.getStringExtra(constant.USER_NAME)
      setQuestion()

    }



    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()

        val question: Questions = mQuestionList!![mcurrentp-1]
        ivImage?.setImageResource(question.image)
        progressbar?.progress = mcurrentp
        tvProgress?.text = "$mcurrentp/${progressbar?.max}"

        tvQuestion?.text = question.questions
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
        if(mcurrentp == mQuestionList!!.size){
            sbutton?.text="Finish"

        }else{
            sbutton?.text="SUBMIT"
        }

    }

private fun defaultOptionsView(){
    var options=ArrayList<TextView>()
option1?.let{
    options.add(0,it)
}
    option2?.let{
        options.add(1,it)
    }
    option3?.let{
        options.add(2,it)
    }
    option4?.let{
        options.add(3,it)
    }
    for (option in options){

        option.setTextColor(Color.parseColor("#7a8089"))
        option.typeface= Typeface.DEFAULT
        option.background=ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg
        )
    }

}
private fun selectedOptionView(tv:TextView,selectedopn:Int){
    defaultOptionsView()
    selectedOp=selectedopn
    tv.setTextColor(Color.parseColor("#363a43"))
    tv.setTypeface(tv.typeface,Typeface.BOLD)
    tv.background=ContextCompat.getDrawable(this,
        R.drawable.selected_op_bg
    )
}
    override fun onClick(view: View?) {
     when(view?.id){
         R.id.op1->{
             option1?.let{
                 selectedOptionView(it ,1)
             }
         }
         R.id.op2->{
             option2?.let{
                 selectedOptionView(it ,2)
             }
         }
         R.id.op3->{
             option3?.let{
                 selectedOptionView(it ,3)
             }
         }
         R.id.op4->{
             option4?.let{
                 selectedOptionView(it ,4)
             }
         }
         R.id.button1->{
             if(selectedOp==0){
                 mcurrentp++
                 when{
                     mcurrentp<=mQuestionList!!.size->{
                         setQuestion()
                     }
                     else->{
                         val bundle=Bundle()
                         bundle.putString("Correct","${crrt}")
                         bundle.putString("Usr","$musername")
                         bundle. putString(constant.TOTAL_QSTION,"${mQuestionList?.size}")
                         val intent= Intent(this,Final::class.java)
                        intent.putExtras(bundle)
                         startActivity(intent)
                         finish()
                     }
                 }
             }else{
                 val question=mQuestionList?.get(mcurrentp-1)
                 if(question!!.correctAnswer !=selectedOp){
                     answerView(question.correctAnswer,R.drawable.corect_option_border_bg)
                     answerView(selectedOp,R.drawable.wrong_option_border_bg)
                 }else{
                     crrt=crrt+1
                     answerView(selectedOp,R.drawable.wrong_option_border_bg)
                answerView(question.correctAnswer,R.drawable.corect_option_border_bg)}
                 if(mcurrentp==mQuestionList!!.size){
                     sbutton?.text="See The result"

                 }else{
                     sbutton?.text="Go to next Question"

                 }
                 selectedOp=0
             }

         }
     }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->option1?.background=ContextCompat.getDrawable(this,drawableView)
        }
        when(answer){
            2->option2?.background=ContextCompat.getDrawable(this,drawableView)
        }
        when(answer){
            3->option3?.background=ContextCompat.getDrawable(this,drawableView)
        }
        when(answer){
            4->option4?.background=ContextCompat.getDrawable(this,drawableView)
        }
    }
}