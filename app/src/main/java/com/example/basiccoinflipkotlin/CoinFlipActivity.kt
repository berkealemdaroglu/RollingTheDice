package com.example.basiccoinflipkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_coin_flip.*

class CoinFlipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_flip)
        onCoinTab()

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
    private fun onCoinTab() {
        iv_coin.setOnClickListener {
            val randomNumber = (1..2).random()

            if (randomNumber == 1){
                flipTheCoin(R.drawable.heads,"Heads")
            }else{
                flipTheCoin(R.drawable.tails,"Tails")
            }
        }
    }


    private fun flipTheCoin(imageId : Int, coinSide : String) {
        iv_coin.animate().apply {
            duration = 1500
            rotationYBy(1800f)
            iv_coin.isClickable = false
            iv_coin.setImageResource(R.drawable.heails)
        }.withEndAction{
            iv_coin.setImageResource(imageId)
            Toast.makeText(this,coinSide, Toast.LENGTH_SHORT).show()
            iv_coin.isClickable = true
        }.start()
    }
}