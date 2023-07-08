package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.MySQL.Util.VeriTabanı;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class GirisFormController {
	public GirisFormController() {
		baglantı=VeriTabanı.Baglan();
	}


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;  

    @FXML
    private AnchorPane anchor_giriş;
    
    @FXML
    private Label lbl_hata;

    @FXML
    private Button btn_lgn;

    @FXML
    private Button btn_order;

    @FXML
    private TextField txt_Kul;

    @FXML
    private PasswordField txt_Parola;
    Connection baglantı=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    


    @FXML
    void btn_lgn_click(ActionEvent event) {

    	sql="select * from kullanıcılar where Kullanıcıadı=? and Parola=?";
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		sorguIfadesi.setString(1, txt_Kul.getText().trim());
    		sorguIfadesi.setString(2, txt_Parola.getText().trim());
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		if(!getirilen.next()) {
              
    			if(txt_Kul.getText().isEmpty()) {
    		        Alert alert = new Alert(Alert.AlertType.ERROR);
    		        alert.setTitle("HATA");
    		        alert.setHeaderText(null);
    		        alert.setContentText("Kullanıcı Adı ve Parola Kısmı Boş Bırakılamaz");

    		        alert.showAndWait();
    				
    			}
    			else {
    		        Alert alert = new Alert(Alert.AlertType.ERROR);
    		        alert.setTitle("HATA");
    		        alert.setHeaderText(null);
    		        alert.setContentText("Kullanıcı Adı veya Parola Hatalı");

    		        alert.showAndWait();

    			}
    	}
    
    		else {
    	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	        alert.setTitle("Başarılı");
    	        alert.setHeaderText(null);
    	        alert.setContentText("Giriş Başarılı Yönlendiriliyorsunuz...");

    	        alert.showAndWait();
    			try {
    	    		Node source = (Node) event.getSource();
    	    		Stage currentStage = (Stage) source.getScene().getWindow();
        			Stage stage=new Stage();
        			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AdminPanelForm.fxml"));
        			Scene scene = new Scene(pane);
        			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        			stage.setScene(scene);
        			stage.getIcons().add(new Image(getClass().getResourceAsStream("adminicon.png")));
        			stage.setTitle("ADMİN PANEL");	
        			stage.show();
        			currentStage.close();
        			stage.setResizable(false);
        			

        			

        		} catch(Exception e) {
        			e.printStackTrace();
        		}
    		}
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage().toString());
    		
    	}

    		

    }

    @FXML
    void btn_order_click(ActionEvent event) {
    	try {
    		Node source = (Node) event.getSource();
    		Stage currentStage = (Stage) source.getScene().getWindow();

			Stage stage=new Stage();
			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("UrunForm.fxml"));
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("Otomasyon.png")));
			stage.setTitle("Ürünler");
			stage.show();
			currentStage.close();
			stage.setResizable(false);
			
			

			

		} catch(Exception e) {
			e.printStackTrace();
		}


    	
    }


    



    
    @FXML
    void initialize() {


    }

}
