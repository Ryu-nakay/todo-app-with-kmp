package com.example.todoappwithkmm

class TodoItem(name: String, state: State) {
    val name = name
    val state = state

    fun toggleState(): TodoItem {
        val newState = when(this.state) {
            State.TODO -> State.DONE
            State.DONE -> State.TODO
        }

        return TodoItem(name = this.name, state = newState)
    }

    enum class State {
        TODO,
        DONE
    }
}