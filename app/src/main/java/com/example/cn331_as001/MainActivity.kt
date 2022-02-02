package com.example.cn331_as001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var text_result : TextView
    private lateinit var button: Button
    private lateinit var editTextNumber: EditText
    var random : Int = nextInt( 1, 1000)
    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_result = findViewById<TextView>(R.id.text_result)
        button = findViewById<Button>(R.id.button)
        editTextNumber = findViewById<EditText>(R.id.editTextNumber)

        button.setOnClickListener { checkAns(editTextNumber.text.toString().toInt()) }

    }

    private fun checkAns( x : Int) {
        if (x > random){
            count++
            text_result.text = "Lower number than yours"
            editTextNumber.text.clear()

        }
        else if (x < random){
            count++
            text_result.text = "Higher number than yours"
            editTextNumber.text.clear()

        }
        else{
            count++
            alertWinning(count)
            count = 0
            editTextNumber.text.clear()
            text_result.text = "Let's do it again"
            random = nextInt( 1, 1000)

        }

    }
    private fun alertWinning(y : Int){
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("You have tried $y times")
            .setCancelable(true)

        val alert = dialogBuilder.create()
        alert.setTitle("YOU WIN!!")
        alert.show()
    }

}