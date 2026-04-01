package com.github.xvar.todo

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.core.app.AppComponentFactory

class TodoAppFactory : AppComponentFactory() {

    override fun instantiateActivityCompat(
        cl: ClassLoader,
        className: String,
        intent: Intent?
    ): Activity {
        if (className == ActivityStub::class.java.name) {
            return MainActivity(TodoRepository())
        }
        return super.instantiateActivityCompat(cl, className, intent)
    }
}
