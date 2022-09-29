## Introduction to Microservices with Spring

<hr>
<br>

## Spring Cloud Config Server

-   Provides service and client-side suppport for externalized configuration in a distributed system
-   With config server, you have a central place to manage external properties for applications across all environments.

<br>

Server Features

-   HTTP, resource-based API for external configuration
-   Encrypt and decrypt property values
-   Embeddable easily in Spring Boot Application using @EnableConfigServer

<br>

Config Client Features (For microservices)

-   Bind to the Config Server and initialize Spring Environment with remote property sources
-   Encrypt and decrypt property values

```
# application.properties for references from resources class path
spring.application.name=config-server
spring.profiles.active=native
spring.cloud.config.server.native.locations=classpath:/config
server.port=8071

# application.properties for references from a git repository
spring.application.name=config-server
spring.profiles.active=git
spring.cloud.config.server.git.uri=https://github/<>/<>.git
spring.cloud.config.server.git.clone-on-start=true
spring.cloud.config.server.git.default-label=main
server.port=8071



```


<br>
<hr>
<br>

## Spring Cloud Gateway

<br>
<hr>
<br>

## Eureka Server For naming

- Service discover and registration deals with the problems about how 
  microservices talk to each other, i.e. perform API calls
- A central server that maintain a global view of addresses
- Microservices connect to this central server to register their address 
  when they start & ready

<br>
<hr>
<br>
