package se.hig.pgr.lab2;

public enum City {

	
	HELSINGBORG ("Helsingborg","Olympia, Helsingborg"),
	GAVLE("Gävle", "Strömvallen");
	
	
	private String arena;
	private String name;
	
	private City (String name, String arena){
		this.name = name;
		this.arena = arena;
		
	}
	
	public String getArena(){
		return arena;
	}
	public String getName(){
		return name;
	}
}
