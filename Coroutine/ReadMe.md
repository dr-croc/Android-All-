### Why thread is not better 

Thread usually takes up more space. Usually it takes around 2mb in OS. And it depends on the system about how much thread it can create. 

### Context switiching
context switching is also hard. Context switching is you want to  do some work in the main thread and some work in background thread. But in case of thread its hard to do. 

## Coroutines 
Coroutine scope = life time of the coroutine. Inside the scope boundary the coroutines are defined. So it helps to destroy it easily.
Coroutin context = Thread  - in which thread coroutine will e launched. 

## Dispatchers 
Dispatecher is a way to define context / thread on which Coroutines are executed.  Threre are three pre defined - different kind of threads : 
1. IO
2. Main
3. Default

## Suspend function
Coroutines helps to implement the functionality that can be suspended or later resumed at specific points without blocking the thread. 
Suspending functions must be called from either corouties or other suspending function. 


## Job 
job helps to manage coroutine. Job object is used to wait until coroutine scope is done. 
job.join() // it used when we need to wait untill the coroutine is finished, then it executes the rest of the line. 
job is used to handle the coroutine, for example to start it . to finish it. Or to wait for the coroutine etc. 






