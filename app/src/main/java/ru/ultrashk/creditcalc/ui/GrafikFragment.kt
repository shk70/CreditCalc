package ru.ultrashk.creditcalc.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ru.ultrashk.creditcalc.databinding.FragmentGrafikBinding
import ru.ultrashk.creditcalc.model.CalcViewModel

class GrafikFragment : Fragment() {
    private var binding: FragmentGrafikBinding? = null
    private val sharedViewModel: CalcViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentGrafikBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            grafikFragment = this@GrafikFragment
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            recyclerView.adapter = GrafikListAdapter()
        }
    }


   /*

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGrafikBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.viewModel = sharedViewModel
        binding.recyclerView.adapter = GrafikListAdapter()
        return binding.root
    }
*/


}