package com.example.basiccoinflipkotlin

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ClikFun()
    }

    private fun ClikFun(){
        coinFlip.setOnClickListener {
            val coinFlipIntent = Intent(this,CoinFlipActivity::class.java)
            startActivity(coinFlipIntent)
        }

        rollTheDice.setOnClickListener {
            val rollTheDiceIntent = Intent(this,RollTheDiceActivity::class.java)
            startActivity(rollTheDiceIntent)
        }

    }

}