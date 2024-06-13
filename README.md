# Selenium WebDriver Test Suite

This project contains 10 automated test scripts using Selenium WebDriver to test the OpenCart demo site.

## Link to the Web Application

The tests are designed to run against the publicly available OpenCart demo site: [OpenCart Demo](https://demo.opencart.com)

## Prerequisites

Before running the tests, ensure you have the following installed:

- Java JDK 8 or later
- Maven 3.6.0 or later
- Google Chrome (latest version)

## Setup

1. **Clone the repository:**

    git clone git@github.com:Rajindra/TestOpenCartPage.git
    cd TestOpenCartPage

2. **Install dependencies:**

    Maven will automatically install the necessary dependencies when you build the project.

    mvn clean install


## Running Tests

You can run the tests using Maven. This project uses JUnit 5 for writing and running tests.

    mvn test

## Important Note on Test Execution

### Potential Test Failures

Some of the test cases might fail due to limitations caused by screen size. Specifically, issues with scrolling and finding clickable elements can occur if the screen size is too small. To mitigate this, it is recommended to run the tests in a maximized browser window or on a screen with sufficient resolution.
