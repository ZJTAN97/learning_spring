# learning_spring

This repository contains my learning process towards the Spring Framework.

This readme serves as a note taking of the things I have learnt.

<br>
<hr>
<br>

## What is a Bean?

- In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are the beans
- Spring handles the lifecycle of the Bean
- A bean is an object that is instantiated, assembled and otherwise managed by Spring IoC Contaner

<br>
<hr>
<br>

## Spring ApplicationContext

- Is where Spring holds instances of objects that it has identified to be managed and distributed automatically.
- Primary job is to manage the spring beans
- The interfaces `BeanFactory` and `ApplicationContext` represents the Spring IoC container.

<br>
<hr>
<br>

## @Component
- An annotation that allows Spring to automatically detect our custom beans
- Spring will Scan our application for classes annotated with @Component, insantiate them and inject any specified dependencies into them
- Specialised stereotype annotations are like @RestController, @Service etc.
- Class-level annotation


<br>
<hr>
<br>


## How are our requests handled?

- DispatcherServlet - Front Controller pattern
- Mapping servlets: dispatcherServlet urls=[/]

<br>
<hr>
<br>

## How does a bean gets converted to JSON?

- @ResponseBody + JacksonHttpMessageConverters

<br>
<hr>
<br>

## JPA (Java Persistence API)

- Used to examine, control and persist data between Java objects and relational databases.
- Considered as a link between a object-oriented model and a relational database system.

<br>

Key Features of JPA

- JPA is only a specification, not an implementation.
- A set of rules and guidelines to set interfaces for implementing object-relational mapping.
- Needs few classes and interfaces
- Supports simple, cleaner, and assimilated object-relational mapping
- supports polymorphism and inheritance

<br>
<hr>
<br>

## Hibernate (an ORM tool essentially)

- Main feature of hibernate is to map Java classes to database tables
- Hibernate is an IMPLEMENTATION of JPA guidelines.
- Helps in mapping Java data types to SQL data types

<br>
<hr>
<br>

## Difference between JPA and JDBC

<b>JDBC</b>

- an API for the Java programming language that defines how a client can access a database
- Programmers can use these standard interfaces and classes to write applications that connect with dbs, send SQL queries and process the result.

Pros

- Simple SQL processing
- Good performance with large data
- useful in applications where full control of the execution is required.

Cons

- Large programming overhead
- No encapsulaion
- Hard to implement MVC concept
- Queries are DBMS specifics

<br>

<b>JPA</b>

- A Java standard for binding Java objects to records in a relational database.
- One of the possible soluions for ORM, where developers can perform CRUD operations on Relational databases using Java Objects (POJO).
- Example of implementations of JPA are Hibernate, MyBatis, OpenJPA etc.

<img src="https://miro.medium.com/max/1100/1*QI-lYwgqNtFEIfqeI2TteA.jpeg">

Pros

- Provides encapsulation
- Inegration with java beans validation for easier validations
- provides database independence

Cons

- Not good for batch transactions, consumes too much memory.
- Not thread-safe

<br>
<hr>
<br>
