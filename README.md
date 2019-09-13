# test-automation project
## Description
This is a sample project to present test-automation approach. Project contains UI tests with Selenium WebDriver and API integration tests with Spring Clound Open Feign. 

Test scenarios are written in Gherkin. 

## Prerequisites
For development end execution you need:
* [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Google Chrome browser](https://www.google.com/intl/pl/chrome/)

## Selenium WebDriver
In this project WebDriver is a Singleton Bean created once for the duration of the JVM. 
This makes test execution faster. To ensure we are starting tests with clean Browser we delete Browser cookies before each test.

## Bank service
Bank service implementation is based on Git Hub project - https://github.com/landrzejewski/spring-training.

Swagger documentation link: http://localhost:8080/swagger-ui.html

## Run the Bank application
```bash
mvn clean install
```
## Run the tests

```bash
mvn clean test
```

