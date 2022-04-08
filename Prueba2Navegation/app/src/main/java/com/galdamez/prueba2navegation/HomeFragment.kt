package com.galdamez.prueba2navegation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.galdamez.prueba2navegation.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val navController = findNavController()
        binding.nextFragment.setOnClickListener(){
            val action = HomeFragmentDirections.actionHomeFragment2ToSeconFragment2()
            navController.navigate(action)

            viewModel.amout.value = binding.edittextName.text.toString()

        }
    }

}