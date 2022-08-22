package com.example.rollthediceapp.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.rollthediceapp.R
import com.example.rollthediceapp.databinding.FragmentCoinFlipBinding

class CoinFlipFragment : Fragment() {
    private lateinit var binding : FragmentCoinFlipBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinFlipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCoinTab()

    }

    //A random number is determined so that the money can land heads and tails.
    private fun onCoinTab() {

        binding.ivCoin.setOnClickListener {
            val randomNumber = (1..2).random()

            if (randomNumber == 1){
                flipTheCoin(R.drawable.heads,"Heads")
            }else{
                flipTheCoin(R.drawable.tails,"Tails")
            }
        }
    }

    //money return animations are made.
    private fun flipTheCoin(imageId : Int, coinSide : String) {
        binding.ivCoin.animate().apply {
            duration = 1500
            rotationYBy(1800f)
            binding.ivCoin.isClickable = false
            binding.ivCoin.setImageResource(R.drawable.heails)
        }.withEndAction{
            binding.ivCoin.setImageResource(imageId)
            Toast.makeText(context,coinSide, Toast.LENGTH_SHORT).show()
            binding.ivCoin.isClickable = true
        }.start()
    }


}