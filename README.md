# Restassured_API_Automation
Install all dependencias in pom.xml (Rest Assured, Junit, ...)

To execute tests, run below command
mvn install

Description of tests

4 tests are done using the verb GET.
In the first test, it accesses the API with the provided parameters (URL, ID, and API KEY) and validates the title of the movie and what it returns in status code.
In the second test, it accesses with the same parameters, but validates the Movie Year and what it returns in the status code.
In the third test, it accesses with the same parameters, but validates the Language of the Movie and what it returns in the status code.
In the fourth test, it accesses with the same parameters, but validates it with a non-existent ID and what it returns in the status code.
