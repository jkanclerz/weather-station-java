package pl.jkan.weatherstation.sensors;

import pl.jkan.openweatherapi.ApiClient;
import pl.jkan.weatherstation.TempSensor;

public class ApiTempSensor implements TempSensor {

    ApiClient apiClient;

    public ApiTempSensor(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public double read() {
       return apiClient.getTemperature();
    }
}
