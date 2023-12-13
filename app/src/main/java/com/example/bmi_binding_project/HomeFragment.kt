package com.example.bmi_binding_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.bmi_binding_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)


        binding.calculatBtn.setOnClickListener{
        var weight = binding.weightEtx.text.toString().toDouble()

        var height = binding.heightEtx.text.toString().toDouble()
        var bmi = weight/(height*height)

            var bundle = bundleOf("score" to bmi)

        findNavController().navigate(R.id.resultAction,bundle)


        }
        return binding.root
    }
}