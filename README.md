# REST API Test with Rest Assured and TestNG

The demo has combined and utilized Rest Assured and TestNG frameworks to access GitHub public APIs, and implemented End2End test sequence which include GET, POST, PATCH, PUT, DELETE operations. 

At same time, the test scripts have been configured into 2 groups: Full Test and Regression Test, which meet different testing requirements. And there is also a Google service folder which shows how to extend new test suites in the future.

Steps to run this test framework:
1. **Install Maven and configure**.

   sudo apt-get install maven

2. **Install Git**

   sudo apt-get install git-core

3. **Configure your own git settings**

   git config --global user.name "testuser"
   
   git config --global user.email "testuser@example.com"

4. **Clone this project**

https://github.com/narasimhavuppala/bdd-rest-assured-demos.git

5. **Enter into root folder "RestAssuredDemo" (with pom.xml and testng.xml in it) then run following command**:

   **For Full TestSuite**:
   mvn clean compile test -PFullTest

   **Regression TestSuite**:
   mvn clean compile test -PRegressionTest