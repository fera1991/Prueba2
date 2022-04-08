package com.galdamez.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.galdamez.navegacion.databinding.FragmentPuntajeFinalEquiposBinding


class PuntajeFinalEquipos : Fragment() {

    private lateinit var binding: FragmentPuntajeFinalEquiposBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_puntaje_final_equipos,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.greetingTextView.text = getString(R.string.greeting_text,args.name)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.TeamAPoints.text = viewModel.pointTeamA.value.toString()
        binding.TeamBPoints.text = viewModel.pointTeamB.value.toString()

        if (viewModel.pointTeamA.value == viewModel.pointTeamB.value)
        {
            binding.placeTeamA.text = getString(R.string.TIE)
            binding.placeTeamB.text = getString(R.string.TIE)
        }
        else if(viewModel.pointTeamA.value!! > viewModel.pointTeamB.value!!)
        {
            binding.placeTeamA.text = getString(R.string.ganador)
            binding.placeTeamB.text = getString(R.string.perdedor)
        }
        else if(viewModel.pointTeamA.value!! < viewModel.pointTeamB.value!!)
        {
            binding.placeTeamB.text = getString(R.string.ganador)
            binding.placeTeamA.text = getString(R.string.perdedor)
        }
    }




}