# Coroutines

## Multithreading and concurrency

Concurrency allows multiple units of code to execute out of order or seemingly in parallel permitting more efficient use of resources. The operating system can use characteristics of the system, programming language, and concurrency unit to manage multitasking.


![concurrency image](https://github.com/tastethedream/gdg_kotlin_course/blob/main/notes/images/concurrency.png)

As your app gets more complex, it's important for your code to be non-blocking. This means that performing a long-running task, such as a network request, won't stop the execution of other things in your app. Not properly implementing concurrency can make your app appear unresponsive to users.

A thread is the smallest unit of code that can be scheduled and run in the confines of a program. Here's a small example where we can run concurrent code.

You can create a simple thread by providing a lambda.

```
fun main() {
    val thread = Thread {
        println("${Thread.currentThread()} has run.")
    }
    thread.start()
}
```

## Creating and running multiple threads

The code will create 3 threads printing the information line from the previous example.

```
fun main() {
   val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
   repeat(3) {
       Thread {
           println("${Thread.currentThread()} has started")
           for (i in states) {
               println("${Thread.currentThread()} - $i")
               Thread.sleep(50)
           }
       }.start()
   }
}
```

## Challenges with threads

### Threads require a lot of resources

Creating, switching, and managing threads takes up system resources and time limiting the raw number of threads that can be managed at the same time. The costs of creation can really add up.

While a running app will have multiple threads, each app will have one dedicated thread, specifically responsible for your app's UI. This thread is often called the main thread or UI thread.

Because this thread is responsible for running your app's UI, it's important for the main thread to be performant so that the app will run smoothly. Any long-running tasks will block it until completion and cause your app to be unresponsive.

The operating system does a lot to attempt to keep things responsive for the user. Current phones attempt to update the UI 60 to 120 times per second (60 at minimum). There's a short finite time to prepare and draw the UI (at 60 frames per second, every screen update should take 16ms or less). Android will drop frames, or abort trying to complete a single update cycle to attempt to catch up. Some frames drop and fluctuation is normal but too many will make your app unresponsive.

### Race conditions and unpredictable behavior

As the processor switches between sets of instructions on different threads, the exact time a thread is executed and when a thread is paused is beyond your control. You can't always expect predictable output when working with threads directly.

For example the following code uses a simple loop to count from 1 to 50, but in this case, a new thread is created for each time the count is incremented. Think about what you'd expect the output to look like and then run the code a few times.

```
fun main() {
   var count = 0
   for (i in 1..50) {
       Thread {
           count += 1
           println("Thread: $i count: $count")
       }.start()
   }
}
```

Contrary to what the code says, it looks like the last thread was executed first, and that some of the other threads were executed out of order. If you look at the "count" for some of the iterations, you'll notice that it remains unchanged after multiple threads. Even more odd, the count reaches 50 at Thread 43 even though the output suggests this is only the second thread to execute. Judging from the output alone, it's impossible to know what the final value of count is.

This is just one way threads can lead to unpredictable behavior. When working with multiple threads, you may also run into what's called a race condition. This is when multiple threads try to access the same value in memory at the same time. Race conditions can result in hard to reproduce, random looking bugs, which may cause your app to crash, often unpredictably.

Performance issues, race conditions, and hard to reproduce bugs are some of the reasons why we don't recommend working with threads directly. Instead, you'll learn about a feature in Kotlin called Coroutines that will help you write concurrent code.


## Coroutines in Kotlin

Creating and using threads for background tasks directly has its place in Android, but Kotlin also offers Coroutines which provide a more flexible and easier way to manage concurrency.

Coroutines enable multitasking, but provide another level of abstraction over simply working with threads. One key feature of coroutines is the ability to store state, so that they can be halted and resumed. A coroutine may or may not execute.

The state, represented by continuations, allows portions of code to signal when they need to hand over control or wait for another coroutine to complete its work before resuming. This flow is called cooperative multitasking. Kotlin's implementation of coroutines adds a number of features to assist multitasking. In addition to continuations, creating a coroutine encompasses that work in a `Job`, a cancelable unit of work with a lifecycle, inside a CoroutineScope. A `CoroutineScope` is a context that enforces cancellation and other rules to its children and their children recursively. A `Dispatcher` manages which backing thread the coroutine will use for its execution, removing the responsibility of when and where to use a new thread from the developer.


* Job - A cancelable unit of work, such as one created with the launch() function.

* CoroutineScope - Functions used to create new coroutines such as launch() and async() extend CoroutineScope.

* Dispatcher - Determines the thread the coroutine will use. The Main dispatcher will always run coroutines on the main thread, while dispatchers like Default, IO, or Unconfined will use other threads.


```
import kotlinx.coroutines.*

fun main() {
    repeat(3) {
        GlobalScope.launch {
            println("Hi from ${Thread.currentThread()}")
        }
    }
}
```

> Hi from Thread[DefaultDispatcher-worker-2@coroutine#2,5,main]
> Hi from Thread[DefaultDispatcher-worker-1@coroutine#1,5,main]
> Hi from Thread[DefaultDispatcher-worker-1@coroutine#3,5,main]

The `launch()` function creates a coroutine from the enclosed code wrapped in a cancelable Job object. `launch()` is used when a return value is not needed outside the confines of the coroutine.

### RunBlocking

RunBlocking, starts a new coroutine and blocks the current thread until completion. It is mainly used to bridge between blocking and non-blocking code in main functions and tests.



