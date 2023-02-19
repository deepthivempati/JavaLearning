
Imperative style -> what to do and How to do
```java
//What to do? : Iterate over the list
for(int i = 0; i < list.size(); i = i+1)//How to do -> one by one OR alternate elements
```

Functional style -> only What to do (intent)
```java
//What to do? : Iterate over the list
list.stream.forEach(x -> System.out.println(x));//iterates one by one ; Skipped how to do

map.forEach((k,v) -> System.out.println(k+":"+v));
```


## Pillars of Code Quality

* Testability
* Maintainability
* Readability

