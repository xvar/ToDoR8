package com.github.xvar.todo

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.core.app.AppComponentFactory

class TodoAppFactory : AppComponentFactory() {

    private lateinit var app: TodoApp

    override fun instantiateApplicationCompat(cl: ClassLoader, className: String): Application {
        app = super.instantiateApplicationCompat(cl, className) as TodoApp
        return app
    }

    override fun instantiateActivityCompat(
        cl: ClassLoader,
        className: String,
        intent: Intent?
    ): Activity {
        if (className == ActivityStub::class.java.name) {
            return MainActivity(app.todoRepository)
        }
        return super.instantiateActivityCompat(cl, className, intent)
    }
}
