package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
    private val _testLiveData = MutableLiveData<TestState>()
    val testLiveData: LiveData<TestState> = _testLiveData

    init {
        _testLiveData.value = TestState()
    }

    fun clickA(){
        _testLiveData.value = testLiveData.value?.copy(lastClicked = "A")
    }

    fun clickB(){
        _testLiveData.value = testLiveData.value?.copy(lastClicked = "B")
    }
}

data class TestState(
    val lastClicked : String = ""
)

