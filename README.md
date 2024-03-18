# CSV Project

A Java application designed to demonstrate various techniques for parsing and reading CSV data, serving as a recap of my
learnings in handling CSV files. This project utilizes the `opencsv` library for efficient CSV parsing and the `Lombok`
library to minimize boilerplate code.

---

## Features

* Object Mapping: Converts CSV data into Java objects, facilitating straightforward data manipulation.
* Manual Parsing: Provides granular control over the parsing process, enabling the application of custom logic and data
  handling.
* Basic File Reading: Demonstrates fundamental Java file reading techniques.

--- 

## Technologies

This application utilizes the following technologies:

  **Java JDK** 21 <br />
  **Maven**: 3.9.5 <br />
  **CSV library (`opencsv`)**: 5.9 <br />
  **Lombok**: 1.18.30

These dependencies are managed by Maven and will be automatically downloaded during the build process. Ensure Maven is
installed on your system to manage these dependencies seamlessly.

---

## Setup and Execution

**Clone the Repository**

Clone the project repository to your local machine using the following command:

```bash
git clone https://github.com/CarinaPorumb/CsvProject
```

**Build the Project**

After cloning the repository, open your terminal and build the project using Maven by executing the following command:

```bash
mvn clean install
```

**Running the Application**

Once the project has been successfully built, run the application by executing the `main` method in the `App` class.

This process will read data from the `Players.csv` file located in the `src/main/resources` directory and output the
results to the console.
