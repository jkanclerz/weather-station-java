package pl.jkan.openweatherapi;

import pl.jkan.weatherstation.TempSensor;
import java.net.URL;
import java.text.ParseException;
import java.io.*;

public class ApiTempSensor implements TempSensor {
    
    public double read() {
       return 1.00;
    }


   public static String readURL() throws Exception
   {
	BufferedReader reader = null;
	String Url = "http://api.openweathermap.org/data/2.5/weather?q=Krakow&APPID=af319cd969dff7d8c42768f6f0d8c979&units=metric";
	
	try {
		URL url = new URL(Url);
		reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer buffer = new StringBuffer();
		int read;
		char[] chars = new char[1024];
	
		while((read = reader.read(chars)) != -1) {
			buffer.append(chars, 0, read);
		}
		return buffer.toString();
	} finally {
		if(reader != null)  {
			reader.close();
		}
	}

   }
}
