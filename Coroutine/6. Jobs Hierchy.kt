class MainActivity : AppCompatActivity() {

    val TAG : String = "MainActivity"
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch{
            printFollowers()
        }
    }

    private suspend fun printFollowers() {
        // inside one scope we are defining another coroutine scope
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Parent Started")

            val childJob = launch {
                Log.d(TAG, "Child Job Started")
                delay(5000)
                Log.d(TAG, "Child Job Ended")
            }
            delay(3000)
            Log.d(TAG, "Parent Ended")

        }
        parentJob.join()
        Log.d(TAG, "Parent Completed")
    }
}
