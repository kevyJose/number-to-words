# Number to Words Converter (Java Web App)

This project is a lightweight Java-based web application that converts a numerical currency value (e.g. `123.45`) into its English word representation (e.g. `ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS`). It includes a custom-built algorithm and a simple web interface served using Java's built-in HTTP server.

---

## 🛠 Prerequisites

- Java 11 or higher installed
- Maven installed (`mvn` command available in terminal)
- Modern web browser (e.g., Chrome, Firefox)

---

## 🚀 Build & Run Instructions

1. Clone the Repository   
First, clone the project (using HTTPS), to your local machine:

```
git clone https://github.com/kevyJose/number-to-words.git
cd number-to-words-converter
```

Replace the URL above with your actual GitHub repository URL.

2. Ensure Java and Maven Are Installed  
Make sure both Java and Maven are installed and available in your system PATH.

To check Java:
```
java -version
```
To check Maven:
```
mvn -version
```
If Maven is not recognized, you must install it from https://maven.apache.org/install.html and add it to your system’s environment variables.

3. Build the Project  
From the root project directory, run the following command:
```
mvn clean package
```
This will compile the source code and generate a JAR file inside the target/ folder.

4. Run the Server  
Use this command to launch the HTTP server:
```
java -cp target/number-to-words-1.0-SNAPSHOT.jar com.numberwords.Main
```
You should see:

Server started at http://localhost:8000

5. Open the Web Interface  
Open your web browser and go to:
```
http://localhost:8000/
```
You will see a simple form where you can enter a number (for example, 101.25) and receive the result in words (e.g., ONE HUNDRED AND ONE DOLLARS AND TWENTY-FIVE CENTS).

