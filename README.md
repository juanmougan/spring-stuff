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

#### Usage

##### Valid POST

    curl --header "Content-Type: application/json"   --request POST   --data '{"name":"Juan","age":33,"email":"juan@somemail.com"}'   http://localhost:8080/people | jq .

##### Missing name

    curl --header "Content-Type: application/json"   --request POST   --data '{"age":33,"email":"juan@somemail.com"}'   http://localhost:8080/people | jq .

##### Missing age

    curl --header "Content-Type: application/json"   --request POST   --data '{"name":"Juan","email":"juan@somemail.com"}'   http://localhost:8080/people | jq .

##### Missing name and age

    curl --header "Content-Type: application/json"   --request POST   --data '{"email":"juan@somemail.com"}'   http://localhost:8080/people | jq .

##### Invalid email

    curl --header "Content-Type: application/json"   --request POST   --data '{"name":"Juan","age":33,"email":"juan@invalidmail"}'   http://localhost:8080/people | jq .


#### Sources

- https://spring.io/guides/gs/validating-form-input/

- https://www.baeldung.com/spring-boot-bean-validation

- https://reflectoring.io/bean-validation-with-spring-boot/

- https://www.baeldung.com/spring-mvc-custom-validator