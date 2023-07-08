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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;

public class AtıstırmalıklarFormController {
	public AtıstırmalıklarFormController() {
		baglantı=VeriTabanı.Baglan();
	}
	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button albeni;

	    @FXML
	    private Button brovni;

	    @FXML
	    private Button btn_sepet;

	    @FXML
	    private Button cin;

	    @FXML
	    private Button cocostar;

	    @FXML
	    private Button halley;

	    @FXML
	    private Button ikram;

	    @FXML
	    private Button nero;

	    @FXML
	    private Button popcorn;

	    @FXML
	    private Button sutburger;

	    @FXML
	    private Button tutku;

	    @FXML
	    void btn_albeni(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Albeni'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Albeni eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_brovni(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Browni visneli kek'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Browni eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_cin(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Eti cin biskuvi'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Eti cin eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_cocostar(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Cocostar biskuvi'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Cocostar eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_halley(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Halley'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Halley eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_ikram(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='İkram'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " İkram eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_nero(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Nero'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Nero eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_popcorn(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Patlamis misir'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Pmısır eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	
	
        
	    Connection baglantı=null;
	    PreparedStatement sorguIfadesi=null;
	    ResultSet getirilen=null;
	    String sql;
	    

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
	    void btn_sutburger(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Sut burger'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Sut Burger eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }

	    @FXML
	    void btn_tutku(ActionEvent event) {
	    	sql="INSERT INTO sepet (Fiyat, Urun) SELECT Fiyat, Urun FROM admin Where Urun='Eti Tutku'";
	    	try {
	            sorguIfadesi = baglantı.prepareStatement(sql);
	            int guncelleme = sorguIfadesi.executeUpdate();
	            System.out.println(guncelleme + " Tutku eklendi.");
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());
			}

	    }


    @FXML
    void initialize() {

    }

}
