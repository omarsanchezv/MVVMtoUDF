package com.example.myapplication

sealed class TestActions: Action {
    object ClickButtonA:TestActions()
    object ClickButtonB: TestActions()
}