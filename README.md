# springboot-app

This Web application consist of  implemening the CRUD using Java Spring Boot, PostgreSQL, Thymeleaf and JPA.
This application allows user to add, update and delete an employee.

# STEP 1: TOOLS AND INSTALLATION

  * Java JDK
   -  Download JDK 17 following this link: JDKhttps://blogs.oracle.com/java/post/changes-in-the-oracle-jdk-installers
   -  Download Intellij IDEA community edition here: https://www.jetbrains.com/idea/download/?ij80pr#section=windows
   

  * PostgreSQl
   -  postgreSQL is database that supports the application.
   -  Link for downloading postgreSQL https://www.postgresql.org/download/
   -  Watch this youtube to properly install postgreSQL on Windows 11: https://www.youtube.com/watch?v=GU3uRV0A8HQ&t=337s
   
  
  *JPA
   - Java Persistence API is ac collection of classes and methods to persistently store the vasts amounts of data into a database
    which is provided by the oracle Corporation.Otherwise, JPA forms a bridge between object models and relational models(database)
   - Follow this Link for installing and/or enabling JPA  https://www.jetbrains.com/help/idea/jakarta-persistence-jpa.html#enable-for-existing-project
 
 *Thymeleaf
 
  # Step 2
      Step 1: Create a Spring Boot Application
      Step 2: Maven dependencies
      Step 3: Configuring PostgreSQL Database
      Step 4: Create JPA Entity - Employee.java
      Step 5: Create a Spring Data Repository - EmployeeRepository.java
      Step 6: Create Custom Exception
      Step 7: Create Spring Rest Controller - EmployeeController.java
      Step 8: Running Spring Boot Application
      Step 9: Testing CRUD REST APIs via Postman Client

  # STEP 3 PROJECT SET UP
  
  - To genarate the project open this link: start.spring.io
    - Project: maven project
    - language: Java
    - Sprint BootVersion:3.0.0
    - Project Metadata
      - Group:  com.example ( I kept the default setting)
      - Artifact: sprintboot-app
    - Add dependencies
      - Thymeleaf ( A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in the browsers and static prototypes
      - Spring Web ( RESTful applications using Spring MVC)
      - Spring Boot DevTools(provide fast applications restarts, Livereload and configurations for enhanced development experience
      - postgreSQL Driver (A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard.
      - Spring Data JPA( persist data store with Java Persistence API using Data and Hibernate)
      - Then, click on explore to verify if the pom.xml exists.
      - click Generate will download zip file containing the project set up
      - Unzip the zip file
      - import the unzipped file on Intellij IDE
      
     # STEP 4 CONFIGURING PostgreSQL Database
       - Open the postgreSQL
       - Provide the password that created when setting up postgreSQL
       - Open the query and enter the following command: CREATE DATABASE employee
       - Open src/main/resources/application.properties file and add the following content to it ( Enter your password):
                                spring.datasource.url=jdbc:postgresql://localhost:5432/employees
                    spring.datasource.username=postgres
                    spring.datasource.password=root
                    spring.jpa.show-sql=true

                    ## Hibernate Properties
                    # The SQL dialect makes Hibernate generate better SQL for the chosen database
                    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

                    # Hibernate ddl auto (create, create-drop, validate, update)
                    spring.jpa.hibernate.ddl-auto = update

     
  
