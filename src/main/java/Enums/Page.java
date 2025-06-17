package Enums;

public enum Page {
	MAIN("/Layout/MainPage.fxml"),
	FIRST("/Layout/FirstPage.fxml"),
	NEW("/Layout/NewPage.fxml"),
	EDIT("Layout/EditPage.fxml"),
	PREPARE("/Layout/PreparePage.fxml"),
	OVERVIEW("/Layout/OverviewPage.fxml"),
	BEARBEITEN("/Layout/bearbeiten.fxml"),
	NAME("/Layout/EnterNamePage.fxml");
	
	private String filename;
	
	private Page(String filename) {
		this.filename = filename;
	}
	
	
	public String getFilename() {
		return filename;
	}
	
	
}
