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

// -> using multiple jobs (you can call multiple coroutin function inside one corotuine scope and using join can wait to finish.)


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
        var fbFollowers =  0
        var instaFollowers =  0

        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers =  getFbFolllowers()
        }

        val job2 = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers =  getInstaFolllowers()
        }
        
        // we can use the two method  call inside on corotune and wait for it to finish using join. 
        job.join()
        job2.join() // this will wait untill the two coroutine is done executing. 

        Log.d(TAG, fbFollowers.toString()) // 54 
        Log.d(TAG, instaFollowers.toString()) //  51
    }

    private suspend fun getFbFolllowers(): Int {
        delay(1000)
        return 54
    }


    private suspend fun getInstaFolllowers(): Int {
        delay(1000)
        return 51
    }

}
