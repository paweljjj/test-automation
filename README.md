# test-automation project

## Table of contents
* [General info](#general-info)
* [Prerequisites](#prerequisites)
* [Bank application](#bank-application)
* [Selenium WebDriver lifecycle](#selenium-webdriver-lifecycle)
* [Running the tests](#running-the-tests)
* [Built With](#built-with)

## General info
This is a sample project to present test-automation approach. Project contains UI tests with Selenium WebDriver and API integration tests with Spring Clound Open Feign. 

Test scenarios are written in Gherkin. 

## Prerequisites
For development end execution you need:
* [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Google Chrome browser](https://www.google.com/intl/pl/chrome/)

## Bank application
For testing purposes Bank service implementation was implemented. This service is based on Git Hub project - https://github.com/landrzejewski/spring-training.

To run the Bank Application:
```bash
mvn clean install
```
Swagger documentation is available. To check it run the application locally and open: http://localhost:8080/swagger-ui.html

## Selenium WebDriver lifecycle
In this project WebDriver is a Singleton Bean created once for the duration of the JVM. 
This makes test execution faster. To ensure we are starting tests with clean Browser we delete Browser cookies before each test.

## Running the tests

To run all the tests type 
```bash
mvn clean test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Lombok](https://projectlombok.org/) - Reduces boiler plate code in the Java
* [Spring Framework](https://spring.io/) - application framework and inversion of control container for the Java
* [H2 Database](https://www.h2database.com) - relational database
* [Swagger](https://swagger.io) - design, build, document, and consume RESTful Web services
* [Selenium WebDriver](https://www.seleniumhq.org/projects/webdriver/) - framework for testing web applications
* [Webdrivermanager](https://github.com/bonigarcia/webdrivermanager) - webdriver binary managment
* [Cucumber](https://cucumber.io/) - supports behavior-driven development (BDD) testsing





