package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TestScreen(state: TestState, dispatch: Dispatch) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "xml from compose",
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.align(CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .background(Color(0xffffbb33))
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = state.lastClicked,
                modifier = Modifier.align(Center)
            )
        }
        Row(Modifier.padding(10.dp)) {
           Button(onClick = { dispatch?.invoke(TestActions.ClickButtonA) }) {
               Text(text = "A", color = MaterialTheme.colors.onPrimary)
           }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { dispatch?.invoke(TestActions.ClickButtonB) }) {
                Text(text = "B", color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTestScreen() {
    val testState = TestState("A")
    TestScreen(state = testState, dispatch = {})
}