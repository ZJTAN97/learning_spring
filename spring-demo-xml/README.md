## 1. Spring Container

Primary functions
- Create and manage objects (Inversion of Control)
- Inject object's depedencies (Dependency Injection)

<br>
<hr>

## 2. Spring Development Process
1. Configure your spring beans
2. Create a Spring Container (known as ApplicationContext)
3. Retrieve Beans from Spring Container

<br>
<hr>

## 3. Inversion of Control
- Outsource to an object factory.
- The approach of outsourcing the construction and management of objects.
- Objects do not create other objects on which they rely to do their work.
- Instead, they get the objects that they need from an outside source (xml, configuration file)

<br>
<hr>

## 4. What is a Spring Bean?
- Simply a java object
- When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans"

<br>
<hr>


## 5. Dependency Injection
- Generally means passing a dependent object as a parameter to a method.
- Rather than having the method create the dependent object.

Two kinds of injection
1. Setter Injection
- Inject dependencies by calling setter method(s) on your class.

2. Constructor Injection

<br>
<hr>


## 6. Spring & Dependency Injection & Inversion of Control

https://stackoverflow.com/questions/9403155/what-is-dependency-injection-and-inversion-of-control-in-spring-framework

- IoC and DI are used interchangeably. IoC is achieved through DI. DI is the process of providing the dependencies and IoC is the end result of DI
- By DI, the responsibility of creating objects is shifted from our application code to the Spring Container; this phenomenon is called IOC.
- Dependency injection can be done by setter injection or constructor injection.

<br>
<hr>


## 7. Bean Scopes
- Scope refers to the lifecycle of a bean
- How long does the bean live?
- How many instances are created?
- How is the bean shared?

<br>
<hr>


## 8. What is a singleton?
- Spring container creates only one instance of the bean by default
- Cached in memory
- All requests for the bean will return a SHARED reference to the SAME bean

<br>
<hr>

## 9. Types of Spring Bean Scopes
1. singleton -- create a single shared instance of the bean. Default scope.
2. prototype -- creates a new bean instance for each container request. (new object for each request)
3. request -- scoped to an HTTP web request. Only used for web apps.
4. session -- scoped to an HTTP web session. Only used for web apps.
5. global-session -- scoped to a global HTTP web session. Only used for web apps.

<br>
<hr>


## 10. Bean Lifecycle
1. Container started
2. Bean Instantiated
3. Dependencies Injected
4. Internal Spring Processing
5. Custom Init Method
6. Bean is ready for user
7. Container is shutdown
8. your custom destroy method.

<br>
<hr>


## 11. Bean Lifecycle Methods/Hooks
- You can add custom code during bean initialization
	- Calling custom business logic methods
	- setting up handles to resources (db, sockets, file etc)

- You can add custom code during bean destruction
	- Calling custom business logic method
	- Clean up handles to resouces(db, sockets, file etc)










