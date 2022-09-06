package com.technifutur.neopixl.eval2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.technifutur.neopixl.eval2.databinding.FragmentConnexionBinding


class ConnexionFragment : Fragment() {
     private lateinit var binding : FragmentConnexionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentConnexionBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.twitterBtn.setOnClickListener{
            val action = R.id.action_connexionFragment_to_twitterFragment
            findNavController().navigate(action)
        }

        binding.facebookBtn.setOnClickListener{
            val action = R.id.action_connexionFragment_to_facebookFragment
            findNavController().navigate(action)
        }

        binding.bloggiesBtn.setOnClickListener{
            val action = R.id.action_connexionFragment_to_bloggiesFragment
            findNavController().navigate(action)
        }
    }


}