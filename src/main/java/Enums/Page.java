package Enums;

public enum Page {
	MAIN("/Layout/MainPage.fxml"),
	FIRST("/Layout/FirstPage.fxml"),
	NEW("/Layout/NewPage.fxml"),
	EDIT("Layout/EditPage.fxml"),
	TRY("https://www.test.de/"),
	VIEW("Layout/ViewPage.fxml");
	
	private String filename;
	
	private Page(String filename) {
		this.filename = filename;
	}
	
	
	public String getFilename() {
		return filename;
	}
	
	
}
