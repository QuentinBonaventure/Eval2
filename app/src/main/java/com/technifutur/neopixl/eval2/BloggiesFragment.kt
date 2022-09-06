package com.technifutur.neopixl.eval2

import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.technifutur.neopixl.eval2.databinding.FragmentBloggiesBinding
import com.technifutur.neopixl.eval2.databinding.FragmentBoggliesConnectedBinding


class BloggiesFragment : Fragment() {

    private lateinit var binding: FragmentBloggiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBloggiesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.connexionBtn.setOnClickListener {

            if (!isValidEmail(binding.emailEditText.text)) {
                val builder = AlertDialog.Builder(requireContext())
                with(builder) {
                    setTitle("Erreur")
                    setMessage("Mail incomplet")
                    setPositiveButton("ok", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, wich: Int) {

                        }
                    })
                }.show()
            } else if (binding.loginEditText.text.isEmpty()) {
                val builder = AlertDialog.Builder(requireContext())
                with(builder) {
                    setTitle("Erreur")
                    setMessage("Login vide")
                    setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {

                        }

                    })
                }.show()
            } else if (binding.passwordEditText.text == binding.confirmationEditText.text) {
                val builder = AlertDialog.Builder(requireContext())
                with(builder) {
                    setTitle("Erreur")
                    setMessage("Password ne correspond pas à la confirmation de celui ci ")
                    setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {

                        }

                    })
                }.show()


            } else {
                val action = R.id.action_bloggiesFragment_to_boggliesConnectedFragment
                findNavController().navigate(action)

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