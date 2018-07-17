# Java中的异步
## 1. JDK
Future/Promise模式，Java程序异步执行耗时程序后立马返回一个对象Future代表将来，主程序会继续执行下去不会被阻塞。可以通过Future来获取异步的结果。
- Future和FutureTask  
有一个get方法，可以获取异步执行的结果，但是是个blocking api，例子
- CompletionService  
封装了线程池，能按任务完成的先后顺序来获取Future，当提交多个异步任务之后可以通过take来获取已经完成的Future并马上获取任务的结果。例子
- CompletableFuture  
Java8新的api，有50多个方法，能够在执行完任务之后回调函数，基于Promise模式
  ```Java
  //获取Future
  CompletableFuture.runAsync(Runnable runnable)

  CompletableFuture.supplyAsync(Supplier supplier)

  //逻辑判断
  CompletableFuture.allOf​(CompletableFuture<?>... cfs)

  CompletableFuture.anyOf​(CompletableFuture<?>... cfs)

  //常用实例方法，快速熟悉
  boolean isDone​()

  CompletableFuture thenApply​(Function<? super T,? extends U> fn)

  CompletableFuture thenAccept​(Consumer<? super T> action)

  CompletableFuture thenCombine​(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)

  CompletableFuture thenCompose​(Function<? super T,? extends CompletionStage<U>> fn)

  CompletableFuture whenComplete​(BiConsumer<? super T,? super Throwable> action)
  ```
---
建议：个人觉得就是比自己开线程更加方便。

## 2. Vert.x（Reactor模式）
Vert.x框架基于事件和异步，依托于全异步Java服务器Netty，并扩展了很多其他特性，以其轻量、高性能、支持多语言开发而备受开发者青睐。Event loop+Future

 - Vertx  
 用来部署Verticle，一个应用只有一个Vertx
 - Verticle(普通的Verticle没有多线程)  
 好像一个空间，代码都只有一条线程在跑，类似Actor
 - Handler  
 回调函数
 - EventBus(类似Actor))  
 各个Verticle之间通信