package se.hig.pgr.lab2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author thomas
 */
public class FootballGoalsSource implements DataSource {
	
	private String name;
	private String unit;
	
	
	
	public FootballGoalsSource (String name, String unit){
		this.name = name;
		this.unit = unit;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUnit() {
		return unit ;
	}

	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher fetcher = new UrlFetcher("http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=1000");
		JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());
		Map<String, Object> data = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();
		for (Map event : (List<Map>) data.get("events")) {

			Map<String, Object> facts = (Map <String, Object>) event.get("facts");

			Map <String, Object> arena = (Map <String, Object>) facts.get("arena");
			if (arena != null){
				String playedArena = (String)arena.get("articleName"); 

				if(playedArena.equals(City.GAVLE.getArena())){
					LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));
					int goals = Integer.parseInt(event.get("visitingTeamScore").toString());
					goals += Integer.parseInt(event.get("homeTeamScore").toString());
					addGoalsToDate(result, date, goals);
				}
			}
		}
		return result;


	}

	private void addGoalsToDate(Map<LocalDate, Double> result, LocalDate date, int goals) {
		if (!result.containsKey(date)) {
			result.put(date, new Double(goals));
		} else {
			result.put(date, result.get(date) + goals);
		}
	}

	
	public Map<LocalDate, Double> testGetData(String json, City city){
		Map<String,Object> data;
		JsonToMapParser parser = new JsonToMapParser(json);
		data = parser.getResult();
		
		Map<LocalDate, Double> result = new TreeMap<>();
		for (Map citys : (List<Map>) data.get("game")){
			
			String stad = (String)citys.get("city");
			
			if(stad.equals(city.getName())){
				LocalDate date = LocalDate.parse((citys.get("date").toString()));
				Double goals = Double.parseDouble(citys.get("goals").toString());
				result.put(date, goals);
			}
		}
		
		
		return result;
	}
	
//	public static void main(String[] args) {
//		System.out.println(new FootballGoalsSource().getData());
//		System.out.println(City.GAVLE.getArena());
//	}
}
