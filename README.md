# logsearchApplication


This is the code for the Log search functionality, responsible for consuming keyword and input file location 
and gives the matching snippet.

Follow this readme to get the project up and running on your local machine.

Prerequisites:
Java SDK v1.8 , Intellij/Eclipse

Build and run the code:
> git clone https://github.com/anisharam03/logsearchApplication.git
> cd logsearchApplication
> ./gradlew clean build Note:. This gradlew command is going to trigger all unit tests.

Intellij SetUp:

Follow the below steps to run locally and test :
Go to add configuration in the right top of intellij ide.
Click on Add configuration and click on the + icon on the lef top of the window to create new application configuration.
Select Application to run as java application.
You will see the window where you can configure the application with a name, select java-8, configure main class.
You might need to pass the cli arguments in environment variables.
    Added the sample file. To validate, we can pass src/main/resources/sampleInput.txt search, where 'src/main/resources/sampleInput.txt'
    is the file path and 'search' is the keyword.
Click on Apply and OK. You are all set to run the application with num symbol near the application name you have configured.



Note: I have some issues with my git hence I can't to smaller logical commits, Still I have segregated the commits.