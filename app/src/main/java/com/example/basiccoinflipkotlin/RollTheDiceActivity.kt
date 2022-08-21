package com.example.basiccoinflipkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_roll_the_dice.*

class RollTheDiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roll_the_dice)
        buttonRoll.setOnClickListener {
            onRollTheDice()
        }
        rollGif.isVisible = false
    }

    private fun onRollTheDice(){
            val randomRollNumber = (1..6).random()
            when(randomRollNumber){
                1 -> rollTheDice(R.drawable.ic_one,"One")
                2 -> rollTheDice(R.drawable.ic_two, "Two")
                3 -> rollTheDice(R.drawable.ic_three,"Three")
                4 -> rollTheDice(R.drawable.ic_four,"Four")
                5 -> rollTheDice(R.drawable.ic_five, "Five")
                else -> rollTheDice(R.drawable.ic_six,"Six")
            }
        }


    private fun rollTheDice(imageId : Int, rollSide : String){
        buttonRoll.animate().apply {
            duration = 1500
            buttonRoll.isClickable = false
            buttonRoll.isVisible = false
            rollGif.isVisible = true


        }.withEndAction {
            buttonRoll.setImageResource(imageId)
            Toast.makeText(this,rollSide,Toast.LENGTH_SHORT).show()
            buttonRoll.isClickable = true
            buttonRoll.isVisible = true
            rollGif.isVisible = false
        }.start()
    }

}