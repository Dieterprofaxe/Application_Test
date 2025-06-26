package Controller;

import java.sql.Connection;
import java.sql.SQLException;

import PageSwitching.PageSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StartPageController  {

	private int gerichtID;
	
   public void page_loader(int gerichtID) {
	   this.gerichtID = gerichtID;
	   
	   System.out.println(gerichtID);
   }

public void page_Loader(int gerichtID) {
	
	this.gerichtID = gerichtID;
	try(Connection conn = DBConnection.getConnection()){
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}