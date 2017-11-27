package pl.jkan.weatherstation.sensors;

import pl.jkan.weatherstation.TempSensor;

public class FakeTempSensor implements TempSensor {
  public double read() {
    return -14.80;
  }
}
