For running test locally: Enter the following in the command line

mvn clean verify "-Dcucumber.options= --tags @smokes-ui" 

For running test on gitlab: 
1. Go to https://gitlab.com/alexandr220v/waarkoop-test/-/pipelines
2. Run pipeline
3. Wait and find serenity reports:  example

```
[INFO] -----------------------------------------
[INFO]  SERENITY TESTS : FAILURE
[INFO] -----------------------------------------
[INFO] | Tests executed         | 4
[INFO] | Tests passed           | 3
[INFO] | Tests failed           | 1
[INFO] | Tests with errors      | 0
[INFO] | Tests compromised      | 0
[INFO] | Tests pending          | 0
[INFO] | Tests ignored/skipped  | 0
[INFO] ------------------------ | --------------
[INFO] | Total Duration         | 10s 781ms
[INFO] | Fastest test took      | 619ms
[INFO] | Slowest test took      | 7s 793ms
```


### Before running test make sure the next tools installed: 
1. Java 17 
2. Maven 
3. Cucumber plugin for Intellij Idea


###Refactored:
1. Test scenario refactored to parametrized
2. Using assetJ instead of RestAssured assertion
3. Using DTO for tets data transfer 
4. Added response attribute verification , verify status code is not enough 
5. Reduce hardcoded methods with one parameters
6. Added rest assured simple logs 

###Bugs: Found bugs in product endpoint(left comments under method in step definition )
//there is a bug in search results for apple - title is "Organix Knijpfruit Appel, Aardbei & Quinoa 12 Maanden 100 g" not contains apple
//there is a bug in search results for mango - title is "Bonbébé Appel Perzik Banaan Pouch 6 Maanden 90 g" not contains mango



