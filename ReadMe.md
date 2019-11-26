**Setup**

 - Import project as maven project using any ide
 - Project can be run by Running main class TelecomApplication.java
 - Project will start on port 7071

**Steps to run**
 - mvn clean install
 - java -jar TelecomProject-0.0.1-SNAPSHOT.jar

 
**Project Url**

 - base url: localhost:7071/
  
 - create customer url: localhost:7071/customer/save
 - create sim card url: localhost:7071/simcard/save
 - Link sim to Customer: localhost:7071/customer/update/customerid
 - Retrieve Customer Sims:  localhost:7071/customer/customerid
 
 
API Document Request and Response is in below folder 

TelecomProject\API-DOCUMENT
 
**Database**

-  Database console: 
Application is connecting with my sql datbase and its url is 
DataBase Url = jdbc:mysql://localhost:3306/telecom_test?useSSL=false

**Points taken care**

- Code quality
- Naming convention
- Test coverage -Report can be found in this location = TelecomProject//target//site//jacoco//index.html
