package com.example.todoappwithkmm

class TodoItemList {
    var items = emptyArray<TodoItem>()

    fun addNewItem(name: String) {
        val newItem = TodoItem(name = name, state = TodoItem.State.TODO)
        this.items = this.items + arrayOf(newItem)
    }
}