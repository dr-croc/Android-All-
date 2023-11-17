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
        var followers =  0
        val job = CoroutineScope(Dispatchers.IO).launch {
            followers = getFbFolllowers()
        }
        job.join() // this wait for the coroutine to finish. without it , we will get 0. With it we will get 54
        Log.d(TAG, followers.toString())
    }

    private suspend fun getFbFolllowers(): Int {
        delay(1000)
        return 54
    }

}
