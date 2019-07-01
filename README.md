## Components

Project forked from https://github.com/mechero/full-reactive-stack

### Spring Boot blocking 

This is a Spring Boot 2.0 application that retrieves data using using the traditional MVC framework.

### Spring Boot Reactive 

This is a Spring Boot 2.0 application written in **Kotlin** that retrieves data using **Spring Reactive Web (WebFlux)**,
instead of using the standard synchronous MVC framework. It connects to a MongoDB database in a reactive
way too.


### Angular Reactive

This simple Angular application consumes the controller on the backend side using a reactive approach,
 Server-Sent Events, so data is loaded on screen as soon as it's available.


### Run with docker compose

* Go to spring-boot-reactive directory, run `./mvnw clean package`
* Go to spring-boot-blocking directory, run `./mvnw clean package`
* Go to angular-reactive directory, run `npm install` and then `npm run ng build`
* Go to docker directory, run `docker-compose up -d --build`


### Sample Curl command
```
curl "http://localhost:8080/ports"

curl -H "Accept: text/event-stream" "http://localhost:8081/ports"

```

