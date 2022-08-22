package com.example.rollthediceapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rollthediceapp.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinFlipOnClickListener()
        rollDiceOnClickListener()
    }

    //transition between pages.
    private fun coinFlipOnClickListener(){
        binding.coinFlip.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToCoinFlipFragment()
            findNavController().navigate(action)
        }
    }

    private fun rollDiceOnClickListener(){
        binding.rollTheDice.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToRollDiceFragment()
            findNavController().navigate(action)
        }
    }

}