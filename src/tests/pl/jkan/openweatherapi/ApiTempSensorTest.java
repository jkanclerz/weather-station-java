package pl.jkan.openweatherapi;

import org.junit.Test;
import org.junit.Assert;

public class ApiTempSensorTest {
  
  @Test
  public void itIsAbleToBeConstruct() {
     ApiTempSensor sensor = new ApiTempSensor();
     
     Assert.assertNotNull("Something went wrong", sensor);
     Assert.assertNotNull(sensor);
  }

}
