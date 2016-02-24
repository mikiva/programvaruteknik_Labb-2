package se.hig.pgr.lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	
	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher url = new UrlFetcher("http://opendata-download-metobs.smhi.se/explore/zip?parameterIds=2&stationId=107420&period=corrected-archive&includeMetadata=false");

		CSVparser parser = new CSVparser(url.getContent());

		File fil = new File("text_01.txt");

		FileWriter write;
		try {
			fil.createNewFile();
			write = new FileWriter(fil.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(write);
			bw.write(parser.getResult().toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(parser.getResult());

		return parser.getResult();
	}

}
