package ru.ultrashk.creditcalc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.ultrashk.creditcalc.R
import ru.ultrashk.creditcalc.databinding.FragmentStartBinding
import ru.ultrashk.creditcalc.model.CalcViewModel


class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: CalcViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            startFragment = this@StartFragment
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
    private fun setAll() {
        sharedViewModel.apply {
            var sumtmp:String = binding?.editTextNumber?.text.toString()
            if(sumtmp == "") sumtmp = "0.00"
            setSum(sumtmp.toDouble())
            setMonth(binding?.editTextNumber2?.text.toString().toInt())
            setPercent(binding?.editTextNumber3?.text.toString().toDouble())
            getPaymentPerMonth()
        }
    }
    fun calcMonthPay() {
        setAll()
    }

    fun showGrafik() {
        setAll()
        sharedViewModel.getGrafik()
        findNavController().navigate(R.id.action_startFragment_to_grafikFragment)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}