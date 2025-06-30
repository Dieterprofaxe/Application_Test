package Enums;

public enum Page {
	//Hier wird einfach nur der PFad zu den einzelnen Seiten angegeben damit man aus anderen KLassen die Seiten Starten oder wechseln kann
	
	MAIN("/Layout/MainPage.fxml"),
	FIRST("/Layout/FirstPage.fxml"),
	NEW("/Layout/NewPage.fxml"),
	EDIT("Layout/EditPage.fxml"),
	PREPARE("/Layout/PreparePage.fxml"),
	OVERVIEW("/Layout/OverviewPage.fxml"),
	BEARBEITEN("/Layout/bearbeiten.fxml"),
	START("/Layout/StartPage.fxml"),
	ERROR("/Layout/ErrorPage.fxml"),
	NAME("/Layout/EnterNamePage.fxml");
	
	private String filename;
	
	private Page(String filename) {
		this.filename = filename;
	}
	
	
	public String getFilename() {
		return filename;
	}
	
	
}
