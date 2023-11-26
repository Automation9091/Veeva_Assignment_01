# Veeva Automation Assignment

## Framework Specification:
#### This automation framework in built using BDD approach on top of page object model design pattern. It can handle multiple applications automation and can be easily scaled to handle mobile and API automation also.  

## Framework Components:
#### 1- Selenium 4.15
#### 2- Cucumber 7.x
#### 3- TestNG 7.x
#### 4- Maven
#### 5- Log4J
#### 6- Extent Reporting Adaptor

## Page Object Model
#### Under this, each page of respective application is maintained as a class file which stores the locators value using Page factory mechanism. Currently, it has been tuned to handle three applications:
#### 1. Core Product
#### 2. Derived Product1
#### 3. Derived Product2

#### All these page classes extend to browser class where webdriver is instantiated. 

## Selenium
#### The latest version of selenium has been used in this which enabled it to download browser binaries automatically. Hence, no need to maintain browser executables. 

## Runner
#### The runner file uses cucumber options from TestNG which enables it to perform parallel execution of tests. This runner file later bind to TestNG.xml file where cucumber tags are being passed. This Testng.xml file can be executed using below maven command: 
    mvn clean test -Dsurefire.suiteXmlFiles=testNg.xml 

## Common Library
#### There are two types of common libraries used here. first one to take care of all reusable methods and can be located at src/main/java/commonLibrary and, the second one is around common steps which is being used during scenario creation and used locator value as a string as parameters.

## Reporting
#### Extent Reporting adaptor has been used for the reporting of framework. Spark version of extent report has been configured here using extent.config file located under src/test/resources. There are many other feature that can be enabled for this report, like screenshots, exceution metrics etc. using config file.

## Features
#### BDD approach widens the scenario creation by BA, PO, PM, Dev, QAs. As it has followed the Gherkin language, it becomes easier to design the steps of scenarios.
#### A simple crisp way of creating a feature file:
    Feature: Contains an overview of feature that is being automated
    Scenario: Contains specifically which scenario is being automated.
        Given Pre-requisite
        When App is up and running
        And Continue the steps
        Then Add validation

## Logging
#### Log4J has been used to create logs at every step. A static variable to created as logger and has been used where ever needed.

## Cross Browser
#### The framework has been added with capability to handle Chrome, Edge and Firefox browser for now.

## Test Data
#### Test Data has been used in the form of yml file. All static data is being passed through one file and other data using another application level yml file
