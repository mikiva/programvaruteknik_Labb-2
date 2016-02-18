package se.hig.pgr.lab2;

public enum City {

	
	HELSINGBORG ("Olympia, Helsingborg"),
	GAVLE("Strömvallen");
	
	
	String arena;
	
	private City (String arena){
		this.arena = arena;
		
	}
	
	public String getArena(){
		return arena;
	}
}
