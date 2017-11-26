## Compile weather station Cli interface

#### Compile all your resources
```bash
javac -cp ./target -d target src/main/pl/jkan/http/*.java
javac -cp ./target -d target src/main/pl/jkan/openweatherapi/*.java
javac -cp ./target -d target src/main/pl/jkan/weatherstation/*.java
javac -cp ./target -d target src/main/pl/jkan/weatherstation/sensors/*.java
javac -cp ./target -d target src/main/pl/jkan/weatherapp/Cli.java
```

#### Ensure env variable with your api key exists
```bash
export OPEN_WEATHER_API_KEY="{{YOUR_OPEN_WEATHER_API_KEY}}"
```

#### Execution - get temperature for your city
```bash
java -cp ./target pl.jkan.weatherapp.Cli Krakow
java -cp ./target pl.jkan.weatherapp.Cli London
java -cp ./target pl.jkan.weatherapp.Cli Mexico
```

## Compile weather station tests

#### Ensure your junit dependencies exists in class path 
- hamcrest-core-1.3
- junit-4.12

```bash
javac -cp ./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar:./target -d target src/test/pl/jkan/http/*.java
javac -cp ./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar:./target -d target src/test/pl/jkan/openweatherapi/*.java
```

#### Make sure all is ok
```bash
java -cp ./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar:./target org.junit.runner.JUnitCore pl.jkan.http.SimpleBrowserTest
java -cp ./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar:./target org.junit.runner.JUnitCore pl.jkan.http.ApiClientTest
java -cp ./jars/junit-4.12.jar:./jars/hamcrest-core-1.3.jar:./target org.junit.runner.JUnitCore pl.jkan.http.TempParserTest
```