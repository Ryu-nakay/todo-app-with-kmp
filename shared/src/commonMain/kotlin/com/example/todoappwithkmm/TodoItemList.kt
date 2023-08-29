package com.example.todoappwithkmm

class TodoItemList {
    val items = mutableListOf<TodoItem>()

    fun addNewItem(name: String) {
        val newItem = TodoItem(name = name, state = TodoItem.State.TODO)
        items.add(newItem)
    }
}