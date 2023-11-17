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

        // this will be done in parallel. its really important to get the perfomance boost. because if i use one by one, eah will take one second, In total 2 second
        // but in case we need only one. as we are doing this parllelly
     CoroutineScope(Dispatchers.IO).async {
           var fb = async { getFbFolllowers()  }
           var insta = async { getInstaFolllowers()  }
         Log.d(TAG, fb.await().toString())
         Log.d(TAG, insta.await().toString())
        }
        
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
