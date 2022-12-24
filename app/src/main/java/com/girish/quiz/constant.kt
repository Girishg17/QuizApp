package com.girish.quiz

object constant {
    const val USER_NAME:String="user_name"
    const val TOTAL_QSTION:String="total_qstion"
    fun getQuestion():ArrayList<Questions>{
        val questionlist= ArrayList<Questions>()
        val q1=Questions(
            id = 1,"what country does this flag belongs to?",R.drawable.ic_flag_of_argentina,"Argentina","australia","japan","USA",1

        )
        questionlist.add(q1)
        val q2=Questions(
            id = 2,"what country does this flag belongs to?",R.drawable.ic_flag_of_australia,"North korea","australia","japan","USA",2

        )
        questionlist.add(q2)
        val q3=Questions(
            id = 3,"what country does this flag belongs to?",R.drawable.ic_flag_of_belgium,"Belgium","australia","Nepal","USA",1

        )
        questionlist.add(q3)
        val q4=Questions(
            id = 4,"what country does this flag belongs to?",R.drawable.ic_flag_of_brazil,"Pakistan","Newzeland","japan","brazil",4

        )
        questionlist.add(q4)
        val q5=Questions(
            id = 5,"what country does this flag belongs to?",R.drawable.ic_flag_of_denmark,"India","Denmark","japan","USA",2

        )
        questionlist.add(q5)
        val q6=Questions(
            id = 6,"what country does this flag belongs to?",R.drawable.ic_flag_of_fiji,"Fiji","australia","japan","Mayanmar",1

        )
        questionlist.add(q6)
        val q7=Questions(
            id = 7,"what country does this flag belongs to?",R.drawable.ic_flag_of_germany,"Bangladesh","Germany","japan","USA",2

        )
        questionlist.add(q7)

        return questionlist
    }
}