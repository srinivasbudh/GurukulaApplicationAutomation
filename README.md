# GurukulaApplicationAutomation

This Project is a small POC of Serenity BDD framework using Selenium, java and cucumber

In this project I have performed testing on Gurukula application

I have attached **"Gurukula Test Document.xlsx"** in this repository with all the test Analysis, results and findings. Below are the details of attached excel at sheet Level

**BusinessFlow:** This sheet has the business flow of the application. This flow is designed as per my understanding and to derive epics from the Application

**Requirement Analysis:** This sheet has epic split down of application and later split it into user stories.

**Manual Test Cases:** This sheet has test Manual test cases that are derived from epics

**Automation Test case:** This sheet has Automation test cases that are developed

**Bugs:** This Sheet has all the bugs that are Identified

**Observations:** This sheet has the observation that I have made for the application

All the test cases here in the automation framework are added in BDD format. The reason for choosing tests to write in BDD format are as below

		1) Currently many teams are using BDD in SDLC as Acceptance criteria are very well available for both Development and testing
		2) Using BDD Acceptance test Will help the business understand the test cases very easily
		
# Testing Framework

I have used BDD Test Automation framework Using SerenityBDD. This serenity BDD is a library which uses Cucumber and selenium for its development. Below are the reasons for choosing this framework

		1) Easily maintainable automated acceptance criteria 
		2) Living documentation of test results
		3) Opensource tool with huge support Online
		


## How to Launch the tests

	# Pre-requisite: Maven is installed in the machine and configured properly
	
## 1) Using Maven

		Open a command window and run:

			mvn clean verify
			
		To run cases with specific Tags
		 
		mvn clean verify -Dcucumber.options="--tags @TagName" (EX: UI, Smoke, Regression)
			
			
**Note:** This automation by default runs in headless Chrome browser, This property can be changed in serenity.properties file by just commenting __chrome.switches__ value. Also this full execution takes around 18 minutes to Finsih. Once execution is done Reports will be generated in target folder 			

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(CucumberWithSerenity.class)` annotation on the `CucumberTestSuite`
class tells JUnit to kick off Cucumber.

## 2) Using IDE
	Open the cloned project in IDE. Enable Auto-Import for Maven-dependency
	run Testrunner files in the path (src\test\java\testRunners)


## Test Result (View the reports)
Serenity BDD has one of the best reporting and the test reports are generated every time we execute the tests.

I have added sample test results here in the repository (https://github.com/srinivasbudh/GurukulaApplicationAutomation/tree/master/Final%20report%20After%20execution)

When the project is cloned into Local reporting of test results can be seen if we open **_`index.html`_** from Final report after execution folder.

Kindly let me know if you need any further Information. You can contact me on my emailID.	
	





		
