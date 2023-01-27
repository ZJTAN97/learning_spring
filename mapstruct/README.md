# Mapstruct Documentation key points

- MapStruct will only create a new mapping method if and only if the source and target property are properties of a Bean
  and they themselves are Beans or simple properties. i.e. they are not Collection or Map type properties.

### Adding Custom Methods to mappers

```
@Mapper
public interface CarMapper {

    @Mapping(...)
    ...
    CarDto carToCarDto(Car car);

    default PersonDto personToPersonDto(Person person) {
        //hand-written mapping logic
    }
}
```

<br>

### Mapping methods with several source parameters

```
@Mapper
public interface AddressMapper {

    @Mapping(target = "description", source = "person.description")
    @Mapping(target = "houseNumber", source = "address.houseNo")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Address address);
}
```

- In case several source objects define a property with the same name, the source parameter from which to retrieve the
  property must be specified using the @Mapping annotation as shown for the description property in the example. An
  error will be raised when such an ambiguity is not resolved.

<br>

### Mapping nested bean properties to current target

If you don’t want explicitly name all properties from nested source bean, you can use . as target. This will tell
MapStruct to map every property from source bean to target object. The following shows an example:

```

 @Mapper
 public interface CustomerMapper {

     @Mapping( target = "name", source = "record.name" )
     @Mapping( target = ".", source = "record" )
     @Mapping( target = ".", source = "account" )
     Customer customerDtoToCustomer(CustomerDto customerDto);
 }

```

<br>

### Updating existing bean instances

```

@Mapper
public interface CarMapper {

    void updateCarFromDto(CarDto carDto, @MappingTarget Car car);
}

```