package Model;

public class Gericht {
	private int id;
	private String name;
	private int dauer;
	private int personenanzahl;
	
	
	//Getter und Setter für ID, Name, Dauer und Personenanzahl
	
	
	public Gericht(int id, String name, int dauer, int personenanzahl) {
		this.id = id;
		this.name = name;
		this.dauer = dauer;
		this.personenanzahl = personenanzahl;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDauer() {
		return dauer;
	}
	
	public int getPersonenanzahl() {
		return personenanzahl;
	}
}
