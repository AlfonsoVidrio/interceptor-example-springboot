# interceptor-example-springboot

This is an example project to explore and understand how interceptors work in Spring Boot. The project demonstrates the usage of custom interceptors and how they can be configured to be applied to specific controllers or excluded from others. The goal is to understand the behavior and execution of interceptors in a Spring Boot application. The application includes several endpoints: `/app/foo`, `/app/bar`, and `/app/baz`, to test the behavior of the interceptor.

## Usage

- The application starts a web server on the default port (8080).
- You can access the following endpoints:

  ```plaintext
  http://localhost:8080/app/foo
  http://localhost:8080/app/bar
  http://localhost:8080/app/baz
  ```

## Configuration

In the `AppConfig` class, the interceptor is registered and configured using the `addInterceptors` method. The interceptor is applied to the `/foo` and `/bar` endpoints and excluded from the `/baz` endpoint. This is done using the `excludePathPatterns` method, which allows fine-grained control over which requests trigger the interceptor.

```java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/baz");
}
```

## What happens when `preHandle()` returns `false`?

If the `preHandle()` method of the interceptor returns `false`, the request processing will stop, and the handler method (such as the controller method) will not be executed. This means the request will not reach the endpoint's logic, and the response will not be generated as usual.

In this example, the interceptor is not configured to return `false` under normal circumstances, but it is possible to do so if needed (for instance, for authorization checks or to prevent certain requests from reaching the controller).
