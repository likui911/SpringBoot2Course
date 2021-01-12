## Annotations

### GreetingController.java 

```java
@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World")String name){
        return  new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}

```

#### @RestController

[`@RestController`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html) annotation is shorthand for including both `@Controller` and `@ResponseBody`.

The `Greeting` object must be converted to JSON. Spring’s [`MappingJackson2HttpMessageConverter`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/json/MappingJackson2HttpMessageConverter.html) is automatically chosen to convert the `Greeting` instance to JSON.

#### @GetMapping

The `@GetMapping` annotation ensures that HTTP GET requests to `/greeting` are mapped to the `greeting()` method.

#### @RequestParam

`@RequestParam` binds the value of the query string parameter `name` into the `name` parameter of the `greeting()` method. If the `name` parameter is absent in the request, the `defaultValue` of `World` is used.

### RestServiceApplication.java

```java
@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
```

#### @SpringBootApplication

`@SpringBootApplication` is a convenience annotation that adds all of the following:

1. `@Configuration`: Tags the class as a source of bean definitions for the application context.
2. `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. 
3. `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the `com/example` package, letting it find the controllers.



