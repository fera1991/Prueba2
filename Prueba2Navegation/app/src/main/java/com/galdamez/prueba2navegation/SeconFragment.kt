package com.galdamez.prueba2navegation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.galdamez.prueba2navegation.databinding.FragmentSeconBinding


class SeconFragment : Fragment() {
    private lateinit var binding: FragmentSeconBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_secon,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.selection.value = getString(R.string.seletion1)
        binding.Textviewselect.text = viewModel.selection.value

        val navController = findNavController()
        binding.nextFramentFinal.setOnClickListener(){
            val action = SeconFragmentDirections.actionSeconFragment2ToLastFragment22()
            navController.navigate(action)
        }
        binding.selectA.setOnClickListener()
        {
            viewModel.selection.value = getString(R.string.seletion1)
            binding.Textviewselect.text = viewModel.selection.value
        }
        binding.selectB.setOnClickListener()
        {
            viewModel.selection.value = getString(R.string.seletion2)
            binding.Textviewselect.text = viewModel.selection.value
        }
        binding.selectC.setOnClickListener()
        {
            viewModel.selection.value = "Opcion 3"
            binding.Textviewselect.text = viewModel.selection.value
        }

    }

}