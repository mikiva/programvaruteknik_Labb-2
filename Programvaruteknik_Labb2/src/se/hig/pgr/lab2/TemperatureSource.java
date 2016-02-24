package se.hig.pgr.lab2;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.util.Map;

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
		
		String csvFile = "http://opendata-download-metobs.smhi.se/api/version/latest/parameter/2/station/107400/period/corrected-archive/data.csv";
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ", ";
		
		
		
		
	}
	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher url = new UrlFetcher("http://opendata-download-metobs.smhi.se/api/version/latest/parameter/2/station/107400/period/corrected-archive/data.csv");
		
		CSVparser parser = new CSVparser(url.getContent());
		
		return parser.getResult();
	}
	
}
