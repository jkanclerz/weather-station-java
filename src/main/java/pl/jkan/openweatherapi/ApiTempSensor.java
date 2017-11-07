package pl.jkan.openweatherapi;

import pl.jkan.weatherstation.TempSensor;

class ApiTempSensor implements TempSensor {
    
    public double read() {
       return 1.00;
    }
}
