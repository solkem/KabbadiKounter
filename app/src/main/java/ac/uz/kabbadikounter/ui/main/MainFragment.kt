package ac.uz.kabbadikounter.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.uz.kabbadikounter.R
import ac.uz.kabbadikounter.databinding.MainFragmentBinding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: ScoreViewModel by viewModels()

    //private lateinit var binding: MainFragmentBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding:MainFragmentBinding=DataBindingUtil.inflate(
            inflater,R.layout.main_fragment,container,false)

        //binding.scoreViewModel=viewModel
        //binding= MainFragmentBinding.inflate(layoutInflater)  ViewBinding Removed

        /* Observer Object Removed
        val scoreAObserver= Observer<Int> {
            newScore->binding.textViewA.text=newScore.toString()
        }

        //Add Observer to teamAPoints LiveData Object in ViewModel
        viewModel.teamAPoints.observe(viewLifecycleOwner,scoreAObserver)
        */

        binding.scoreViewModel=viewModel
        binding.lifecycleOwner=this

        binding.buttonA.setOnClickListener {
            viewModel.incrementPoints(true)
            //binding.textViewA.text=viewModel.teamAPoints.toString()
        }

        binding.buttonB.setOnClickListener {
            viewModel.incrementPoints(false)
            binding.textViewB.text=viewModel.teamBPoints.toString()
        }

        return binding.root
        //return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}