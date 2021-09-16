# Java Basics

- Naming Conventions
- Separators
- Compilation
- Jar
- Packages, Import
- Statements
- Reserved words
- Operators
- **String**
- Primitives

## Naming Conventions

| Element | Lettering | Characteristics | Example |
| ------- | --------  | -------------  | -------  |
|Class name | Begins uppercase continues camel case | Noun | `OfficeBuilding` |
| Interface name | Same as class name | Adjective ending when possible, like "able or "ible" | `Paintable` |
| Method name | Begins lowercase, continues camel case | Verb | `prepare` |
| Instance & static variable names | Same as method names | Noun | `color` |
|Parameters and local vars | Same as var names | Single words, acronyms or abbreviations | `colorCode` |
| Generic Type parameters | Single uppercase letter | Letter T is recommended | `T` |
| Constant | All uppercase letter | Multiple words separated by underscores | `BLUE_MODE` |
| Enumeration | Same as class names; set of object should be like constants | Noun | `enum WorkNeeded {PAINT_ONLY, RENOVATION_ONLY, PAINT_AND_RENOVATION}`
| Package | All lowercase letters | Public packages should be reversed domain name of the org. | `com.epam.training` |

Details: Java Code Conventions (some link)

## Sample

```java
package foo.bar; // top-level domain, lower case

/**
 * Class description
 * 
 * @author Mr. T
 * @version 1.0
 */

public class Foo extends Bar {
    
    /** On liner comment for classVar */
    public int classVar;
    
    /**
     * Constructor comment...
     * */
    public Foo(){
        // ...
    }
    
    /**
     * Comment for a simple function
     */
    public void doSomething(){
        // ...
    }

    /**
     * Some tricky function comment..
     * 
     * @param someParam arbitrary parameter; cannot be <code>null</code>
     * @return always 0
     */
    public int returnSomeValue(Object someParam){
        // ...
    }
}
```

## Separators

| Symbol | Description | Purpose |
| ------ | ----------- | ------- |
| `( )` | Parentheses | method arguments, cast types, arithmetic expression |
| `{ }` | Curcly brackets | code blocks, arrays |
| `[ ]` | Brackets | declares, initializes arrays |
| `< >` | Angle brackets | Encloses generics |
| `;` | Semicolon | terminatos statements at the end of a line. |
| `,` | Comma | separates identifiers in variable declarations, separates values, separates expression in a for loop. |
| `.` | Period | package names, object field or method, supports method chaining. |
| `:` | Colon | Follows loop labels and used in short form of if.
| `' '` | Single quotes | Defines single characters. |
| `" "` | Double quotes | Defines a string of characters. | 
| `//` | Forward slashes | Indicates a single line comment. |
| `/* */` | Forward slashes with asterisks | Indicates a block comment for multiple lines. |
| `/** */` | Forward slashes with double asterisks | Indicates javadoc comments. |

## Compilation

```java
/**
 * This is my first Java program.
 * @author Gyula
 * @since 01/26/2015
 * @version 1.0
 */
public class Hi{
    /**
     * Write Hi
     */
    public static void main(String[] args){
        System.out.println("Hi");
    }
}
```
### Compiling

`javac Hi.java`

### Execution

`java Hi`

### To make Javadoc

`javadoc Hi.java -d doc`

## Things to note

- Name of the `public` class == name of the compilation unit
- Std. Output: `System.out.println( ... );`
- Std. Error: `System.out.println( ... );`
- Escape sequences: `\r, \n, \t, \b`, etc.
- Exitting:`System.exit( 0 );`
- Handling the console: java.io.Console (link)

## Compilation process:

- You create `.java` files (sourcecode).
- Compiler compiles to `.class` files (bytecode).
- Optionally jar can pack the files into a `.jar` file
- JVM interprets these bytecode files and does the work

## Compiler reference
`javac [options] [sourcefiles] [@argfiles]`
- Important options
- `-d path` define output directory.
- `classpath` or `-cp` define class path.
- `-version` display version information of the compiler.
- OS wildcards may be user (`javac *.java` to compile the default package)
- Other arguments:
    * `sourcefiles` should have `.java` extension
    * `@argfiles` used for large number of arguments
    
## Jar

### About Jar

- Ordinary ZIP file with metadata in `META-INF/MAINFEST.MF` fle
- Created and manipulated by `jar` tool
- You can compress the files and specify them in the classpath 

### Main usage
- Create archive: `jar cf myJar.jar *.class`
- Update archive: `jar uf myJar.jar MyClass.class`
- Extract archive: `jar xf myJar.jar`
- Test archive: `jar tf myJar.jar`

### Other useful options
- `-v` for verbose
- `-f` for input/output file
- `-m` for manifest file
- `-C` dir target directory

## Execution

- `java [options] myClass [arguments]`
- `java [options] -jar myJar.jar [arguments]`

### Useful options
- `cp` or `-classpath` overrides the CLASSPATH environment variable
- `-Dkey=value` define or override system variable.
- `-version` display the version information.
- `Xms128m` initial memory allocation pool size.
- `Xmx1024m` maximum memory allocation pool size.

## Packages

### Packages basics
- Classes should be organized into packages
- Package structure reflects the directory structure
- Reverse domain package naming
- Class coupling
- System coupling
- Maintainability

### Package statement
- is optional (theoretically);
- can occur once in a java file.
- have to be the first line of the Java file.
- couldn't start with `java.*` and `javax.*` since these are reserved package names

## Import statements
- Immediately after package statement.
- Makes life easier: `new java.math.BigDecimal(1)` -> `new BigDecimal(1)`
- `java.lang.*` is automatically imported to every java file.
- Examples:

### Implicit import
` import java.net.*;`
### Explicit import
`import java.net.URL;`
### Implicit static import
`import static java.math.BigDecimal.*;`
### Explicit static import
`import static java.math.BigDecimal.ONE;`

## Packages - sample
```java
import java.util.Vector; // 1 type
import java.math.*; // Wildcard

import java.awt.*; // GUI
import java.awt.event.*; // GUI - Event handling
import javax.swing.*; // Improved GUI
import java.util.*; // Data structures
import java.io.*; // IO
import java.util.regex.*; // Regexp

//static import: for all static members ( function, constants)
import static java.lang.Math.*;
```

## Packages - place
```java
package ...;

// Import statements
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
}
```

## Packages - compilation

- **Always do that from the package root!**
- Compilation requires a full path:

`javac pkg/HelloWorldApp.kava`

- Running requires fully qualified classname

`java pkg.HelloWorldApp`

## Statements

### Expression statements
```java
var = 7; // Assignment
++var; // Pre-increment
--var; // Pre-decrement
var++; // Post-increment
var--; // Post-decrement
methodName(); // Method invocation
new MyClass(); // Object creation
```

### Conditional statements
- if-then. expression type: `boolean`
```java
if(value == 0){
    doSomething();
}
```

- if-then-else: expression type: `boolean`
```java
if(value == 0){
    doSomething();
}else if(value > 0){
    doSomethingElse();
}else{
    doFallbackThing();
}
```

- switch: expression types: `char, byte, short, int, String` (from Java7), enumeration types
```java
swtich(num){
    case 100: doSomething();
    case 200: doSomethingElse(); break;
    default: doFallbackThing(); break;
}
```

- Ternary operator:

```java
int var = (inputVar == null) ? 0 : inputVar
```

### Iteration statements

- for loop
```java
for(int i=0; i<10; i++){
    System.out.println(i);
}
```

- foreach-loop
```java
int numbers[] = {0,1,2,3,4,5,6,7,8,9};
for(int i : number){
    System.out.println(i)
}
```

- while-loop
```java
while (areWeThereNow){
    doTravel();
}
```

- do-while-loop
```java
do{
    doTravel();
}while (areWeThereNow);
```

Please avoid using `break` and `continue`!!!

## Reserved words
- The most important ones: `abstract, break, case, catch, class, default, do, else, extends, final, finally, for, goto, if, emplements, interface, return, strictfp, super, swtich, synchronized, this, throw, throws, try, void, while`
- The full list: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html

## Operators

### Assignment Operators

| Operator | Meaning
| -------- | -------
| `=` | Assignment
| `+=` | Assignment by addition
| `-=` | Assignment by subtraction
| `*=` | Assignment by multiplication
| `/=` | Assignment by division
| `%=` | Assignment by modulo division

### Arithmetic Operators
- `+` Addition
- `-` Subtraction
- `*` Multiplication
- `/` Division
- `%` Modulus


- Value of the expression is the wider type of its operands.
  * `double d = 1 / 2;`
  * `byte b = 1 + 2; // compilation error`
- Strict evaluation order:
  * `System.out.println("" + i++ + ++i); // = 02 ;  cf. C++`

### Relational Operators
`==; !=; <; >; <=; >=;`

### Logical Operators
```java
boolean ab = doA() | doB(); // if 1. is true, the 2. will run too
boolean cd = doC() || doD();
boolean ef = doE() & doF(); // if 1. is false, the 2. will run too
boolean gh = doG() && doH();
boolean ij = doI() ^ doJ(); // Exclusive or (XOR) - only one of them can be true
boolean k = !doK();
```

### Bitwise and Bit Shift Operators

```java
~   Unary bitwise complement
<<  Signed left shift
>>  Signed right shift
>>>>    Unsigned right shift
&   Bitwise AND
^   Bitwise exclusive OR
I   Bitwise inclusive OR
```

## String

- No need to use constructor every time
- Immutable
- Concatenation with `+`
- Equal evaluation: `myString.equals(otherString);`
- `public static String.format(String format, Object... args)`
- `StringBuilder` and `StringBuffer` to manipulate `String`
- Important method: `Object.toString()`


- Creation:
`String s = "Hi";`
  
- Beware of `null`:

```java
String nullString = null;
if(nullString != null){ // Check - if not null, i can only call any of its methods
    ...
}
nullString.isEmpty(); // null pointer exception
```

- Many useful features:

```java
int length = s.length();
char firstChar = s.charAt(0);
char[] arr = s.toCharArray();

boolean isExecutable = s.endsWith(".exe");
boolean isEmpty = s.isEmpty();
int aidx = s.indexOf('a');
boolean hasEM = s.contains('!');

String upper = s.toUpperCase();
String hai = s.substring(1,3);
String haiThere = hai + " there";
String[] haiThereArr = haiThere.split(" ");
```

- Iteration of its chars:

```java
for(int i=0; i<s.length(); i++){
    char act = s.charAt(i);
    // ...
}

for(char act : s.toCharArray()){
    // ...
}
```

- `replaceAll()`, `split()`: use with regexps, see Pattern at (link)

- Comparison: `equals()`

```java
boolean b1 = "a" == "a"; // Might be true
boolean b2 = "a".equals("a"); // Expected behaviour
```

- Don't forget: immutable structure!

```java
String string = "AAAxAAA";
string.replace('x','A');
System.out.println(string); // "AAAxAAA"
string = string.replace('x', 'A');
System.out.println(string); // "AAAAAAA"
```

### CharSeq's

Use `StringBuilder/StringBuffer:`

```java
StringBuffer sb = new StringBuffer();
sb.append("Hello ").append("World");
sb.reverse();
System.out.println( sb.toString() ); // "dlroW olleH"
sb.reverse();
sb.setCharAt(6,'-');
System.out.println( sb.toString() ); // "Hello-World"
sb.deleteCharAt(6);
ystem.out.println( sb.toString() ); // "HelloWorld"
sb.delete(0, sb.length() );
System.out.println( sb.toString() ); // ""
```

- StringBuffer is thread-safe (since 1.0)
- StringBuilder is not (since 1.5)

## Primitives

- Java is a statically typed language
- Special date types in Java.
- Fixed size memory footprint
- Primite type:
  * `boolean`: can be `true` or `false`, default value: `false`
  * `char`: a single 16-bit Unicode character 0 to 65,535, default value = `0`
  * `byte`: small, signed number on 8 bit: -128 to 127, default: `0`
  * `short`: 16 bit signed number: -32,768 to 32,767 default: `0`
  * `int`: 32 bit signed number: -2,147,483,648 to 2,147,483,647 default: `0`
  * `long`: 63 bit signed number: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 default: `0L`
  * `float`: 32 bit floating point number from pow(1.4e, -45) to pow(3.4e, +38) default: `0.0f`
  * `double`: 64 bit floating point number from pow(5e, -324) to pow(1.8e, +308), default: `0.0d`
  

- Each has its own wrapper class ( Integer, Double, Boolean, ...)
- Autoboxing and unboxing works automatically
  * `Integer i = 1;`
  * `int j = new Integer(2);`
- Conversion
  * Wider: automatic(byte --> int --> long)
  * Otherwise: explicit cast required(byte b = (byte)10)
- String conversion:
  * To string: `String s = "" + 1;` 8be careful to the precendence!)
  * From string: Integer.parseInt("1"), Double.parseDouble("2.0"); 
  

```java
public class IntegerValueOfTest{
    private static final int NUM = 127;
    
    public static void main(String[] args){
        Integer i1 = Integer.valueOf(NUM);
        Integer i2 = Integer.valueOf(NUM);
        System.out.println(i1 == i2); // TRUE, nem fog új obejtumot létrehozni -128 +127-ig
      
        i1 = NUM;
        i2 = NUM;
        System.out.println(i1 == i2); // TRUE, nem fog új obejtumot létrehozni -128 +127-ig
        
        i1 = new Integer(NUM);
        i2 = new Integer(NUM);
        System.out.println(i1 == i2); // FALSE, mert 2 objektum
    }
}
```

<br>
<br>
<br>
<br>