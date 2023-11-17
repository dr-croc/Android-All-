package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val tag : String = "MainActivity"
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // button was set on Click
    // Define different launching coroutines in  IO, Default, Main thread
    fun doAction(view: View){
        CoroutineScope(Dispatchers.IO).launch {// IO
            Log.d(tag, "${"IO "+Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.Main).launch {   // Main thread
            Log.d(tag, "${"Main "+Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.Default).launch {  // Default thread
            Log.d(tag, "${"Default "+Thread.currentThread().name}")
        }
    }
}
