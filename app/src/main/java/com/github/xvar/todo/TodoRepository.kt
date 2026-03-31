package com.github.xvar.todo

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoRepository {

    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos: StateFlow<List<TodoItem>> = _todos.asStateFlow()

    fun add(text: String) {
        val item = TodoItem(text = text)
        _todos.update { listOf(item) + it }
    }

    fun toggle(id: String) {
        _todos.update { list ->
            list.map { if (it.id == id) it.copy(isDone = !it.isDone) else it }
        }
    }

    fun delete(id: String) {
        _todos.update { list -> list.filter { it.id != id } }
    }
}
