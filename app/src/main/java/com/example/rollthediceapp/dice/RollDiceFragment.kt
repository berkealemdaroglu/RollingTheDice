package com.example.rollthediceapp.dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.rollthediceapp.R
import com.example.rollthediceapp.databinding.FragmentRollTheDiceBinding

class RollDiceFragment : Fragment(){

    private lateinit var binding: FragmentRollTheDiceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRollTheDiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRoll2.setOnClickListener {
            onRollTheDice()
        }
        binding.rollGif.visibility = View.INVISIBLE

    }

    //Numbers from 1 to 6 are generated randomly.
    private fun onRollTheDice(){
        when((1..6).random()){
            1 -> rollTheDice(R.drawable.ic_one,"One")
            2 -> rollTheDice(R.drawable.ic_two, "Two")
            3 -> rollTheDice(R.drawable.ic_three,"Three")
            4 -> rollTheDice(R.drawable.ic_four,"Four")
            5 -> rollTheDice(R.drawable.ic_five, "Five")
            else -> rollTheDice(R.drawable.ic_six,"Six")
        }
    }

    //dice roll animation and buttons on and off states are adjusted.
    private fun rollTheDice(imageId : Int, rollSide : String){
        binding.buttonRoll2.animate().apply {
            duration = 1500
            binding.buttonRoll2.isClickable = false
            binding.buttonRoll.visibility = View.INVISIBLE
            binding.buttonRoll2.visibility = View.INVISIBLE
            binding.rollGif.visibility = View.VISIBLE


        }.withEndAction {
            binding.buttonRoll.setImageResource(imageId)
            Toast.makeText(context,rollSide, Toast.LENGTH_SHORT).show()
            binding.buttonRoll2.isClickable = true
            binding.buttonRoll.visibility = View.VISIBLE
            binding.buttonRoll2.visibility = View.VISIBLE
            binding.rollGif.visibility = View.INVISIBLE
        }.start()
    }

}