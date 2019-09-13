# test-automation project

## Prerequisites
For development end execution you need:
* [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Google Chrome browser](https://www.google.com/intl/pl/chrome/)

## WebDriver lifecycle
WebDriver in Selenium Tests is a Singleton Bean created once for the duration of the JVM. 
This makes test execution faster. To ensure we are starting tests with clean Browser we delete Browser cookies before each test.


## Run the tests

```bash
mvn clean test
```

