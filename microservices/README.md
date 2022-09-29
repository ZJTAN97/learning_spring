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

## Eureka Server For naming (Service Discovery)

- Service discover and registration deals with the problems about how 
  microservices talk to each other, i.e. perform API calls
- A central server that maintain a global view of addresses
- Microservices connect to this central server to register their address 
  when they start & ready
- Mainly service discovery consists of a key-value store (Service Registry) 
  and an API to read from and write to this store. New instances of 
  applications are saved to this service registry and deleted when the 
  service is down or not healthy.

<br>

Advantages of Service Discovery approach
- No limitations on availability
- Dynamically managed IPs, configurations & Load balanced

<br>
<hr>
<br>

## Spring Cloud Support for Service Discovery & Registration
- Spring Cloud Netflix's Eureka Service which act as a service discovery 
  agent (other examples include Apache Zookeper, Consul etc.)
- Spring Cloud Load Balancer library for client-side load balancing
- Netflix Feign client to look up for a service between microservices


<br>
<hr>
<br>