# EasyLearn - online learning management system
This project is a simple online learning management system for schools. It simulates the [moodle](https://moodle.org/) platform to allow students, parents, and teachers to interact together.
### Technologies
 * Spring Boot
 * Maven
 * Hibernate
 * Postgres
### Setup
The project can be imported in Intellij or Eclipse STS or can be cloned directly from the repo.
### Run
   1. Create a database with the name and credentials specified in the application.yml file.
   2. Run the jar file in the ```../jars``` folder with the command ``` java -jar easylearn-0.0.1-SNAPSHOT.jar ```.
   3. To be able to access the data using the HTTP methods, an authentication should be done by using any API tester and making a ``` HTTP POST ``` request with the email and password of any of the users available in the ``` resources\data.sql ``` file as body.
   4. A Javascript Web Token will then be generated.
   5. Swagger API documentation was configured and can be accessed by heading to ``` http:\\localhost:8888\swagger-ui.html ``` and using the authorize method while giving ```BEARER ${generated JWT} ``` as an input.
   6. All the implemented features in the application can then be tested in the swagger api documentation.
### Front-end
For front-end an Angular application was created and can be accessed by navigating to the repository [easylearn-frontend](https://github.com/MahmoudAbderahman/easylearn-ui). 
#### Sample images from the system
