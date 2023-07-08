package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.MySQL.Util.VeriTabanı;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class AdminEklemeController {
	public AdminEklemeController(){
		baglantı=VeriTabanı.Baglan();
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_sil;


    @FXML
    private TextField txt_kul;

    @FXML
    private PasswordField txt_parola;
    Connection baglantı=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    

    @FXML
    void btn_ekle_click(ActionEvent event) {
    	sql="insert into  kullanıcılar(Kullanıcıadı,Parola) values(?,?)";
    	try {
			sorguIfadesi=baglantı.prepareStatement(sql);
			sorguIfadesi.setString(2, txt_parola.getText().trim());
			sorguIfadesi.setString(1, txt_kul.getText().trim());
			sorguIfadesi.executeUpdate();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Başarılı");
	        alert.setHeaderText(null);
	        alert.setContentText("Kullanıcı Ekleme İşlemi Başarıyla Gerçekleşti");

	        alert.showAndWait();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		
    }
    }
    

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	sql="Update kullanıcılar set Parola=? WHERE Kullanıcıadı=?";
    	try {
			sorguIfadesi=baglantı.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_parola.getText().trim());
			sorguIfadesi.setString(2, txt_kul.getText().trim());
			sorguIfadesi.executeUpdate();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Başarılı");
	        alert.setHeaderText(null);
	        alert.setContentText("Kullanıcı Güncelleme İşlemi Başarıyla Gerçekleşti");

	        alert.showAndWait();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		
    }



    }

    @FXML
    void btn_sil_click(ActionEvent event) {
    	sql="delete from kullanıcılar where Kullanıcıadı=? and Parola=?";
    	try {
			sorguIfadesi=baglantı.prepareStatement(sql);
			sorguIfadesi.setString(2, txt_parola.getText().trim());
			sorguIfadesi.setString(1, txt_kul.getText().trim());
			sorguIfadesi.executeUpdate();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Başarılı");
	        alert.setHeaderText(null);
	        alert.setContentText("Kullanıcı Silme İşlemi Başarıyla Gerçekleşti");

	        alert.showAndWait();
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }
    


    @FXML
    void initialize() {
        

    }

}
