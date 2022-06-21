package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding
    private val testViewModel: TestViewModel by viewModels()
    private val featureFlag: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return if (featureFlag) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
            binding.state = TestState()
            binding.lifecycleOwner = viewLifecycleOwner
            initListener()
            initClickListeners()
            binding.root
        } else {
            ComposeView(requireContext()).apply {
                setContent {
                    val state = testViewModel.testLiveData.observeAsState()
                    state.value?.let { TestScreen(state = it, dispatch = testViewModel::dispatch) }
                }
            }
        }
    }

    private fun initListener() {
        testViewModel.testLiveData.observe(viewLifecycleOwner) { state ->
            binding.state = state
        }
    }

    private fun initClickListeners() {
        binding.buttonA.setOnClickListener {
            testViewModel.dispatch(TestActions.ClickButtonA)
        }

        binding.buttonB.setOnClickListener {
            dispatch(TestActions.ClickButtonB)
        }
    }

    private fun dispatch(actions: TestActions) = testViewModel.dispatch(actions)
}
