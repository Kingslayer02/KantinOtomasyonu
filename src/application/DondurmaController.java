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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DondurmaController {
	public DondurmaController() {
		baglantı=VeriTabanı.Baglan();
		
	}
    Connection baglantı=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button boom;

    @FXML
    private Button bravo;

    @FXML
    private Button bravoaltın;

    @FXML
    private Button btn_sepet;

    @FXML
    private Button maras;

    @FXML
    private Button nogger;

    @FXML
    private Button oreo;

    @FXML
    private Button snickers;

    @FXML
    private Button toblerone;

    @FXML
    void btn_boom(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Boom'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Boom Boom eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void btn_bravo(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Bravo'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Bravo eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void btn_bravoaltın(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Bravo Gold'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Bravo Gold eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void btn_maras(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Marasim'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Marasim eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void btn_nogger(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Nogger'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Nogger eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void btn_oreo(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Oreo'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Oreo eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }


    @FXML
    void btn_sepet_click(ActionEvent event) {
    	try {
            Stage stage2= new Stage();
            AnchorPane pane2=(AnchorPane) FXMLLoader.load(getClass().getResource("SepetForm.fxml"));
            Scene scene2=new Scene(pane2);
            stage2.setScene(scene2);
            stage2.setOpacity(0.9);
            stage2.setTitle("Sepet");
            stage2.centerOnScreen(); //form sahnenin ort açılsın 
            stage2.getIcons().add(new Image(getClass().getResourceAsStream("Sepeticon.png")));
            stage2.show();
            stage2.setResizable(false);
            }catch(Exception e) {
            	
    			e.printStackTrace();
    		}

    }
    @FXML
    void btn_snickers(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Snickers'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Snickers eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void btn_toblerone(ActionEvent event) {
    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Toblerone'";
    	try {
            sorguIfadesi = baglantı.prepareStatement(sql);
            int guncelleme = sorguIfadesi.executeUpdate();
            System.out.println(guncelleme + " Toblerone eklendi.");
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

    }

    @FXML
    void initialize() {

    }

}
