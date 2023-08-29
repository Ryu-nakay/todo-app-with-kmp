package com.example.todoappwithkmm

class TodoItemList(items: Array<TodoItem>) {
    val items = items

    companion object {
        // SwiftからKotlinArrayを初期化するのがツライのでKMM内のメソッドで初期化できるようにしている
        fun createEmpty(): TodoItemList {
            return TodoItemList(items = emptyArray<TodoItem>())
        }

    }

    fun addNewItem(name: String): TodoItemList {
        val newItem = TodoItem(name = name, state = TodoItem.State.TODO)
        val newItems = this.items + arrayOf(newItem)
        return TodoItemList(items = newItems)
    }
}