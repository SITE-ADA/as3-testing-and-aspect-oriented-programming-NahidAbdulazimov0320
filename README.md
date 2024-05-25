Testing and AOP.
Dear students,

In this assignment, you are required to create a very simple RESTful application using Spring similar to the previous Assignment 2. (One entity and CRUD operations on that entity is enough - use GET, POST, DELETE, PUT, PATCH methods).

Task related: (20%)
Create a CRUD for a single entity
Perform a validation for data entry in create and update
Use DTO pattern instead of exposing your entities to the client
Perform dynamic and automatic mapping using MapStruct instead of manual mapping
Task related: (20%)
Write unit tests to test methods of Service class(es). Try to design test scenarios as rich as possible
Write some integration tests for Controller methods
Task related: (20%)
Log a message before each method is called in the Service class(es) with the information about the input parameters
Log a message after each method is executed in the Service class(es) with the information about the return value
Log a message after each method is executed in the Service class(es) with the information about the execution time
Task related: (30%)
Develop another app which will use the endpoints exposed by the first app listening to different port.
Develop endpoints on the new app to send requests to the former one and redirect the responses back to the user.
Apply logging again for the new app.
Bonus: (20%)
There are two applications now that are running on your machine.
Dockerize the applications:
Create Dockerfile for both applications and build the docker image for both.
Run both images to create containers and check both applications.
Running multiple images manually is not very practical. Create docker-compose file to run your containers in an easier way.
Submission related: (10%)
Make sure you configured your git client (i.e., username and email is set). Use firstname_lastname as the username.
Please, also ensure that you regularly check, add and commit your changes to the remote repo so that we can see your progress.
Things to be submitted to the BB grader in a .zip format:
This README.md file updated to have
the instructions on how to start and use the application(s)
link to the video recording
Application source after ./gradlew clean
Submissions without a video submission will not be graded.
Note: Please work every day; this is definitely not a task you can complete on the last day! To keep track of the progress, create a git repository, commit, and push each change (ideally at least every time you complete a feature) to the repository. Ensure that you have at least 1 commit a day STARTING from May 9th otherwise you will lose points.

For late submissions please refer to the SYLLABUS.

This assignment will give you 10% of the total.
Good luck!
NS

Report:
This project involves creating two Spring Boot applications to demonstrate various software engineering principles. The primary application (App1) manages CRUD operations for a single entity with robust data validation and employs the DTO pattern using MapStruct for automatic mapping. Logging is extensively implemented to capture input parameters, return values, and execution time for service methods, ensuring transparency and ease of debugging. Unit tests were designed for service class methods, and integration tests were developed for controller methods to ensure comprehensive functionality. The secondary application (App2) consumes the endpoints exposed by App1, listening on a different port and re-exposing them to users. Logging is also applied in App2 to maintain consistent traceability. Both applications are containerized using Docker, and Docker Compose is employed for simplified management of the containers. This setup allows easy deployment and scalability. To ensure continuous progress, regular commits to a Git repository were made, adhering to the project guidelines of committing at least once a day. The project also includes a video demonstration of the application’s features and usage instructions. The inclusion of detailed logs, extensive testing, and containerization underscores the project's focus on maintainability, reliability, and ease of deployment.


Link:
https://youtu.be/7LBF_6Zoilw