# opencart-selenium
Selenium Tests for OpenCart using Spring Framework

## Objective
To be able to run the Selenium Test Cases on a daily basis so as to ensure that your online [OpenCart Store](http://www.opencart.com/) is functioning normally.
[Maven](https://maven.apache.org/) will help manage the project's test and send the failed results via email to alert the store owners.

## Setting up
The steps are:
 1. [Download Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and install Java.
 2. Ensure that JAVA_HOME environment variable is set and points to your JDK installation.
 3. [Download Maven](https://maven.apache.org/download.cgi), extracting the archive and adding the bin folder to the PATH.

## Configuration 
To customize the codes to suit your needs:
 
 1. Clone a copy of this project
 2. Make the appropriate changes to the properties file
 3. Modify the test cases according to your online store
 
## Running the Tests
At the base of the project, simply type 
```
mvn test
``` 
