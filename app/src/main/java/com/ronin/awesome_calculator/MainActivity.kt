package com.ronin.awesome_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    fun eval(exp:String):Double {

        return ExpressionBuilder(exp).build().evaluate()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = arrayListOf<Button>()
        var expression:String = ""
        var solution_text = findViewById<TextView>(R.id.solution)

        for(i in 1..19){
            val id = "button$i"
            val temp_button = findViewById<Button>(resources.getIdentifier(id,"id",packageName))
            temp_button.setOnClickListener {
                val button_text = (it as Button).text

                when(button_text){
                    "AC" -> {
                        expression = ""
                    }
                    "DEL" -> {
                        expression = expression.substring(0,expression.length - 1)
                    }
                    "=" -> {
                        val sol = eval(expression)
                        solution_text.setText(sol.toString())
                    }
                    else -> {
                        expression += button_text
                    }
                }

            }
            buttons.add(temp_button)
        }
    }
}