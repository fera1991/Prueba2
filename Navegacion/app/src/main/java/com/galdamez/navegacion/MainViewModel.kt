package com.galdamez.navegacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel:ViewModel() {
    var pointTeamA = MutableLiveData(0)
    var pointTeamB = MutableLiveData(0)
}


