# Qase Diploma

## [Diploma for TMS course (July -- December 2020)](https://teachmeskills.by/kursy-programmirovaniya/qa-avtomatizirovannoe-testirovanie-online)

### AUT
https://qase.io/
### API
https://developers.qase.io/#introduction
### circleci
https://app.circleci.com/pipelines/github/MikhailKlimentyev/QaseDiploma

---
### Stack
Java 8, Selenide, REST Assured, TestNG, Maven, Allure, Lombok, Log4j2, GSON

### Run tests
mvn clean -DsuiteXmlFile=src/test/resources/testng.xml install

### Generate Allure report
mvn allure:serve

---
* Tests run in 4 threads. Tests from one class are run in one thread
* Test data (projects) is deleted by prefix of project name before tests' run
* Data created by tests is deleted after each test's run