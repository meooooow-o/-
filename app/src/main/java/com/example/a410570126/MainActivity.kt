package com.example.a410570126

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<EditText>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        var index = 0;
        var riddleList =
            mutableListOf("0000，猜一個成語?:四大皆空1", "九十九，打一字?:白", "0+0=1，猜一成語?:無中生有", "台灣女孩，猜一字?:始")
        edAnswer.text = null
        tvResult.text = null
        btnRiddle.setOnClickListener {
            val countRiddle = riddleList.count()
            val (riddle, answer) = riddleList[index].split(":")
            tvRiddle.text = "謎題：$riddle"
            index++
            if (index >= countRiddle) index = 0

            btnAnswer.setOnClickListener {
                val ans = edAnswer.text
                if (ans.toString() == answer) {
                    tvResult.text = "好棒，您答對了!!"
                    Toast.makeText(this, edAnswer.text, Toast.LENGTH_SHORT).show()
                } else
                    tvResult.text = "沒猜中，再試試看吧!"
            }
            btnReAnswer.setOnClickListener {
                edAnswer.text = null
                tvResult.text = null
            }
            btnShowAnswer.setOnClickListener {
                tvResult.text = "謎底是:$answer"
            }
        }
    }
}