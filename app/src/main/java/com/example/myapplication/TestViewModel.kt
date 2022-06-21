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

    private fun clickA(){
        _testLiveData.value = testLiveData.value?.copy(lastClicked = "A")
    }

    private fun clickB(){
        _testLiveData.value = testLiveData.value?.copy(lastClicked = "B")
    }

    fun dispatch(action: TestActions){
        when(action){
            is TestActions.ClickButtonA -> clickA()
            is TestActions.ClickButtonB -> clickB()
        }
    }
}

data class TestState(
    val lastClicked : String = ""
)

