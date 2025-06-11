package Model;

public class Gericht {
	private String name;
	private int dauer;
	private int personen;
	
	
	public Gericht(String name, int dauer, int personen) {
		this.name = name;
		this.dauer = dauer;
		this.personen = personen;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getDauer() {
		return dauer;
	}
	
	public int getPersonen() {
		return personen;
	}
}
