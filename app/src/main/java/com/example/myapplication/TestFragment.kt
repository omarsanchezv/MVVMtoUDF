package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentTestBinding

class TestFragment : Fragment(){
    private lateinit var binding : FragmentTestBinding
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_test, container, false)
        binding.state = TestState()
        binding.lifecycleOwner = viewLifecycleOwner
        initListener()
        initClickListeners()
        return binding.root
    }

    private fun initListener(){
        testViewModel.testLiveData.observe(viewLifecycleOwner){state ->
            binding.state = state
        }
    }

    private fun initClickListeners(){
        binding.buttonA.setOnClickListener{
            testViewModel.clickA()
        }

        binding.buttonB.setOnClickListener{
            testViewModel.clickB()
        }
    }
}
