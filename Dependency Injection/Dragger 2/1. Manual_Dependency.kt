class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRepo  = UserRepo()
        val emailService = EmailService()

        val reg = UserRegistration(userRepo, emailService) // this is called manual dependency
        // , as we are providing the dependencies in constructor.
        // this is not good if we provide it for many class 
        reg.registerUser("s@gmail.com","11111")
    }
}
