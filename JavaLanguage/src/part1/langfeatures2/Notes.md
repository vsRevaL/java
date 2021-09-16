# Language features #2

- Static methods
- Class definitions
- Constructor
- final fields, immutable objects
- Object hash, equals

## Static methods

- For actions can be done without instance of the class.
- Can be accessed via instance (warning) or via the class.

### Static fields

- For data properties don't belong to an instance
- Can be accessed via instance (warning) or via the class.

```java
public class BicycleFactory{
    private static int instanceCounter = 0;
    // private BicycleFactory() constructor
    public static Bicycle createOne(){
        instanceCounter++;
        return new Bicycle();
    }
    
    public static int getNumberOfBicyclesMade(){
        return instanceCounter;
    }
}
```

```java
Bicycle aBicycle = BicycleFactory.createOne();
System.out.println("Number oif bicycles made: + BicycleFactory.getNumberOfBicyclesMade());
```

### Final members

Method/method

```java
import java.util.Arrays;

public class Main {
    public static final boolean DEBUG = true;

    public int sum(int[] arr) {
        if (DEBUG) {
            System.out.println("Sum params: " + Arrays.toString(arr));
        }
    }
}
```

## Class definitions

- One public class per compilation unit
- Classes may be `final`
- Nested class
    * Non-static nested classes (inner classes)
    * Static nested classes (`static`)
    
```java
package oo.basics;

class A { ... }

public class B{
    ...
    class C { ... }

    void f(){
        class D { ... }
        ...
    }
}
```

When to use which (makes more sense, needs to access inner representation, to the same file if not used elsewhere but important to keep them together, etc.)?

```java
package langfeatures2;

public class Main {
    int variable;

    public static void main(String[] args){
        // inner class
        Main a = new Main();
        Inner inner = a.new Inner();

        // static
        StaticInner staticInner = new StaticInner();
    }

    class Inner{
        void method1(){
            Main.this.variable = 5;
        }
    }

    static class StaticInner{ // fuggetlen

    }
}

class B{ // cannot be public

}
```

## Constructor

- Special "function" to create a class instance
- Same name as the class
- Can be overloaded
- Can have any access modifiers (even you can hide a constructor)
- Implicit no-arg constructor exists until you define other constructor(s)
- You can call super class' constructor: `super(...)`
- You can use `this` in constructor and all non-static methods/fields.

```java
<modifiers> <Classname>( <params> ){
    <initialization sequence>;
}
```

- Example:

```java
class Coord{
    private int x;
    private int y;
    
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Coord(){
        this(0,0);
    }
    ...
}
```

### this(), super()

```java
class A{
    protected int size;
    
    public A(int size){
        this.size = size;
    }
}

class B extends A{
    public B(){
        this(0); // calling B(int);
    }
    public B(int size){
        super(size); // calling A(int);
    }
    ...
}
```

## final fields, immutable objects

- all `final` fields have to be initialized
- `immutable object`: state can not be changed once created
  * How to make `immutable`?
    * don't provide "setter" methods
    * make all fields final and private
    * don't allow subclasses to override methods
    * special attention when having mutable instance variables
  

```java
class A{
    private final int size;
    
    public A(){
        size = 10; // without this assignment you will have compilation error
        size = 11; // error too (final)
    }
    ...
}
```

### Accessor methods

Hiding inner structure

```java
class Cord{
    private int x;
    private int y;
    ...
  public getX(){
        return x;
  }
  public void setX(int x){
        this.x = x;
  }
}
```

### Lifecycle

- Instantiation: `new` operator calls the constructor

`A a = new A(5);`

- Destruction is automatic (System.gc(), finalize(), etc.)
- Static/dynamic type:

`A a = new B(5);`
  
- Checking dynamic type:

```java
if (a instanceof B) { ... }
else if ( a instanceof C) { ... }
```

OR

```java
if(B.class.isAssignableFrom(a.getClass)) { ... }
else if (C.class.isAssignableFrom(a.getClass)) { ... }
```

## Object hash, equals

- Root class of all other classes implicitly.
- Class or instance?
- Most import methods:
  * `equals()`
  * `toString()`
  * `hashCode()`
  
`hashCode()` example:

```java
class Sample{
    private int i = 0;
    private String str = "str";
    private boolean b = false;
    
    @Override
    public int hashCode(){
        return ( i * 31 + str.hashCode() );
    }
}
```

### Sample implementations

```java
public class Student { // extends Object implicitly
    private String name;
    private String login;
    private int yearsAtUni;
    
    // ...
  
    @Override
    public boolean equals(final Object obj){
        if(obj instanceof Student){
            final Student other = (Student) obj;
            
            // TODO null checks
          
            return ( name.equals( other.name ) && // ugyannak a tipusnak a mezoit elerjuk akkor is, ha private
                    login.equals( other.login ) && 
                    yearsAtUni.equals( other.yearsAtUni));       
        }
        
        return false;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode() + login.hashCode() + yearsAtUni;
    }
    
    @Override
    public String toString(){
        return "Student [name=" + name + "," + "login=" + login + "," + "yearsAtUni=" + yearsAtUni + "]";
    }
}
```

### Overloading, overriding

- Overriding: if the **signature** is identical
- Overloading: **metgod name** is identical

- `@Override`

```java
class A{
    public int f(int a, int b) {};
    public int g() throws Exception {};
    public A h() {};
}

class B extends A{
    @Override
    int f(int a, int b) { return 0; } // Override
    
    void f(int a, int b) {}; // Error: incompatible return type - eredeti int-et adott vissza,
    
    int f(int a) { return f(a, 0); } // Overload (# of params)
    
    int f(Integer a, Integer b) { ... } // Overload (type of params)
    
    @Override
    int g() { return 0; } // OK: Exception omitted
  
    @Override
    B h() { return null; } // OK: Spec'd return type
}

```

## Excersie

```java
package langfeatures2;

public class Main{
    public static void main(String[] args){
        Car c = new Car();
        System.out.println("c:");
        c.move();

        System.out.println("(Vehicle)c:");
        ((Vehicle)c).move();

        System.out.println("v1:");
        Vehicle v1 = new Car();
        v1.move();

        System.out.println("v2:");
        Vehicle v2 = new Car();
        v2.move();

        System.out.println("v3:");
        Vehicle v3 = new Vehicle();
        v3.move();

        System.out.println("(Car)v3:");
        ((Car)v3).move();
    }
}

class Vehicle{
    public void move(){
        System.out.println("Vehicle.move() called()");
    }
}

class Car extends Vehicle{
    public void move(){
        super.move();
        System.out.println("Car.move called()");
    }
}

```

```java
package langfeatures2;

import java.util.Date;

public class Main{
    public static void main(String[] args){
        EmployeeRepository er = new EmployeeRepository();
        er.getEmp(new Date());
        er.getEmp(12345);
        er.getEmp("Java J Junior");
        er.getEmp(new StringBuilder("Java J Junior"));
        er.getEmp(null); // Compilation Error
        er.getEmp((int)null); // Compilation Error
        er.getEmp((Integer)null); // NullPointerException
        er.getEmp((Date)null);
    }
}

class Employee{

}

class EmployeeRepository{
    public Employee getEmp(int empId){
        System.out.println("getEmp(int empId) called");
        return new Employee();
    }

    public Employee getEmp(double empId){
        System.out.println("getEmp(double empId) called");
        return new Employee();
    }

    public Employee getEmp(String empName){
        System.out.println("getEmp(String empName) called");
        return new Employee();
    }

    public Employee getEmp(CharSequence empName){
        System.out.println("getEmp(CharSequence empId) called");
        return new Employee();
    }

    public Employee getEmp(Date dob{
        System.out.println("getEmp(Date dob) called");
        return new Employee();
    }
}
```


<br>
<br>
<br>
<br>