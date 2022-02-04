package com.example.ordercupcake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ordercupcake.databinding.FragmentStartBinding

class StartFragment : Fragment(){

    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startFragment = this

    }

     fun navigate(i: Int) {
        Toast.makeText(
            requireContext(),
            "You have ordered $i number of cupcakes",
            Toast.LENGTH_SHORT
        ).show()
        sharedViewModel.setQuantity(i)
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor("Vanilla")
        }
        findNavController()
            .navigate(StartFragmentDirections.actionStartFragmentToFlavourFragment())
    }



}


