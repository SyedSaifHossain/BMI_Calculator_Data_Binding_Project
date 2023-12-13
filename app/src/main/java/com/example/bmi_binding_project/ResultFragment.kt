package com.example.bmi_binding_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bmi_binding_project.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        var score = arguments?.getDouble("score")
        binding.scoreTv.text = String.format("%.1f",score)

        var catagory = when(String.format("%.1f",score).toDouble()){

           in 0.0 .. 18.4 -> underweight
            in 18.5 .. 24.9 -> normal
            in 25.00 .. 29.99 -> overweight
            in 30.0 .. 34.99 -> obesity1
            in 35.0 .. 39.99 -> obesity2
            else -> obesity3
        }

        binding.catagoryTv.text = catagory

        return binding.root
    }
    companion object{
        var underweight = "UNDERWEIGHT"
        var normal = "NORMAL"
        var overweight = "OVERWEIGHT"

        var obesity1 = "OBISITY 1"
        var obesity2 = "OBISITY 2"
        var obesity3 = "OBISITY 3"
    }

}