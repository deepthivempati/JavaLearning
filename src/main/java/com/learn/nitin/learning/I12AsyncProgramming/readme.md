
Both parallel and Async will ne a separate thread (other than main thread)
    * for parallel, the thread needs to JOIN. meaning the slower process will determine the overall speed
    * pen refills (10), cap(20 per hoor) and body(50 body per hours) example. Total pens per hour = 10

For Asynchronous, need to wait for the completion, but when the results arrive, then move on to something eles
    * uses call back mechanisms
    * Non blocking : when you make a call, you don't have to wait for it to complete.

Concurrency : looking for a new job while working in the current job -> concurrency. Working in 2 job together is parallel

| Functional Interface | Method         | Streams API | Async API     |
|:---------------------|:---------------|:------------|:--------------|
| Predicate &lt;T>     | boolean test() | filter()    |               |
| Function<T,R>        | R apply(T k)   | map()       | thenApply     |
| Consumer&lt;T>       | void accept(T) | forEach()   | thenAccept()  |
| Supplier&lt;T>       | T get()        | Factories   | supplyAsync() |


Async programming

* Call back
  * CallBack lacks consistency
  * Really hard to compose call backs
  * hard to deal with error


* Promise
    * resolve. reject. pending

```java
data track    ---------f-----f----------f----------
                              \        /
error track   -----------------e------f------------
```
* Exception handling (imperative style) in functional programming is mutually exclusive
* error track is also a data track which is of type error

For Stream -> 1 or many data (Collection)
For Promise -> 0 or 1 data 

## CompletableFuture (Promise in Java)
    Stages of Completable future 
    When one stage completes, another begins...and it keeps running


## History of multithreads

Java 1 : Threads -> one set of API for all machines. hardware independent

Java 5 : ExecutorServices API -> Pool of threads
* Issue 1: Pool induced deadlock
* One thread breaks the problem and throws in the pool and waits foe the result to come back
* All the threads in pool just divided the work, and no thread left to take care of the problem

Java 7 : Fork Join pool
* Workstealing : the threads that divides problem, also solves one of the divided part

Java 8 : uses Java 7 FJP
* Common Fork join pool