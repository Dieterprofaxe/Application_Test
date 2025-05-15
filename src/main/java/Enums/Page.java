package Enums;

public enum Page {
	MAIN("/Layout/MainPage.fxml"),
	FIRST("/Layout/FirstPage.fxml");
	
	private String filename;
	
	private Page(String filename) {
		this.filename = filename;
	}
	
	
	public String getFilename() {
		return filename;
	}
	
	
}
