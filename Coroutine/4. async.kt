
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

        val job = CoroutineScope(Dispatchers.IO).async {
           getFbFolllowers()
        }

        val job2 = CoroutineScope(Dispatchers.IO).async {
            getInstaFolllowers()
        }
        /*
        if you see the async code, you will see that we don't need to use any kind of variable, in case of async : 
        we get a deffered type, which return type value = the last line of the code. If its string then string , if its int then its int
        * */
        Log.d(TAG, job.await().toString())
        Log.d(TAG, job2.await().toString())
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
