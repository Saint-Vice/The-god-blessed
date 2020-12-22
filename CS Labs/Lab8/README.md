# Lab 8
> For this lab we had to write a program which will allow the user to register and  
> the user should receive a confirmation code/link to their email in order to validate  
> and complete the registration

## Technologies
Java 11
Maven  
Spring Web  
Spring Data JPA  
Spring Security  
Thymeleaf  
Java Mail Sender  
Working IDE: InteliJ IDEA  
DB: MySQL  

## How to use
1. Import Project with pom.xml  
2. Create a schema in your MySQL with desired name, don't forget to change the  
application.properties with your data.  
3. Run Lab8Application(main) class  

## Explanation:  
application.properties:  
MySQL is used as a data source in this application for storing the data of the users.  
spring.datasource.url: It contains the URL to connect with the database or schema in the MySQL Workbench.  
spring.datasource.username: Username to access the database.  
spring.datasource.password: Password of the database.  
spring.datasource.driver-class-name: Driver name.  

I used Hibernate as JPA, to perform all SQL or database operation, so all the important properties are  
configured in this section.  
spring.jpa.generate-ddl = true, true - Hibernate will automatically create a table in the database  
based on the Entity class.  
spring.jpa.show-sql = true, set to true - You can able to see all the SQL Queries performed by the Hibernate.  

Also in the application.properties file we need to provide the email address. So on behalf of that email  
address, the Spring Boot Application will send the confirmation or activation link to the registered  
user’s email. To achieve this I am using Gmail.  

In the next step I created a Entity class that represents the table mapped with the database. So we need to  
create two entity classes, one is for storing the user detail and another for the Confirmation link.  
_UserEntity_ mapped to table _users_ and _ConfirmationToken_  mapped to _confirmationToken_  
The table confirmationToken has one to one relationship with the users’ table, and in both the entity  
classes declared @Id annotation which represents the primary key.  

Then I created a Repository Interface for UserEntity and Confirmation Token  
In this step, is the addition of the Data Access Layer which provides all the basic CRUD Operation need  
to be performed on database level by the Spring Data.  

Here I created the Email Service class  
This service class is required to send the activation or confirmation link to the user’s email address  
once they completed the registration. To achieve this functionality the Spring Mail API was used.  

Once the user fills the registration form and clicks on the submit button then this method gets  
executed. First, it will verify and compare that user’s email address with the email addresses exists  
in the database, if it finds, then it will redirect to the page along with the message, “This email  
already exists!”. Otherwise, if there is no validation issue or the email address is completely new  
then the user’s detail will be saved in the users’ table and then the random confirmation token will  
be created and stored in the confirmation_token table along with the email address. And once all the  
above things are completed then that confirmation token will be sent to the user’s email address in  
the form of an activation or confirmation link.  

