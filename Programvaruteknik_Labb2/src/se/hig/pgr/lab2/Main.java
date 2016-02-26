package se.hig.pgr.lab2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	private static DataCollectionBuilder builder;

	public static void main(String[] args) {

		
		System.out.println(City.GAVLE.getArena());

		run(City.GAVLE);


	}

	private static void run(City city){

		builder = new DataCollectionBuilder(new FootballGoalsSource("Goals", "st"), 
				new TemperatureSource("Temperature for ", "C", city), Resolution.MONTH);

		System.out.println(builder.getResult().toString());
	}

}
