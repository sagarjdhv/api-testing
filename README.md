# API Testing Example Project #
Version: `1.0.0`

A simple project to demonstrate automated Web Service API testing using REST-Assured framework.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

`JDK 1.8`.  Java should either be accessible from your path, or the JAVA_HOME environment variable should locate your Java installation.

Dependencies are downloaded from the Maven Central Repository. If you are behind a web proxy, please refer to [Gradle web proxy configuration](https://docs.gradle.org/current/userguide/build_environment.html#sec:accessing_the_web_via_a_proxy) for how to configure Gradle to use the proxy.  

### Installing

Clone the project to your hard drive, or download the project as a ZIP file and extract to your hard drive.

If you'd like to run the tests from within an IDE, import the project into your favourite IDE as a Gradle project and execute the Gradle test target.


## Running the tests

In a Windows command prompt or unix shell, change directory to the project installation folder.

Ensure that Java is available. To set the JAVA_HOME environment variable for Windows, execute a command similar to the following at the command prompt before proceeding:
```
set JAVA_HOME=C:\path\to\your\java\jdk1.8.0_???
```

To execute the tests on Windows:
```
gradlew clean test
```
To execute the tests on unix:
```
./gradlew clean test
```

The first time this is run it will take a while for the dependencies to download.

The tests will log to the console, and a test report will be generated at: build/reports/tests/test/index.html

## Built With

* [Gradle](https://gradle.org/) - Dependency Management
* [Java](https://www.java.com) - Java language
* [JUnit4](https://junit.org/junit4/) - JUnit Test framework
* [REST-Assured](http://rest-assured.io/) - Framework for testing and validating REST services


## Authors

* **Sagar Jadhav**

