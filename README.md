# Console application "Airline" 

The program keeps records of airline's airplanes.
Functionality of priject include seven different command.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to launch application.

### Prerequisites

To launch this project, you have to be sure that you have installed 
Java 8 and Maven on your PC.

### Installing

1. Download zip arhive and open it with arhive manager.

2. Open terminal and using comand.

3. Type in terminal command cd <path_to_folder_with_project>

4. Then you need to build project. Enter this command

  mvn compile

5. After that you can run the project, you need to type this command to do this

  java -classpath target/classes/com/tytarenko/Main

6. As the result, you will have this in your command line

1 - display the list of aircraft of the company sorted by flight range.
2 - display total passanger capacity
3 - display total capacity
4 - dispaly total carrying capacity
5 - airplanes corresponding to a given range of fuel consumption parameters
6 - add new aircraft
7 - remove aircraft by id
0 - exit
Select command: 

Another way to run project is to use IDE.
To biuld this project, you have to open it like Maven project.
Maven automaticaly build your project and download dependencies.
Finally, you can run project.

## Running the tests

You can run tests, if you have already do fifth step in previous chapter.
Simply type this command in your terminal

  java -classpath target/test-classes/com/tytarenko/airline/AirlineImplTest

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
 

## Authors

* **Vladyslav Tytarenko** - [VladTytarenko](https://github.com/VladTytarenko)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


