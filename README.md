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

## How are our requests handled?
- DispatcherServlet - Front Controller pattern
- Mapping servlets: dispatcherServlet urls=[/]


<br>
<hr>
<br>


## How does a bean gets converted to JSON?
- @ResponseBody + JacksonHttpMessageConverters