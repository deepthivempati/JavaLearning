# Arrays

```java
boolean primitiveBoolArray[] = new boolean[size];//Initialized by default with False
//Initialize the array with all true
Arrays.fill(primitiveBoolArray, true);

List<Integer> integerList = Arrays.asList(1,2);

Integer integerArray[] = {1,2};
int result2 = Arrays.stream(integerArray).reduce((a,b) -> a+b).orElse(-1);

Student studentArray[] = studentList.toArray(new Student[studentList.size()]);
//sorting via ArraysArrays.sort(studentArray, Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName));
```

