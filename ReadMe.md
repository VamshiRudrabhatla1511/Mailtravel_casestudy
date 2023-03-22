
1. All the Web tests are written using selenium web driver using Page Object Model with Cucumber BDD and Runner. These are located under web-tests project.
2. All the API tests are written using Rest Assured and TestNG. These can be found under the api-tests project.


---To Run the Tests --
1. `mvn install` command  web tests with chrome driver by default
2. If you want to change the driver, you can change it by specifying the "device_name" value as either IE or Opera or Firefox in the test.properties file in the test/resources/config/test.properties in the web-tests project.
3. To Run API tests navigate to 'MailTravel-casestudy/api-tests' folder and execute command `mvn -Dtest=ApiServiceSteps test` runs api-tests with RestAssured.

---To view the reports---
1. For the cucumber based web tests, the reports can be found in the target/cucumber/1/index.html file in the web-tests project. If all the feature steps show as green, it indicates that the test is successful. It shows as red in case of a failure.
2. For the API tests, the test run reports can be found under target/surefire-reports/index.html file in the api-tests project.