# Bowling Game
This Bowling Game Kata is developed using <b>Test Driven Development</b> approach.
This Program will help us to calculate <i><b>game score</b></i> based on given input for each rolls. 
Here we can roll a ball upto 10 frames and each frames contains 2 rolls. <br> <br>
The calculation is based on general rules and assumption is each rolls are valid. 
# Prerequisites
To run this program below softwares needs to be installed
```
Java - Version 1.6 or above
Maven - For Dependency management
JUnit - Version 4.12 (added dependency in pom.xml)
Eclipse - Any IDE which supports Java
```

# To run the Test cases Using Command prompt
```
Download project as zip file and unzip the same to a folder. 
Open a command prompt and goto the project(extracted) folder and execute below commands:
mvn clean
mvn install
```
#### After completion of above steps, test report will be available in below path
```
<PROJECT_ROOT_FOLDER>\target\surefire-reports\TEST-com.bnpp.kata.BowlingGameTest.xml
```
# To run the test cases Using eclipse
```
Download project as zip file and unzip the same to a folder. 
In eclipse Go to 
File -> Import -> select Existing Maven Project option -> Next -> Browse extracted folder and Finish
Then,
Right click project in Project Explorer window and select Run As -> Maven install

Once above steps done open <b>BowlingGameTest</b> class and right click file and choose Run As -> JUnit Test
```
# To run the application Using eclipse with main method
```
  public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		game.callRollUsingArrayOfPins(2, 2, 2);
		System.out.println(game.calculateGameScore());
	}
  
  Use above method to run the application without JUnit. 
  
  Note: You can pass upto 22 arguments to callRollUsingArrayOfPins method in above sample
```
## Author
<b>DEV-2020-008</b>
