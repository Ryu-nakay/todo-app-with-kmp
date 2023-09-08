package com.example.todoappwithkmm.android
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoappwithkmm.TodoItemList

class TodoViewModel: ViewModel() {
    val inputContent = mutableStateOf<String>("")
    var todoItemList = MutableLiveData(TodoItemList.createEmpty())

    fun setInputContent(text: String) {
        inputContent.value = text
    }

    fun onTapAddButton() {
        todoItemList.value = todoItemList.value?.addNewItem(inputContent.value)
        print(todoItemList.value?.items)
        inputContent.value = ""
    }
}