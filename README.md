# Counter App Automation Using Appium and Java

## Overview

This project automates the testing of a Counter App using Appium and Java. The automation suite verifies various
functionalities, including button clicks, value increments/decrements, and UI element validation.

## Features

1. Automated UI testing of the Counter App.
2. Validation of UI elements (labels, buttons, counters, etc.).
3. Handling invalid actions (e.g., tapping buttons when the app is busy).
4. Logging framework integration for test reporting.

## Prerequisites

1. Java and set JAVA_HOME
2. Maven and set MAVEN_HOME
3. NodeJS
4. Android Studio
5. Android SDK and set ANDROID_HOME
6. IDE (preferred: IntelliJ)
7. Appium 2.0

   `npm install -g appium@next`

8. Appium Drivers

   `appium driver install uiautomator2`

   `appium driver install xcuitest`

## Project Setup

1. Clone the repository:
   `git clone https://github.com/yadsandy/mobile-app-automation.git`
2. cd mobile-app-automation
3. Install dependencies using Maven:
   `mvn clean install`
4. Connect an Android device (or start an emulator) and ensure it is detected:
   `adb devices`
5. Update the device name in [config.properties](src/test/resources/config.properties)
6. Run the test suite using
   `mvn clean test`

## Execution Result :

Console Output -
![Screenshot 2025-01-30 233856.png](src/test/resources/images/Screenshot%202025-01-30%20233856.png)
Logs -
![Screenshot 2025-01-30 233914.png](src/test/resources/images/Screenshot%202025-01-30%20233914.png)
Extent Report -
![Screenshot 2025-01-30 233935ds.png](src/test/resources/images/Screenshot%202025-01-30%20233935ds.png)
CI-CD Screenshot:
![Screenshot 2025-01-31 174935.png](src/test/resources/images/Screenshot%202025-01-31%20174935.png)

