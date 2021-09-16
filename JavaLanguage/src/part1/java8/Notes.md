# java8 updates

- Language features
    * Lambdas and Functional Interfaces
    * Method references
    * Interface default and static methods
    * Extended Annotation support
    

- Compiler & VM features
    * Parameter names
    * Removal of PermGen
    

- Library features
    * Stream API
    * Optional
    * New Date and Time API
    * JavaScript engine
    * Parallel arrays
    * Concurrency
  


## Lambda expression
  
```java
System.out.println("Max price: ");
int maxPrice = 0;
for(Transaction transaction : transactions){
    if(transaction.getPrice() > maxPrice){
        maxPrice = transaction.getPrice();
    }
}
System.out.println(maxPrice);
```

```java
OptionalInt max = transactions.stream().mapToInt(transaction -> transaction.getPrice()).max();
```

Filtering, Summation

```java
transactions.stream()
        .filter(transaction -> transaction.getCity().equals("cityName"))
        .mapToInt(transaction -> transaction.getPrice())
        .sum();
```

Searching for the Max

```java
transactions.stream()
        .max((a, b) -> Integer.compare(a.getPrice(), b.getPrice())).get().getStreet();
```

## Dates, Time

```java
import java.time.*;
import java.util.Calendar;

public class Main {
  public static void main(String[] args) {
    //Calendar calendar = Calendar.getInstance(); // OLD
    //calendar.get(Calendar.YEAR);

    LocalDate.now();
    System.out.println(LocalDate.now());
    System.out.println(LocalDate.of(2014, 2, 17));
    System.out.println(LocalDate.ofYearDay(2014, 65));

    System.out.println(LocalTime.now());
    System.out.println(LocalDateTime.now());

    System.out.println(LocalTime.now(ZoneId.of("America/New_York")));
    System.out.println(LocalTime.now(Clock.systemUTC()));

    ZonedDateTime now = ZonedDateTime.now();
    System.out.println(now);
  }
}
```

<br>

[ In process.. maybe]

<br>
<br>
<br>
<br>
<br>