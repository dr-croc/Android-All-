class MainActivity : AppCompatActivity() {

    val TAG : String = "MainActivity"
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            execute()
        }

    }

    private suspend fun execute(){
        val parentJob = CoroutineScope(Dispatchers.IO).launch {

            for (i in 1..1000){
                if (isActive){
                    executeLongRunningTask()
                    Log.d(TAG, i.toString())
                }
            }
        }
        delay(100)
        Log.d(TAG, "Cancelling Job")
        parentJob.cancel() // even if you add cancel in here, if you didn't add the the cancellatio check in the scope, then it will continue to run.
                            // so we need to add cancellation check in the code as well
        parentJob.join()
        Log.d(TAG, "Parent Job Completed.")
    }

    private fun executeLongRunningTask(){
        for (i in 1..1000000){

        }
    }
    
}
