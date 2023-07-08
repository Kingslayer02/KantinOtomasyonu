package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.MySQL.Util.VeriTabanı;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class AdminPanelFormController {
	public AdminPanelFormController() {
		baglantı=VeriTabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button btn_adminekleme;
    
    @FXML
    private Button btn_yenile;

    @FXML
    private Button btn_cıkıs;

    @FXML
    private Button btn_guncelle;

    @FXML
    private TableView<KayitlarAdmin> table1;
    
    @FXML
    private TextField txt_fiyat; 

    @FXML
    private Label lbl_urun;

    @FXML
    private TextField txt_stokdurum;

    @FXML
    private TableColumn<KayitlarAdmin, Integer> table_fiyat;

    @FXML
    private TableColumn<KayitlarAdmin, String> table_stokdrm;

    @FXML
    private TableColumn<KayitlarAdmin, String> table_urun;
    
    Connection baglantı=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;


    @FXML
    void btn_cıkıs_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.WARNING);
    	alert.setTitle("Çıkış");
    	alert.setHeaderText("Çıkış Yapmak İstediğinize Emin Misiniz?");
    	ButtonType btn=new ButtonType("Evet",ButtonData.OK_DONE);
    	ButtonType btn1=new ButtonType("Hayır",ButtonData.CANCEL_CLOSE);
    	alert.getButtonTypes().setAll(btn,btn1);
    	Optional<ButtonType> tıklama=alert.showAndWait();
    	if(tıklama.get()==btn){
    		System.exit(0);
    		
    	}

    }
    
    public void DegerleriGoster(TableView tablo) {
    	sql="select * from admin";
    	ObservableList<KayitlarAdmin> KayitlarListe=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglantı.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while(getirilen.next()) {
    			KayitlarListe.add(new KayitlarAdmin(getirilen.getString("Urun"),getirilen.getInt("Fiyat"),getirilen.getInt("StokDurumu")));
    			
    		}
    		table_urun.setCellValueFactory(new PropertyValueFactory<>("Urun"));
    		table_fiyat.setCellValueFactory(new PropertyValueFactory<>("Fiyat"));
    		table_stokdrm.setCellValueFactory(new PropertyValueFactory<>("StokDurumu"));
    		table1.setItems(KayitlarListe);
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			
		}
    }
    
    @FXML
    void table_click(MouseEvent event) {
    	KayitlarAdmin kayıt=new KayitlarAdmin();
    	kayıt=(KayitlarAdmin) table1.getItems().get(table1.getSelectionModel().getSelectedIndex());
    	lbl_urun.setText(kayıt.getUrun());
    	txt_stokdurum.setText(String.valueOf(kayıt.getStokDurumu()));
    	txt_fiyat.setText(String.valueOf(kayıt.getFiyat()));

    	
    }
    
    @FXML
    void btn_yenile_click(ActionEvent event) {
    	DegerleriGoster(table1);
    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	KayitlarAdmin secilikayıt=table1.getSelectionModel().getSelectedItem();
    	if(secilikayıt!=null) {   //secili kayıtın null olup olmadığını kontrol ediyoruz
    		 String urunAdi = secilikayıt.getUrun();

    	        sql = "UPDATE admin SET Fiyat=?, StokDurumu=? WHERE Urun=?";
    	        try {
    	            sorguIfadesi = baglantı.prepareStatement(sql);
    	            sorguIfadesi.setString(1, txt_fiyat.getText().trim());
    	            sorguIfadesi.setString(2, txt_stokdurum.getText().trim());
    	            sorguIfadesi.setString(3, urunAdi);
    	            sorguIfadesi.executeUpdate();

    	        } catch (Exception e) {
    	            System.out.println(e.getMessage().toString());
    	        }
    	    }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Güncelleme Başarılı");
        alert.setHeaderText(null);
        alert.setContentText("Güncelleme İşlemi Başarılı!!");
    	}
    	

    @FXML
    void btn_adminekleme_click(ActionEvent event) {
    	try {

			Stage stage=new Stage();
			AnchorPane pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AdminEkleme.fxml"));
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("adminicon.png")));
			stage.setTitle("ADMİN EKLEME");	
			stage.show();
			
			stage.setResizable(false);
			

			

		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	DegerleriGoster(table1);
        
    }

}
