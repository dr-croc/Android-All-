package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {

    val TAG : String = "MainActivity"
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch{
            task1()
            task2()
        }
    }

    suspend fun task1(){
        Log.d(TAG, "Starting task 1")
        yield() // this points define that in this point our coroutine should be suspended.
        Log.d(TAG, "Ending task 1")
    }

    suspend fun task2(){
        Log.d(TAG, "Starting task 2")
        yield() // this points define that in this point our coroutine should be suspended.
        Log.d(TAG, "Ending task 2")
    }

}

// output 

2023-11-17 12:54:44.419 10601-10601 MainActivity            com.example.learning                 D  Starting task 1
2023-11-17 12:54:44.677 10601-10601 MainActivity            com.example.learning                 D  Ending task 1
2023-11-17 12:54:44.678 10601-10601 MainActivity            com.example.learning                 D  Starting task 2
2023-11-17 12:54:44.691 10601-10601 MainActivity            com.example.learning                 D  Ending task 2

