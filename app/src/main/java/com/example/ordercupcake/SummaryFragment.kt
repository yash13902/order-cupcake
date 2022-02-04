package com.example.ordercupcake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ordercupcake.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
        }
    }

    fun goToNextScreen(){
        sharedViewModel.setQuantity(0)
        sharedViewModel.setFlavor("")
        sharedViewModel.setDate("")
        findNavController().navigate(SummaryFragmentDirections.actionSummaryFragmentToStartFragment())

    }
}