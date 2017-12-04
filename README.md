## Compile weather station Cli interface

#### Compile all your resources
```bash
mvn package
```

#### Ensure env variable with your api key exists
```bash
export OPEN_WEATHER_API_KEY="{{YOUR_OPEN_WEATHER_API_KEY}}"
```

#### Execution - get temperature for your city
```bash
java -jar ./target/WeatherStation-0.1-develop.jar 
```

## Compile weather station tests

```bash
mvn test-compile
```

#### Make sure all is ok
```bash
mvn test
```
