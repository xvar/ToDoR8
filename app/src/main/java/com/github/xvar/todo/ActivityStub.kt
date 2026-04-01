package com.github.xvar.todo

import androidx.activity.ComponentActivity

/**
 * Пустая заглушка, зарегистрированная в манифесте.
 * Реальная Activity (MainActivity) не в манифесте — R8 её обфусцирует.
 * AppComponentFactory подменяет этот класс на MainActivity при создании.
 */
class ActivityStub : ComponentActivity()
