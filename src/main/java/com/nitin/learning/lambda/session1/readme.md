
## Functional Interface
SAM : Single Abstract Method

MyfunctionalInterface0 mf = () -> System.out.println("Some String");

Any method that accepts Functional Interface as parameter, needs a Lambda

```java
 // ForEach receives a Consumer functional parameter
// Functional Interface : can automatically be elevated to lambda expression
// In other words, you can Only use lambdas for functional interfaces
// A functional interface is a SAM (Single abstract Method) interface. it can only have one abstract method
// that method has signature with parameter coming in.
// Functional interface assign a contract!!

default void forEach(Consumer<? super T> action);
        
list.forEach(val -> System.out.println(val));

//OR
Consumer d = x -> System.out.println(x);
list.forEach(val -> d.accept(val));
```
## Valid Lamdba

For Simpler one liner Lambdas, with or without parameters
```java
MyFunctionalInterface0 xx = () -> System.out.println("Tests");
MyFunctionalInterface1 y = (x -> x+x);//Providing the definition to the abstract method
MyFunctionalInterface2 deepthi = (val1, val2) -> val1 * val2;//Valid Lambda as 2 arguments are expected


@FunctionalInterface
interface MyFunctionalInterface0{
    //SAM : Single Abstract Method
    void doSomework();
}

@FunctionalInterface
interface MyFunctionalInterface1{
    Integer doSomeJob(int a);
}

@FunctionalInterface
interface MyFunctionalInterface2{
    Integer doSomeTask(int a, int b);
}
```

