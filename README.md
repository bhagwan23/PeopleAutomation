Test Automation Framework
for
Desk Mobile Apps

Technology Stack-: 
 Java
o   Test scripts development language
 Eclipse
o   Script development IDE
 Selenium WebDriver
o   Selenium WebDriver is an open source test automation framework for use with any Web apps. It drives cross browser Web apps with cross platform support using the WebDriver protocol.
o   Most widely used for Test automation of Web apps
o   Strong community support with continues enhancements and bug fixes
o   Parallel testing support 
 TestNG
o   TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use, such as – 
o   Annotations.
o   Run your tests in arbitrarily big thread pools with various policies available (all methods in their own thread, one thread per test class, etc...).
o   Flexible test configuration.
o   Support for data-driven testing (with @DataProvider).
o   Support for parameters. 
o   Built in HTML report integration
 Maven 
o   build automation tool 
 Allure 
o   Integrated to create elaborate test execution reports that are clear to everyone in the team.

Framework Features-: 

 Page Objet Model
o   Implemented Page Object Model design pattern in test automation for enhancing test maintenance and reducing code duplication and modification. POM also helps in efficient way of managing page element locators
 Relative xpaths
o   Relative xpath makes sure that elements are verified in specific order which ensures the stability of overall structure of page
 Utility classes
o   Utility classes are separated with parameterized approach to make them reusable and modular
o   Screenshot on failure
 Configuration files
o   Configuration property files store all environment specific properties such as Mobile device details, Appium server configuration etc. User credentials are also stored in separate property file
 Parameterized Test suite 
o   Entry point for test execution
o   Parameterized collection of test cases to be executed
o   Grouping and annotation support to create multiple test suite xmls without changing test scripts

Project directory structure:

 src/main/java
o   Stores test framework source such as driverfactory, related utility helper classes etc.
 src/test/java
o   Pages – Stores page wise objects identifiers  and related operations
o   Tests – Stores actual tests to be executed 
 src/test/resources
o   Store test resources such as configuration and property files
 TestNG suite xmls
o   Android.xml – TestNG test suite configuration files containing test cases to run with specified parameters
 pom.xml 
o   Maven configuration file to run entire TestNG setup with parameterized input TestNG xml suites.
 target 
o   Stores all execution reports including default TestNG generated  HTML reports
 Allure-results
o   Enhanced HTML reports integrated to work with TestNG results

Please setup below on your local machine 


Java
maven
Chrome browser


Test Suite Execution Command syntax  -
call mvn test -DsuiteXmlFile=src/test/resources/testSuites/.xml -Dtest_env=https://auth-qa.deskera.xyz allure:report -DtestRunId=<1>

To run the Test suite locally please setup the environment.config as below 
```
##### This file contains config for Selenium framework
#execution on local or on container
execMode=local
#execMode=container

#RemoteWebDriverURL=http://127.0.0.1:4445/wd/hub
RemoteWebDriverURL=http://192.168.99.100:4444/wd/hub
```