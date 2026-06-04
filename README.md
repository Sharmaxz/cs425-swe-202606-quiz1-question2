# Customer-Accounts Management System (CAMS)

**Repository:** [https://github.com/Sharmaxz/cs425-swe-202606-quiz1-question2](https://github.com/Sharmaxz/cs425-swe-202606-quiz1-question2)

## Overview
This is a Command-Line Interface (CLI) application for the CS425 Banking Corporation to manage customer-accounts data. The system categorizes accounts into Silver, Gold, and Platinum tiers and computes the bank's liquidity position.

## Prerequisites
- **Java Runtime Environment (JRE):** Java 25
- **Build Tool:** Apache Maven 3.8+

## How to Build the Application
To build the application and create an executable artifact, run the following command from the root of the project directory:

```bash
mvn clean package
```
This will generate an executable fat JAR named `camsapp.jar` inside the `target/` folder.

## How to Run the Application
After building the project, use the following command to run the application:

```bash
java -jar target/camsapp.jar
```

## Features Implemented
1. Displays a list of all Accounts in JSON format, sorted in descending order of the Account balance amounts.
2. Calculates and displays the Liquidity Position of the bank at the bottom of the list.
3. Displays a list of only Platinum tier Accounts in JSON format, sorted in descending order of the Account balance.

## CI/CD
This project is configured with GitHub Actions. On every push to the `main` branch, the Maven build is automatically executed.
