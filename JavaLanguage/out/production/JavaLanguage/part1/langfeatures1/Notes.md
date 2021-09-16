# Language features #1

- Object
- Arrays
- Enumerations
- Methods
- Variable Scopes
- User interaction

## Object

- Root class of all other classes implicitly
- Class or instance
- Most important methods:
    * `equals()` - ha referencia megegyezik, az osztaly megegyezik alapbol
    * `hashCode()` - 2 osztaly megegezik, hashCode is megegyezik
    * `toString()` 
  
## Arrays

- Syntax:

```java
int[] scores = new int[2];
scores[2] = 10;
scores[1] = scores[0];
```

- In place initialization of multidimensional array:

```java
String[][] names = {
                        {"Mr. ", "Mrs. ", "Ms. "},
                        {"Smith", "Jones"}
                   };

System.out.println(names[0][0] + names[1][0]); // Mr. Smith
System.out.println(names[0][2] + names[1][1]); // Ms. Jones
```

- There is a `T[]` type for every `T` type
- It's a reference: may be `null`!
- Indexing: from `0`
- Out of bounds check: `ArrayIndexOutOfBoundException`
- Default values for the elements (null, 0, false, ..) - tipustol fugg

```java
// barr1, barr2, barr3 are equivalent
boolean[] barr1 = { true, false};
boolean[] barr2 = new boolean[] {true, false}; // as an expression, it's mandatory!
boolean[] barr3 = new boolean[2];
barr3[0] = true; barr3[1] = false;
```

- Iteration:

```java
int arr[] = {1,2,3,4,5};
for(int i=0; i<arr.length; i++){
    System.out.println(arr[i]);
}
```

- Multi dimensional:

```java
public static void enumerate(int[][] arr){
    for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr[i].length; j++){
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }
}
...
enumerate( new int[][] {
        {0, 1},
        {2, 3}
});
```

- Initialization: first dimension has to be specified
`int[][] arr = new int[5][];`
  
### Array type expressions

New is required:

```java
public static int sum(int[] arr){...}

public static void main(String[] args){
       int result = sum( new int[] {1, 2, 3});
}
```

### Utility class

See java.util.Arrays, many useful features toString(), fill(), binarySearch(), etc

## Enumerations

- Introduced in Java 5.0
- Used for predefined set of constants, like days of week:
```java
public enum Day{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

- Can be easly used in `switch` formula.
- Could have data fields and constructors

## Methods

- Method declaration: `<acces modifier> [abstract] <return type> <method name> (<parameter list>) [throws <exception list>] 
[{<method body>}]`

| Modifier | Class | Package | Subclass | World
| ------- |------- | ------- | -------- | ----
| `public` | Y | Y | Y | Y
| `protected` | Y | Y | Y | N
| *no modifiers* | Y | Y | N | N
| `private` | Y | N | N | N


- Abstract method has no body
- Method names can be overloaded:
lehet ugyanolyan nevu, de parameterezes kulonbozo kell legyen

```java
public abstract class AbstractDrawer {
  public abstract void draw(String s);
  public abstract void draw(Integer i);
  
  draw(null) // compile error
}    
```

- Method modifiers
  * `abstract`: no implementation (cf. C++ pure virtual methods)
  * `final`: cannot override
  * `static`: static method (**Important**: static context!)
  * Others: `strictfp, native, synchronized,`
  
- Returning value: specific or `void`
- Naming conventions: `lowerCamelCase` format
- Parameter passing: **pass-by-value**, everything
- Method signature

## Variable Scopes

- Local vars
  * E.g counter if a loop
- Method parameter
  * for pass information to a method
- Instance vars
  * for state of an isntance
- Class vars
  * E.g count of instances

```java
public class Main {
    public static void inc(int i){
        i++;
    }

    public static void inc2(Integer i){
        i++;
    }

    public static void main(String[] args) {
        int i = 0;
        inc(0);
        System.out.println(i); // 0
        inc2(i);
        System.out.println(i); // 0
    }
}
```  

## User interaction

```java
java.io.Console c = System.console();
String line = c.readLine();
int lineAsInt = Integer.parseInt( line );
```

<br>
<br>
<br>
<br>
<br>





