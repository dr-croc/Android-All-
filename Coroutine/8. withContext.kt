class MainActivity : AppCompatActivity() {

    val TAG : String = "MainActivity"
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.async {
            executeWithLaunch()
            executeWithContext()
        }

    }

    // this is called non blocking, which means, that it will run parallely with the code
    private suspend fun executeWithLaunch(){
        Log.d(TAG, "Before executeWithLaunch")
        GlobalScope.launch {
            delay(1000)
            Log.d(TAG, "Inside executeWithLaunch")
        }
        Log.d(TAG, "After executeWithLaunch")
    }
    // out put of the above method    
2023-11-17 21:23:22.787 16255-16290 MainActivity            com.example.learning                 D  Before executeWithLaunch
2023-11-17 21:23:22.788 16255-16290 MainActivity            com.example.learning                 D  After executeWithLaunch

  

    // this is called blocking, which means, that it will run sequentially, with the code
    // until the global scope is not executed, the rest of the code will not be executed
    private suspend fun executeWithContext(){
        Log.d(TAG, "Before executeWithContext")
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG, "Inside executeWithContext")
        }
        Log.d(TAG, "After executeWithContext")
    }
    // out put of the above method
2023-11-17 21:24:12.833 16376-16411 MainActivity            com.example.learning                 D  Before executeWithContext
2023-11-17 21:24:13.851 16376-16411 MainActivity            com.example.learning                 D  Inside executeWithContext
2023-11-17 21:24:13.852 16376-16411 MainActivity            com.example.learning                 D  After executeWithContext
    
}



