package com.galdamez.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.galdamez.navegacion.databinding.FragmentPuntajeEquipoBinding


class PuntajeEquipo : Fragment() {

    private lateinit var binding: FragmentPuntajeEquipoBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_puntaje_equipo,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.PointTeam1.text = viewModel.pointTeamA.value.toString()
        binding.PointTeam2.text = viewModel.pointTeamB.value.toString()

        OnClickListener()
    }
    private fun OnClickListener()
    {
        binding.buttonplus1TeamA.setOnClickListener(){
            plusTeamA(1)
        }
        binding.buttonplus2TeamA.setOnClickListener(){
            plusTeamA(2)
        }
        binding.buttonplus3TeamA.setOnClickListener(){
            plusTeamA(3)
        }
        binding.buttonplus1TeamB.setOnClickListener(){
            plusTeamB(1)
        }
        binding.buttonplus2TeamB.setOnClickListener(){
            plusTeamB(2)
        }
        binding.buttonplus3TeamB.setOnClickListener(){
            plusTeamB(3)
        }
        val navController = findNavController()
        binding.NextFragment.setOnClickListener(){
            val action = PuntajeEquipoDirections.actionPuntajeEquipoToPuntajeFinalEquipos()
            navController.navigate(action)
        }
    }

    private fun plusTeamA(num: Int){
        val result:Int = (viewModel.pointTeamA.value?.plus(num!!))?:0
        viewModel.pointTeamA.value = result
        binding.PointTeam1.text = viewModel.pointTeamA.value.toString()

    }
    private fun plusTeamB(num: Int){
        val result:Int = (viewModel.pointTeamB.value?.plus(num!!))?:0
        viewModel.pointTeamB.value = result
        binding.PointTeam2.text = viewModel.pointTeamB.value.toString()
    }


}