# Irrigation System Application

The Irrigation System Application is a Java-based application that allows users to manage plots and trigger irrigation for specific plots.

## Installation

1. Clone the repository from GitHub: [https://github.com/your-username/irrigation-system.git](https://github.com/your-username/irrigation-system.git)

2. Import the project into your preferred Java IDE.

3. Build the project using Maven:

   ```shell
   mvn clean install       ```
   
## Configuration
Create a MySQL database for the application.

Open the application.properties file located in the src/main/resources directory.

Configure the database connection properties in the application.properties file:  
spring.datasource.url=jdbc:mysql://localhost:3306/irrigation  
spring.datasource.username=username  
spring.datasource.password=password  



Please note that you should replace `username` and `password` with your actual MySQL database credentials.

Usage
Run the application from your IDE or using the following Maven command:

   ```shell
   mvn spring-boot:run
   ```

## The application will start, and you can access it through the following URL: http://localhost:8080

Use the available endpoints to manage plots and trigger irrigation.

Unit Tests
The application includes unit tests to verify the correctness of key components and functionalities. The tests are implemented using JUnit and Mockito.

To run the unit tests, navigate to the root directory of the project and execute the following Maven command:

 ```shell
   mvn test 
```
## The test results will be displayed in the console, indicating the success or failure of each test.

Contributing
Contributions to the Irrigation System Application are welcome. If you find any bugs or have suggestions for improvement, please submit an issue or a pull request on the GitHub repository.

License
The Irrigation System Application is open source and released under the MIT License.
