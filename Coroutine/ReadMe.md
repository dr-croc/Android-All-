### Why thread is not better 

Thread usually takes up more space. Usually it takes around 2mb in OS. And it depends on the system about how much thread it can create. <br />

### Context switiching
context switching is also hard. Context switching is you want to  do some work in the main thread and some work in background thread. But in case of thread its hard to do. 

## Coroutines 
Coroutine scope = life time of the coroutine. Inside the scope boundary the coroutines are defined. So it helps to destroy it easily.<br />
Coroutin context = Thread  - in which thread coroutine will e launched. <br />

## Dispatchers 
Dispatecher is a way to define context / thread on which Coroutines are executed.  Threre are three pre defined - different kind of threads : <br />
1. IO
2. Main
3. Default

## Suspend function
Coroutines helps to implement the functionality that can be suspended or later resumed at specific points without blocking the thread. <br />
Suspending functions must be called from either corouties or other suspending function. <br />


## Job 
job helps to manage coroutine. Job object is used to wait until coroutine scope is done.  <br />
job.join() // it used when we need to wait untill the coroutine is finished, then it executes the rest of the line. <br />
job is used to handle the coroutine, for example to start it . to finish it. Or to wait for the coroutine etc. <br />

### Job Hierarcy
Launcing multiple coroutin, inside one coroutine. Which means that, we can call a IO corouine inside a MAIN thread coroutine and it will not cause any issue.  


## Async
Use launch : when we do not care about the result <br />
Use Async  : when we expect some result or output from the coroutin.  <br />
In the case  of Async, we get a deffered type, which return type value = the last line of the code. If its string then string , if its int then its int.  <br />
if you see the async code, you will see that we dont need to use any kind of variale, in case of async  <br />
why ? <br />
As i already mentioned above that it returns  a  deffered type which is basically referes the type of the value to the last line of the async. That is why we dont need to use any kind of variable to store the value.

## Cancel Coroutine
In the cancel coroutine file you can see that, there is a isActive method which basically checks if the coroutine is still active. Its really important to add it because without Adding it, or checking 'is Active', the coroutine will always run. 


## With Context 











