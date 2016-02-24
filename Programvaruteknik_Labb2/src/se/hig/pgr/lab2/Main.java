package se.hig.pgr.lab2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	private static DataCollectionBuilder builder;
	
	public static void main(String[] args) {
		
		//	System.out.println(new FootballGoalsSource().getData());
			System.out.println(City.GAVLE.getArena());
			
		//	System.out.println(new TemperatureSource().getData());
			
		
			run();
			

	}
	
	private static void run(){
		
		builder = new DataCollectionBuilder(new FootballGoalsSource(), new TemperatureSource(), Resolution.DAY);
		
		
		

		
		
		
		
		System.out.println(builder.getResult().toString());
	}

}
