
## Components

### Spring Boot Reactive Web

This is a Spring Boot 2.0 application that retrieves data using **Spring Reactive Web (WebFlux)**,
instead of using the standard synchronous MVC framework. It connects to a MongoDB database in a reactive
way too.


### Angular Reactive

This simple Angular application consumes the controller on the backend side using a reactive approach,
 Server-Sent Events, so data is loaded on screen as soon as it's available.


### Sample Curl command
```
curl "http://localhost:8080/ports"

curl -H "Accept: text/event-stream" "http://localhost:8081/ports"

```
