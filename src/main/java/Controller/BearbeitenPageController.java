package Controller;


import javafx.fxml.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Enums.Page;
import PageSwitching.PageSwitcher;
import javafx.scene.control.TextField;

public class BearbeitenPageController {
	
	private static final String URL = "jdbc:mysql://localhost:3306/meinedb?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	
	@FXML
	private TextField name, durationField, personenField, zutatField1, zutatField2, zutatField3,
	zutatField4, zutatField5, zutatField6, zutatField7, zutatField8, zutatField9, zutatField10,
	zutatField11, zutatField12, zutatField13, zutatField14, zutatField15, zutatField16, zutatField17,
	zutatField18, zutatField19, zutatField20, zutatField21, zutatField22, zutatField23, zutatField24,
	zutatField25, zutatField26, zutatField27, zutatField28, zutatField29, zutatField30,
	
	
	
	
	stepField1, stepField2, stepField3, stepField4, stepField5, stepField6, stepField7, stepfield8,
	stepField9, stepField10, stepField11, stepField12, stepField13, stepField14, stepField15, stepField16,
	stepField17, stepField18, stepField19, stepField20, stepField21, stepField22, stepField23,
	stepField24, stepField25, stepField26, stepField27, stepField28, stepField29, stepField30;  
	
	
	
	
	
	@FXML
	public void BearbeitenPageController(TextField name, TextField durationField, TextField personenField, TextField zutatField1, TextField zutatField2, TextField zutatField3, TextField zutatField4, TextField zutatField5, TextField zutatField6, TextField zutatField7, TextField zutatField8, TextField zutatField9, TextField zutatField10, TextField zutatField11, TextField zutatField12, 
			TextField zutatField13, TextField zutatField14, TextField zutatField15, TextField zutatField16, TextField zutatField17, TextField zutatField18, TextField zutatField19, TextField zutatField20, TextField zutatField21, TextField zutatField22, TextField zutatField23,
			TextField zutatField24, TextField zutatField25, TextField zutatField26, TextField zutatField27, TextField zutatField28, TextField zutatField29, TextField zutatField30, TextField stepField1, TextField stepField2, TextField stepField3, TextField stepField4, TextField stepField5, TextField stepField6, TextField stepField7, TextField stepField8, TextField stepField9,
			TextField stepField10, TextField stepField11, TextField stepField12, TextField stepField13, TextField stepField14, TextField stepField15, TextField stepField16, TextField stepField17, TextField stepField18, TextField stepField19, TextField stepField20, TextField stepField21, TextField stepField22,TextField stepField23, TextField stepField24, 
			TextField stepField25, TextField stepField26, TextField stepField27, TextField stepField28, TextField stepField29, TextField stepField30) {
		this.name = name;							this.zutatField11 = zutatField11;		this.zutatField24 = zutatField24;		this.stepField1 = stepField7;		this.stepField1 = stepField20;
		this.durationField = durationField;			this.zutatField12 = zutatField12;		this.zutatField25 = zutatField25;		this.stepField1 = stepField8;		this.stepField1 = stepField21;
		this.personenField = personenField;			this.zutatField13 = zutatField13;		this.zutatField26 = zutatField26;		this.stepField1 = stepField9;		this.stepField1 = stepField22;
		this.zutatField1 = zutatField1;				this.zutatField14 = zutatField14;		this.zutatField27 = zutatField27;		this.stepField1 = stepField10;		this.stepField1 = stepField23;
		this.zutatField2 = zutatField2;				this.zutatField15 = zutatField15;		this.zutatField28 = zutatField28;		this.stepField1 = stepField11;		this.stepField1 = stepField24;
		this.zutatField3 = zutatField3;				this.zutatField16 = zutatField16;		this.zutatField29 = zutatField29;		this.stepField1 = stepField12;		this.stepField1 = stepField25;
		this.zutatField4 = zutatField4;				this.zutatField17 = zutatField17;		this.zutatField30 = zutatField20;		this.stepField1 = stepField13;		this.stepField1 = stepField26;
		this.zutatField5 = zutatField5;				this.zutatField18 = zutatField18;		this.stepField1 = stepField1;			this.stepField1 = stepField14;		this.stepField1 = stepField27;
		this.zutatField6 = zutatField6;				this.zutatField19 = zutatField19;		this.stepField2 = stepField2;			this.stepField1 = stepField15;		this.stepField1 = stepField28;
		this.zutatField7 = zutatField7;				this.zutatField20 = zutatField20;		this.stepField3 = stepField3;			this.stepField1 = stepField16;		this.stepField1 = stepField29;
		this.zutatField8 = zutatField8;				this.zutatField21 = zutatField21;		this.stepField4 = stepField4;			this.stepField1 = stepField17;		this.stepField1 = stepField30;
		this.zutatField9 = zutatField9;				this.zutatField22 = zutatField22;		this.stepField5 = stepField5;			this.stepField1 = stepField18;		
		this.zutatField10 = zutatField10;			this.zutatField23 = zutatField23;		this.stepField6 = stepField6;			this.stepField1 = stepField19;				
		
	}
	

	@FXML
	private void back() {
		PageSwitcher.switchTo(Page.OVERVIEW);
	}


	@FXML
	public void page_loader(int id) {
		
		String sqlName = "SELECT name FROM gerichte WHERE id = ?";
		String sqlDauer = "SELECT dauer FROM gerichte WHERE id = ?";
		String sqlPersonen = "SELECT personenanzahl FROM gerichte WHERE id = ?";
		String sqlZutatenBezeichnung = "SELECT bezeichnung FROM zutaten WHERE gericht_id = ?";
		System.out.println(id);
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		     PreparedStatement pstmt = conn.prepareStatement(sqlName);
		     PreparedStatement pstmt1 = conn.prepareStatement(sqlDauer);
			 PreparedStatement pstmt2 = conn.prepareStatement(sqlPersonen);
			 PreparedStatement pstmt3 = conn.prepareStatement(sqlZutatenBezeichnung);
			 PreparedStatement pstmt4 = conn.prepareStatement(sqlZutatenBezeichnung)){
			
			
			pstmt.setInt(1, id);
			pstmt1.setInt(1, id);
			pstmt2.setInt(1, id);
			pstmt3.setInt(1, id);
			
			
			try (ResultSet rs = pstmt.executeQuery();
				ResultSet rs1 = pstmt1.executeQuery(); 
				ResultSet rs2 = pstmt2.executeQuery();
				ResultSet rs3 = pstmt3.executeQuery()){
				if (rs.next()&& rs1.next()&& rs2.next()&& rs3.next()) {
					String gerichtName = rs.getString("name");
					int gerichtDauer = rs1.getInt("dauer");
					int gerichtPersonen = rs2.getInt("personenanzahl");
					String gerichtBezeichnung = rs3.getString("bezeichnung");
					name.setText(gerichtName);
					durationField.setText(String.valueOf(gerichtDauer));
					personenField.setText(String.valueOf(gerichtPersonen));
				} else {
					name.setText("Kein Gericht gefunden");
					durationField.setText("Kein Gericht gefunden");
					personenField.setText("Kein Gericht gefunden");
				
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			name.setText("Fehler beim Laden aus der Datenbank");
			durationField.setText("Fehler beim Laden aus der Datenbank");
			personenField.setText("Fehler beim Laden aus der Datenbank");
		}
	}
}