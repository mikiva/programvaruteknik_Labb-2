package se.hig.pgr.lab2;

import java.io.BufferedReader;

public class TemperatureSource implements DataSource{
	
	
	@Override
	public String getUnit(){
		return "Celsius";
	}
	@Override
	public String getName(){
		
		return "Temperatur for " + City.GAVLE;
	}
	
	

	public static void main(String[] args){
		
		TemperatureSource tempSrc = new TemperatureSource();
		tempSrc.run();
		
		
	}
	
	public void run(){
		
		String csvFile = "smhi-opendata_2_107420_corrected-archive_2016-02-01_23-00-00";
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ", ";
		
		
		
		
	}
	
}
