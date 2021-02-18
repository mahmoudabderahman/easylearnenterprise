# EasyLearn - online learning management system
This project is a simple online learning management system for schools. It simulates the [moodle](https://moodle.org/) platform to allow students, parents, and teachers to interact together.
## Table of contents
   * [Technologies](#technologies)
  * [Setup](#setup)
  * [Run](#run)
  * [Front-end](#front-end)
- [Images from the system](#images-from-the-system)
  * [ER Diagram](#er-diagram)
  * [Login](#login)
  * [Admin related features](#admin-related-features)
    + [Profile](#profile)
    + [Students panel](#admin-students-panel)
    + [Teachers panel](#admin-teachers-panel)
    + [Parents panel](#admin-parents-panel)
    + [Courses panel](#admin-courses-panel)
    + [Appointments panel](#admin-appointments-panel)
  * [Parent related features](#parent-related-features)
    + [Profile](#profile-1)
    + [Parents checking their childern](#parents-checking-their-childern)
    + [Parents checking the courses, to which their childern assigned](#parents-checking-the-courses-to-which-their-childern-assigned)
    + [Parents checking evaluation of their childern](#parents-checking-evaluation-of-their-childern)
    + [Parents checking attendance of their childern](#parents-checking-attendance-of-their-childern)
  * [Teacher related features](#teacher-related-features)
    + [Profile](#profile-2)
    + [Courses that a teacher teach](#courses-that-a-teacher-teach)
    + [Teacher evaluating a student](#teacher-evaluating-a-student)
    + [Teacher uploading documents to a course](#teacher-uploading-documents-to-a-course)
  * [Student related features](#student-related-features)
    + [Profile](#profile-3)
    + [Courses that a student assigned to](#courses-that-a-student-assigned-to)
    + [Student seeing time plan for the courses](#student-seeing-time-plan-for-the-courses)
    + [Student seeing uploaded documents of a course](#student-seeing-uploaded-documents-of-a-course)
    + [Student seeing his/her evaluation in a course](#student-seeing-evaluation-in-a-course)
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
## Images from the system
### ER Diagram
![](images/er-diagram.jpg)
### Login
![](images/login-page.png)
![](images/login-page-2.png)
### Admin related features
#### Profile
![](images/admin-profile.png)
#### Admin-Students panel
![](images/admin-profile-2.png)
#### Admin-Teachers panel
![](images/admin-profile-3.png)
#### Admin-Parents panel
![](images/admin-profile-4.png)
#### Admin-Courses panel
![](images/admin-profile-5.png)
#### Admin-Appointments panel
![](images/admin-profile-6.png)
### Parent related features
#### Profile
![](images/parent-profile-1.png)
#### Parents checking their childern
![](images/parent-students.png)
#### Parents checking the courses, to which their childern assigned
![](images/parents-students-1.png)
#### Parents checking evaluation of their childern
![](images/parents-students-evaluation.png)
#### Parents checking attendance of their childern
![](images/parents-students-attendance.png)
### Teacher related features
#### Profile
![](images/teacher-profile.png)
#### Courses that a teacher teach
![](images/teacher-profile-course.png)
#### Teacher evaluating a student
![](images/teacher-evaluate-2.png)
#### Teacher uploading documents to a course
![](images/teacher-profile-document.png)
### Student related features
#### Profile
![](images/student-profile.png)
#### Courses that a student assigned to
![](images/student-courses.png)
#### Student seeing time plan for the courses
![](images/student-appointments.png)
#### Student seeing uploaded documents of a course
![](images/student-documents.png)
#### Student seeing evaluation in a course
![](images/student-evaluation.png)
