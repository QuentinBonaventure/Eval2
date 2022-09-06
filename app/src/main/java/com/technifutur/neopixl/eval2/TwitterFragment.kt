package com.technifutur.neopixl.eval2

import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.navigation.fragment.findNavController
import com.technifutur.neopixl.eval2.databinding.FragmentTwitterBinding


class TwitterFragment : Fragment() {

   private lateinit var binding : FragmentTwitterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwitterBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.connexionBtn.setOnClickListener {

            if(isValidEmail(binding.emailEditText.text)){
               val action = R.id.action_twitterFragment_to_twitterConnectedFragment
               findNavController().navigate(action)
            }
            else{
                val builder = AlertDialog.Builder(requireContext())
                with(builder){
                    setTitle("Erreur")
                    setMessage("Login incomplet")
                    setPositiveButton("ok", object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, wich: Int) {

                        }
                    })



                }.show()
            }

        }
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }


}