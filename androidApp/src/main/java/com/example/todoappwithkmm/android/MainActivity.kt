package com.example.todoappwithkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.example.todoappwithkmm.TodoItemList

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoView(TodoViewModel())
                }
            }
        }
    }
}

@Composable
fun TodoView(viewModel: TodoViewModel) {
    val todoItemList: TodoItemList by viewModel.todoItemList.observeAsState(TodoItemList.createEmpty())

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = viewModel.inputContent.value,
                onValueChange = {
                    viewModel.setInputContent(it)
                },
                modifier = Modifier
                    .padding(16.dp)
//                    .height(32.dp)
            )
            Button(
                onClick = {
                    viewModel.onTapAddButton()
                }
            ) {
                Text(text = "追加")
            }
        }

        LazyColumn {
            items(todoItemList.items) { todoItem ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "${todoItem.name}")
                    Icon(painter = rememberVectorPainter(image = Icons.Default.CheckCircle), contentDescription = null)
                    
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
//        GreetingView("Hello, Android!")
    }
}
