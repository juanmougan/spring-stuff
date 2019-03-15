# Spring stuff

As the name implies, this is a project to learn some Sprig stuff :)

## Modules covered

### Validations

- Using `javax` validations for simple things, like range

- Before adding `handleValidationExceptions` method, error body is really weird

- If you don't add your own messages, the default ones might be strange (e.g. in Spanish)

```
{
	"name": "a",
	"age": 233,
	"email": "dsadada"
}
```

would return

```
{
    "name": "el tamaño tiene que estar entre 2 y 30",
    "age": "tiene que ser menor o igual que 200",
    "email": "Invalid email"
}

```

Sources

- https://spring.io/guides/gs/validating-form-input/

- https://www.baeldung.com/spring-boot-bean-validation

- https://reflectoring.io/bean-validation-with-spring-boot/

- https://www.baeldung.com/spring-mvc-custom-validator