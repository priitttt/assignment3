Student Database Management System
This java application connects to PostgreSQL database to perform, Retrieve, Adding, Updating, and Deleting Student 
Records. It uses JDBC for database connectivity and demonstrate clean database handling with helper class.

Features:
Connects to Postgres Database
Retrieves all Student Records
Adds new Student Record
Update existing student email
Deletes student record
Gives updates if each operations were a success or not

Prerequisites:
Java JDK (version 25)
PostgresSQL
Maven(Optional)
PostgreSQL JDBC Driver (version 42.7.8.jar)

Project Structure: 
a3/
    src/ 
        main/
            java/
                main.java
                databaseOperations.java



Steps to Compile and Run:
Note: To compile this program user must be in a3 folder 
Compile:
javac -cp "postgresql-42.7.8.jar" -d bin src/main/java/*.java

Run:
java -cp "bin;postgresql-42.7.8.jar" main

This program can also be compiled using maven. pom.xml file already has depencency copied but if user chooses to go manual
way above commands can be used. The jar file is also added in a3 folder.



