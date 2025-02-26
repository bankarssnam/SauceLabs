
# Selenium Automation Project

Welcome to the Selenium Automation Demo Project! This project serves as hands-on demonstration of Selenium, an open-source automation testing framework widely used for web applications. Whether you're a beginner looking to explore the basics or an experienced tester aiming to enhance your Selenium skills, this project provides a practical guide to automation testing.
##### Application under test: https://www.saucedemo.com/ website.



## Index
 - [Project Demonstates](#project-demonstates)
 - [Tech Stack](#tech-stack) 
 - [Project Folder Structure](#project-folder-structure) 
 - [Framework](#framework)
 - [Project Setup](#project-setup)
 - [Run Locally](#run-locally)
 - [Execution Report](#execution-report)
 - [About Me](#about-me)


## Project Demonstates

- The execution of test cases on multiple browsers.
- Use of testng framework
- Achieve Page Object Model design pattern using pageFactory
- Maven project
- Sington design pattern implementation
- Reading data in multiple ways
    - via .properties file
    - from @DataProvider method
    - from <parameter> added in testng.xml
- Running test cases 
    - single test class
    - multiple test classes by added under testng.xml
    - using maven surefire plugin
- Integration of Listerners provided by testng
- Integration of Logger
- Execution report using Extent Report



## Tech Stack

**Language:** Java 17

**UI Automation library:** Selenium (4.11.0)

**Testing framework library:** testNg (7.8.0)

**Page object repository:** PageFactory

**Automation Framework:** Hybrid

**Project Building Tool:** Maven 3.8.0

**Reporting:** Extent Report (5.1.1)

**Test data/Configuration data:** .properties file

**Assertion framework:** hamcrest-all (1.3)

**Logger:** slf4j-api with slf4j-simple as binder

**Listerner:** testNg Listerners

## Project Folder Structure
 It has 3 source folders

    1. src/main/java - contains all code except test cases
    2. src/test/java - contains test case classes
    3. src/test/resource - contails configurations, test data related files

Here is a screenshot:


## Framework

Used testNg and POM results in hybrid Framework
It has following components:

    1. Test Base
    2. Page Object Repository
    3. Test Cases
    4. Test Data
    5. Configurations
    6. Utilities
    7. Report

Here is a framework flow diagram



## Project Setup
To run the test scenarios, need to have followings on your machine:
    
    1. Java 17
    2. Maven 3.8.5
    3. Any IDE (Eclipse/IntelliJ)
## Run Locally

- Clone the project

  Go to the folder location where you want to keep local copy of the project

```bash
  git clone https://github.com/swatinerkar/selenium-testng-demo-project
```

- Import the project as Maven project in any IDE (Eclipse/IntelliJ)

- #### To run complete suite via testng.xml
  - right click on testng.xml
  - Run as -> TestNG suite

 


- #### To run complete suite via maven
  - Right click on POM.xml file
  - Run as -> Maven test



- #### To run via Run configuration
  - Go to Run on Toolbar
  - Run configuration
  - Select workplace, and add goals as 'test'
  - Click Apply and Run

 






## Execution Report
- Once the Execution is done, the report is available under Reports folder
- If any test case fails, it will take the screen shot and attach it to the execution report.

  #### Report folder
  


  #### Execution Report



  #### Failure Screenshot



## 🚀 About Me

I'm a Software Automation Tester, having 9+ years of experience.

Please have a look on my Portfolio: [(https://github.com/bankarssnam/SauceLabs))

My LinkedIn Profile: [https://www.linkedin.com/in/suraj-bankar-0a23766b]

