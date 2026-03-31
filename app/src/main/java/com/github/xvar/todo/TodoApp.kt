package com.github.xvar.todo

import android.app.Application

class TodoApp : Application() {

    val todoRepository = TodoRepository()
}
