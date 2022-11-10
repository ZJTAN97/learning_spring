# Notes about Spring Security

<br>

# Key Security Components

The main components of Spring Security are

![plot](../images/spring_security_flow.png)

Authentication Filter (the only class)

- The filter that intercepts requests and attempts to authenticate it. In
  Spring Security, it converts the request to an Authentication Object and
  delegrates the authentication to `AuthenticationManager`

Authentication Manager

- Main Strategy Interface for authentication. Uses the lone method
  `authenticate()` to authenticate the reqeust
- Returns an Authenticaion Object on successful authentication
- Throws `AuthenticationException` in case of authentication failure.

Authentication Provider (can define our own authentication logic here)

- Any class implementing the AuthenticationProvider interface must implement
  two methods, `authenticate()` and `supports()`
- `support()` used to check if particular authentication type is supported
  by our Authentication Provider implementation class. Returns boolean.
- `authenticate()` method is where authentication occurs, here is where the
  class use the `loadUserByUsername()` method of the `UserDetailsService`
  implementation.

User Details Service

- Core interfaces of Spring Security
- The authentication of any request mostly depends on the implementation of
  the UserDetailsService interface.

Password Encoder

- Spring Security 5 mandated the use of PasswordEncoder to store passwords.
  Encode the user's password using their many implementations.

Spring Security Context

- This is where the details of currently authenticated user are stored on
  successful authentication.
- Authentication object is available throughout the application for the session.

On Success

- AuthenticationSuccessHandler
- Security Context

On Failure

- AuthenticationFailureHandler

<br>

![plot](../images/security_flow.png)

<br>
<br>

# @EnableWebSecurity

- To enable Spring Security's web security support and provide Spring MVC
  integration
- Exposes two beans to set some specifics for the web security configuration
    1. `SecurityFilterChain`
    2. `UserDetailsService`

<br>

# Filters in Spring Web Applications

Common use cases of filters are

- Logging requests and response
- Logging request processing time
- Formatting of request body or header
- Verifying authentication tokens
- Compressing response
- Performing Image Conversions

<br>

The `Filter` Interface contains the three methods

`init()`

- Web container call this method to indicate a filter is being placed into
  service.
- Web container cannot place the filter into service if the method throws a
  `ServletException` or does not return within a specified time period by
  the web container

<br>

`doFilter`

- invokes this method everytime when the client sends a request or
  application sends back a response

<br>

`destroy()`

- Web container call this method to indicate to a filter that it is being
  taken out of service

<br>
<br>

# `GrantedAuthority` interface

- Interface to get an authority to authorize/control an access.
- Think of it as a "permission" which are expressed as strings

<br>
<br>

# `antMatchers` vs `mvcMatchers`

- antMatcher("/users/**") matches any path starting with /users
- antMatchers("/users") matches only the exact /users URL
- mvcMatchers("/users") matches /users, /users/, /users.html
- mvcMatchers is more new and more secure (needs more research why)


<br>
<br>

# OAuth

- Allows one application to get access to another application user's data 
  without user sharing its userId and password
- Federated Authentication, Delegated Authorisation

![plot](../images/oauth.png)

<br>

Overview of OAuth Key Components

- Client
- Authorization Server
- Resource Server

![plot](../images/oauth_flow.png)


<br>

### Grant Types
- Authorization Code
- Password
- Client Credentials 
- Refresh Token (Has to be used with the 3 above)

<br>
<br>



# Additional Notes
- To implement custom authentication logic, the parameters we pass to 
  authenticate the method of AuthenticationManager is 
  `UsernamePasswordAuthenticationToken`























