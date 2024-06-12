
## Setup

1. **Clone the repository:**

    ```bash
    git clone git@github.com:Rajindra/TestOpenCartPage.git
    cd TestOpenCartPage
    ```

2. **Install dependencies:**

    Maven will automatically install the necessary dependencies when you build the project.

    ```bash
    mvn clean install
    ```

3. **Set up WebDriver:**

    This project uses WebDriverManager to handle WebDriver binaries automatically, so there's no need to manually download and set the path for ChromeDriver.

## Running Tests

You can run the tests using Maven. This project uses JUnit 5 for writing and running tests.

```bash
mvn test
