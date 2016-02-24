package se.hig.pgr.lab2;

public class Main {

	public static void main(String[] args) {
		
			System.out.println(new FootballGoalsSource().getData());
			System.out.println(City.GAVLE.getArena());
			
			System.out.println(new TemperatureSource().getData());
			
		

	}

}
