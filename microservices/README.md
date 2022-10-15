## Introduction to Microservices with Spring

<hr>
<br>

## Spring Cloud Config Server

- Provides service and client-side support for externalized configuration in a
  distributed system
- With config server, you have a central place to manage external properties for
  applications across all environments.

<br>

Server Features

- HTTP, resource-based API for external configuration
- Encrypt and decrypt property values
- Embeddable easily in Spring Boot Application using @EnableConfigServer

<br>

Config Client Features (For microservices)

- Bind to the Config Server and initialize Spring Environment with remote
  property sources
- Encrypt and decrypt property values

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

- For building an API gateway and is intended to sit between a requester and a
  resource that is being requested.

Client request --> Gateway Handler Mapping using Routing Configs -->
Predicates (To check if the requests fulfill a set of given conditions) -->
Prefilters --> Microservices / Eureka Server

<br>
<hr>
<br>

## Eureka Server For naming (Service Discovery)

- Service discover and registration deals with the problems about how
  microservices talk to each other, i.e. perform API calls
- A central server that maintain a global view of addresses
- Microservices connect to this central server to register their address when
  they start & ready
- Mainly service discovery consists of a key-value store (Service Registry)
  and an API to read from and write to this store. New instances of applications
  are saved to this service registry and deleted when the service is down or not
  healthy.

<br>

Advantages of Service Discovery approach

- No limitations on availability
- Dynamically managed IPs, configurations & Load balanced
- Self-preservation mode (to expand on), essentially is used to avoid traps in
  network and help us to handle false-positive alarms.

<br>
<hr>
<br>

## Spring Cloud Support for Service Discovery & Registration

- Spring Cloud Netflix's Eureka Service which act as a service discovery agent (
  other examples include Apache Zookeper, Consul etc.)
- Spring Cloud Load Balancer library for client-side load balancing
- Netflix Feign client to look up for a service between microservices

<br>
<hr>
<br>

## Resiliency in Microservices

- Resilience4j offers the following patterns for increasing fault tolerance due
  to network problems or failures
- Ciruit breaker - used to stop making requests when a service invoked is
  failing
- Fallback - Alternative paths to failing requests
- Retry - Used to make retries when a service has temporary failed
- Rate limit - Limits the number of calls that a service receives in a time
- Bulkhead - Limits the number of outgoing concurrent requests to a service to
  avoid overloading.

<br>

Circuit Breaker Pattern

- If calls takes too long, circuit breaker will intercede and kill the call.
- Also enables an application to detect whether the fault has been resolved, if
  problem appears to be fixed, the application can try to inoke the operation.
- Advantages for this pattern includes, failing fast, fail gracefully and
  recover seamlessly.

1. CLOSED - initially the circuit breaker starts with Closed status and accepts
   client requests
2. OPEN - if circuit breaker sees a threshold requests are failing, then it will
   OPEN the circuit which will make requests fail fast
3. HALF_OPEN - periodically circuit breaker checks if the issue is resolved by
   allowing few requests. Based on the results it will either go to CLOSED or
   OPEN.

<br>

Retry Pattern

- configure the following values, `maxAttempts`, `waitDuration`,
  `retryExceptions`, `ignoreExceptions`
- can also configure a fallback mechanism if the service call fails even after
  multiple retry attempts.

<br>

Rate Limiter Pattern

- can configure the following values, `timeoutDuration`, `limitForPeriod`,
  `limitRefreshPeriod`
- Can also define fallback mechanism
- Useful against DDOS attacks, protects against cascading failure.

<br>
<hr>
<br>

## Distributed Tracing & Log Aggregation

- Using Spring Cloud Sleuth and Zipkin

<br>

Spring Cloud Sleuth

- provides Spring Boot autoconfiguration for distributed tracing
- adds trace and span ids to all the logs
- Does this by adding the filters and interacting with other Spring components
  to let the correlation IDs being generated pass through to all the system
  calls.

```
[<App Name>,<Trace ID>,<Span ID>]

Application Name: application name where the log entry is being made. Gets 
the name from spring.application.name property

Trace ID: equivalent term for correlation Id, unique number that represents 
an entire transaction

Span ID: Unique ID that represents part of the overall transaction. Each 
service participating within the transaction will have its own span ID. 
Particularly relevant when you integrate Zipkin to visualize your transactions

```

<br>

Zipkin

- Open-source data-visualization tool that can helps aggregating all the logs
  and gather timing data needed to troubleshoot latency problems in
  microservices architecture
