# Adobe & AEM Engineering Test
This is a web service that takes in a number and outputs a Roman numeral:

You can run unit tests by running the following command at the command prompt:

    ./gradlew clean test

You can run the full build (that runs all tests) by running the following command at the command prompt:

    ./gradlew clean build

You can can run the Spring Boot web application by the following command at the command prompt:

    ./gradlew bootRun
    
When the application is running, you can access it by going to the url address:
```{integer} must be any integer value in the range 1-3999```

    http://localhost:8080
    http://localhost:8080/romannumeral?query={integer}
 
Dependencies:
- Java 8
- Java Validation API
- Lombok
- JUnit4
