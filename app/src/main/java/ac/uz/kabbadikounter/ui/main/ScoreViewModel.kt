package ac.uz.kabbadikounter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    //var teamAPoints:Int=0  //Normal InT

    private var _teamAPoints = MutableLiveData<Int>(0)//MutableLiveData Int
    val teamAPoints: LiveData<Int>//(IMMutable)LiveData Int
        get() = _teamAPoints


    var teamBPoints:Int=0

    fun incrementPoints(teamA:Boolean){
        if(teamA){
            _teamAPoints.value=_teamAPoints.value!! + 1
        }
        else{
            teamBPoints
        }
    }
}