# Event Management System

A Java console-based Event Management System developed to demonstrate core Java and Object-Oriented Programming (OOP) concepts through a practical application.

The system supports:

- Event creation
- Event viewing
- Event updating and deletion
- Customer registration
- Event booking
- Ticket generation
- Payment generation

The Event Management System simulates the basic operations of an event-management platform.

### Users/Roles

There are three main users/roles in the application:

- **Admin** – Views the total number of events, updates events, and deletes events.
- **Organizer** – Creates/adds new events.
- **Customer** – Registers and books an available event.

### Java Concepts Used

### Encapsulation

**Definition :**

Encapsulation means wrapping data and methods together in a class and restricting direct access to the data.

**When to use :**

Encapsulation is used when we want to protect data from direct modification and control how the data is accessed.

**How to use :**

We can achieve encapsulation by declaring variables as `private` and providing `public` getter and setter methods.

```java
private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
```

**Where we used :**

We used encapsulation in the Event.java class.
```java
private String eventId;
private String name;
private Venue venue;
private int availableSeats;
```

**Why we used  :**

We used encapsulation to prevent other classes from directly modifying the event data and to control how the data is accessed.

### Inheritance

**Defination :**

Inheritance is a Java concept where one class acquires the properties and methods of another class. It helps in code reusability and represents an IS-A relationship.

**When to use :**

Use inheritance when one class has a natural IS-A relationship with another class and you want the child class to reuse the properties and methods of the parent class.

**How to use :**
Inheritance is implemented using the extends keyword.

```java
class Child extends Parent {

// properties and methods

 }
```
**Where we used :**

**1. Customer extends Person**

```java

public class Customer extends Person { // Customer-specific properties and methods }

```
Here, Customer is the child class and Person is the parent class.

The Customer class inherits the common properties and methods of Person.

This avoids writing the same common person-related code again inside Customer.

**2.Organizer extends Person**

```java

public class Organizer extends Person { // Organizer-specific properties and methods }

```

Here, Organizer is the child class and Person is the parent class.

The Organizer class can reuse the common properties and methods defined in Person while also having its own organizer-specific functionality.

**3. ConferenceEvent extends Event**

```java

public class ConferenceEvent extends Event { // ConferenceEvent-specific properties and methods }

```

Here, ConferenceEvent is the child class and Event is the parent class.

ConferenceEvent inherits the common event-related properties and methods from Event and can add its own conference-specific functionality.

**Why we used  :**

Code Reusability: Common properties and methods can be defined once in the parent class.

Reduces Code Duplication: Customer and Organizer can reuse the common functionality of Person.

Extensibility: ConferenceEvent can reuse Event functionality and add conference-specific features.

IS-A Relationship: Customer IS-A Person, Organizer IS-A Person, and ConferenceEvent IS-A Event.

### Abstraction

**Defination :**

Abstraction is a Java concept that hides implementation details and shows only the essential features to the user.

It can be achieved using abstract classes and interfaces.

**When to use :**

Use abstraction when we want to define common functionality for different classes while leaving some implementation details to the child classes.

**How to use :**

Abstraction can be implemented using:

abstract classes

abstract methods

interfaces

**Where we used :**

We used abstraction in the `Person` abstract class and through interfaces such as `CateringServices`, `EntertainmentServices`, and `DatabaseOperations`.

**1. Abstract Class - Person**

```java
public abstract class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getDetails();
}
```

Here

- abstract class Person → Defines Person as an abstract class.

- abstract String getDetails() → Defines an abstract method without implementation.

- name and age → Common properties shared by the child classes.

- The child classes provide their own implementation of getDetails().

**2. Interface - CateringServices**

```java
public interface CateringServices {

    void provideCatering();

}
```

- Here, CateringServices defines what operation should be performed without providing its implementation.

The implementation is provided by the class that implements the interface.

```java
public class ConferenceEvent extends Event
        implements CateringServices, EntertainmentServices {

    @Override
    public void provideCatering() {
        System.out.println("Conference catering arranged.");
    }

    @Override
    public void provideEntertainment() {
        System.out.println("Conference entertainment arranged.");
    }
}
```
**3.Interface Database Operations**

```java
public interface DatabaseOperations {

    void insert(Event e) throws InvalidEventDataException;

    void update(Event e);

    void delete(String eventId);

    Event fetch(String eventId);
}
```

- Database Operations interface defines the operations that should be performed.
- The EventManager class contains the actual implementaion

**Why we used :**

- Hide the implementation details
- Abstract classes and interfaces define common functionality for related classes.
- Code Reusability

### Polymorphism

**Definition :**

Polymorphism is a Java concept where **one method or object can take different forms**.

The word polymorphism means **"many forms"**.

It allows the same method to perform different actions depending on the object or the parameters provided.

**When to use :**

Polymorphism is used when we want to perform the **same operation in different ways**.

It helps make the code more **flexible, reusable, and easier to maintain**.

**How to use :**

Polymorphism can be achieved in Java in two ways:

- **Method Overloading** → Compile-time polymorphism
- **Method Overriding** → Runtime polymorphism

**Where we used :**

We used polymorphism in our Event Management System through **method overriding**.

The `Person` class defines the `getDetails()` method, and the child classes such as `Customer` and `Organizer` can provide their own implementation of this method.

**1. Method Overriding**

Parent class:

```java
public abstract class Person {

    public abstract String getDetails();

}
```

Child class - Customer:

```java
@Override
public String getDetails() {
    return "Customer Details";
}
```

Child class - Organizer:
```java
@Override
public String getDetails() {
    return "Organizer Details";
}
```

**Why we used :**
- Code reusability
- New child classes can provide their own implementation without changing the parent class.
- Child classes can provide specific implementations of parent methods.

### Exception Handling

**Definition :**

Exception handling is a Java mechanism used to **handle runtime errors** and prevent the program from terminating unexpectedly.

It allows the program to handle errors gracefully and continue its execution.

**When to use :**

Exception handling is used when there is a possibility of an error occurring during program execution, such as invalid input, invalid data, or other unexpected situations.

**How to use :**

Java provides several keywords for exception handling:

- `try` → Contains the code that may cause an exception.
- `catch` → Handles the exception.
- `throw` → Used to explicitly throw an exception.
- `throws` → Declares that a method may throw an exception.
- `finally` → Contains code that executes whether an exception occurs or not.

**Where we used :**

We used exception handling in the `EventManager` and `MainApp` classes.

We created a custom exception called `InvalidEventDataException` to handle invalid event data.

**1. Creating a Custom Exception**

```java
public class InvalidEventDataException extends Exception {

    public InvalidEventDataException(String msg) {
        super(msg);
    }

}
```

**2.Using throw :**

- In the EventManager class, we check whether the event object is null.

```java
@Override
public void insert(Event e) throws InvalidEventDataException {

    if (e == null)
        throw new InvalidEventDataException("Invalid event data");

    events.put(e.getEventId(), e);

    eventCount++;

    log("Inserted: " + e);
}
```

**3.Using throws :**
- The insert() method declares that it may throw InvalidEventDataException.

```java
public void insert(Event e) throws InvalidEventDataException
```

**4.Using try-catch :**

```java
try {
    eventManager.insert(name, v, seats);
} catch (InvalidEventDataException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Why we used :**

- The application can handle errors without immediately crashing.
- Provides meaningful error message
- InvalidEventDataException is used when invalid event data is detected.
- The application can continue running after handling an exception.

### Custom Exception

**Definition :**

A custom exception is a **user-defined exception** created by the programmer to handle specific errors according to the requirements of the application.

**When to use :**

Custom exceptions are used when the standard Java exceptions do not clearly represent a specific error in the application.

**How to use :**

A custom exception can be created by extending the `Exception` class.

```java
public class InvalidEventDataException extends Exception {

    public InvalidEventDataException(String msg) {
        super(msg);
    }

}
```

**Where we used :**

We used the InvalidEventDataException in the EventManager class to handle invalid event data.
```java
public void insert(Event e) throws InvalidEventDataException {


    if (e == null)
        throw new InvalidEventDataException("Invalid event data");


    events.put(e.getEventId(), e);
}
```

Here, if the event data is null, the custom exception is explicitly thrown using the throw keyword.

The exception is handled in the MainApp class using try-catch:

```java
try {
    eventManager.insert(event);
} catch (InvalidEventDataException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Why we used :**

To handle invalid event data specifically.
To provide a meaningful error message.
