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