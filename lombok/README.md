<h1> :books: Spring Core Notes :books: </h1>

<br>

# :snowflake: @Getter, @Setter :snowflake:

- Generates Getter and Setter methods for your class
- public is the default access level for both unless you change it
- in the below example since data is specified to be lazily loaded, will 
  only be assigned a value when the getter method is invoked.

```
@Getter
@Setter
public class Actor {
  private int id;
  
  @Getter(AccessLevel.Protected)
  private String name;
  
  @Getter(AccessLevel.PACKAGE)
  private String topRole;
  
  @Getter(lazy=true)
  private final List<String> data = initData();
  
}

```

<br>

# :snowflake: @ToString :snowflake:

- Generates the ToString method

```

@ToString(includeFieldNames = false)
public class Actor {
  private int id;
  
  @ToString.Include
  private String name;
}

// will only include name in the string
```

<br>

# :snowflake: @EqualsAndHashCode :snowflake:

- Generates the equal and hashcode method

```

@EqualsAndHashCode(callSuper = true)
public class Actor extends Person {
  @EqualsAndHashCode.Exclude
  prviate String topRole;
}

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
  private int id;
  
  @EqualsAndHashCode.Include
  private String name;
  
}

new Actor(1, "Maisie", "Arya").equals(new Actor(2, "Maisie", "Vixen")); // true

```

<br>

# :snowflake: Constructor Annotations :snowflake:

- @RequiredArgsConstructor --> consider only final and @NonNull variables/attributes
- @NoArgsConstructor
- @AllArgsConstructor

<br>

# :snowflake: @Data :snowflake:

- A combination of @Getter, @Setter, @ToString, @EqualsAndHashCode, 
  @RequiredArgsConstructor

<br>

# :snowflake: Builder :snowflake:

```
@Builder(builderClassName = "ActorBuilder",
         builderMethodName = "execute",
         builderMethodName = "anActor",
         access = AccessLevel.PUBLIC,
         setterPrefix = "set")
public class Actor {
  private int id;
  private String name;
  @Builder.Default
  private String topRole;
}

Actor actor = Actor.anActor()
                  .setName("Maisie")
                  .setId(1)
                  .execute();

```

- @SuperBuilder for super classes