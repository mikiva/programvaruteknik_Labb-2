package se.hig.pgr.lab2;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CSVparser {
	

	private String csvString;
	
	private BufferedReader buffer;
	
	public CSVparser(String file){
	
		this.csvString = file;
		
		
		
		
	}
	
	public Map<LocalDate, Double> getResult(){
		
		Map<LocalDate, Double> temperatureMap = new HashMap<LocalDate, Double>();
		
		String[] splitString;
		
		splitString = csvString.split(";");
		
		for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].startsWith("Y"))
			{
				temperatureMap.put(LocalDate.parse(splitString[i-2]), 
						Double.parseDouble(splitString[i-1]));
			}
			
		}
		
		
		return temperatureMap;
	}
	
	

}
