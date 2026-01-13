# kotlinstudy
class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
//        val age = ""

//        GlobalScope.launch {
//            delay(3000)
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//        }
//        GlobalScope.launch(Dispatchers.IO) {
////            print(doNetworkCall())
//            val ans = doNetworkCall()
//            withContext(Dispatchers.Main){
//                Log.d("MainActivity", "onCreate: $ans")
//                Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//
//
//                Toast.makeText(this@MainActivity, ans, Toast.LENGTH_SHORT).show()
//            }
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//        }
//        Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")

        // dispatchers

//        runBlocking {
//            launch(Dispatchers.IO) {
//                Log.d("MainActivity", "onCreate: Hello from coroutine-- ${Thread.currentThread().name}")
//                delay(3000)
//                Log.d("MainActivity", "onCreate: Hello from coroutine- ${Thread.currentThread().name}")
//                withContext(Dispatchers.Main){
//                    Log.d("MainActivity", "onCreate: Hello from coroutine-- ${Thread.currentThread().name}")
//                    Toast.makeText(this@MainActivity, "ans", Toast.LENGTH_SHORT).show()
//
//                }
//            }
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//            delay(5000)
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//        }
//        setContent {
//            Text(
//                modifier = Modifier
//                            .fillMaxSize()
//                            .padding(12.dp),
//                text = "hello"
//            )
//        }
//    }


        // jobs , waiting and cancellation jobs

//        val job = GlobalScope.launch {
//            repeat(5){
//                Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//                delay(1000)
//                if (isActive){
//                    Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//                }
//            }
//        }
//
//        runBlocking {
//            delay(2000)
////            job.join()
//            job.cancel()
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//        }


        // async and await in coroutine ----

//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//
//                var ans1: String? = null
//                var ans2: String? = null
//               val job1 =  launch {
//                    ans1 = doNetworkCall1()
//                }
//               val job2 = launch {
//                    ans2 = doNetworkCall2()
//                }
//                job1.join()
//                job2.join()
//
//                Log.d("MainActivity", "onCreate:doNetwork1 $ans1")
//                Log.d("MainActivity", "onCreate:doNetwork2 $ans2")
//            }
//            Log.d("MainActivity", "onCreate:time taken ${time}ms")
//        }

//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//
//                val ans1 =
//                    async { doNetworkCall1() } // async is used to run the function in the background thread
//                val ans2 = async { doNetworkCall2() }
//
//                Log.d(
//                    "MainActivity",
//                    "onCreate:doNetwork1 ${ans1.await()}"
//                ) // await is used to wait for the result of the coroutine
//                Log.d(
//                    "MainActivity",
//                    "onCreate:doNetwork2 ${ans2.await()}"
//                ) // await is used to wait for the result of the coroutine
//
//            }
//            Log.d("MainActivity", "onCreate:time taken ${time}ms")
//        }    
}

    suspend fun doNetworkCall1(): String {
        delay(3000)
        return "this is the data from db"
    }
    suspend fun doNetworkCall2(): String {
        delay(3000)
        return "this is the data from db"
    }


}