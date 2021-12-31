# GradleBootDemo

## Overview
This project that was assigned by LIDP Consulting Services, Inc as challenge after an interview. The task was to build a Spring Boot app using Gradle. The app was to run on a Spring Boot server. The Angular front end was to be hosted on this server. After the app was built using Gradle, the jar file could be launched from the CLI. There were three required and three optional challenges in the original assignment. 

The LidpApp directory serves as a root Gradle project, with Spring Boot and Angular projects inside of it. By building LidpApp, the nested projects would also be built. The Angular UI would then be stored as static content in the Spring Boot project. Click [here](https://www.youtube.com/watch?v=-P3FlYj_yHs) to watch a demo on this process.
## Challenges
### Required
* It must be a Gradle project
* Implement Spring Boot into this project
    * The app should run on port 80
* Create a homepage using Angular and Angular Material
### Optional
* In the front end, prompt the user to enter their name. The page should change dynamically as the user inputs their name to display "Hello, inputtedName"
* Create a RESTful web service that will get the name of the application and the current date. The front end should call the service when the page loads and display the information on the page
* Create a RESTful web service to calculate the circumference of a circle for a given radius provided by a user. A user can input the radius in the UI, the radius would then be sent to the back end, and the circumference would be displayed to the user.
* Include in the front end using Angular Material:
    * A button that pops up a snackbar with some kind of message
    * A grid of 3 or more cards that display any type of content
    * A datepicker that allows the user to select their DOB and tells them their age
* Create a RESTful web service to get the basic system stats that include CPU usage, used and total RAM, used and total HDD space. This info would then be returned and displayed to the user
* Connect the app to a relational database. The front end would include a form containing first name, last name, and favorite color fields. The user can create, retrieve, update, and delete entries

## Technologies Used
* Java 8
* AWS
* Git
* Gradle
* Spring Boot
* Spring Data
* Angular 11
* Angular Material
* NodeJS
* PostgreSQL
* Docker

## Getting Started

### Installation Help
* [Helpful Installation Guide](https://github.com/201130-JavaFS/Environment-Installation-Guide)
* [Another Helpful Guide](https://github.com/vinayingalahalli/roc_revature_201910/tree/master/installation%20guide)
* [Gradle Installation](https://gradle.org/install/)
* [Docker Installation](https://docs.docker.com/desktop/windows/install/)

### Setup
* Clone the repository
* Set the JRE in your IDE
* Set Gradle in your IDE
* Create a relation database
    * If using an AWS RDS, make sure that your IP address is in your security group
* Execute the sql/rebuild_DB.sql file

#### Execution From Git Bash (Windows)
* Build app by running the `./gradlew build` command from inside the LidpApp directory.
    * `./gradlew clean build` if appropriate
* Then enter `java -jar BootApp/build/libs/BootApp-0.0.1-SNAPSHOT.jar` to start the Tomcat server.
* Lastly, type `localhost:80` into a web browser 
* Enter `Ctrl + C` in the bash window to stop the server

## Contributor
* [Lew Griffith](https://github.com/logriffith)


