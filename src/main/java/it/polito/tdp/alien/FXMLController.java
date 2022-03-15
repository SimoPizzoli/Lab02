/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label txtErrore;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtTraduzione;
    
    private Map <String,String> dizionario = new TreeMap<String,String>();

    @FXML
    void handleClear(ActionEvent event) {
    	txtParola.clear();
    	txtTraduzione.clear();
    	txtErrore.setText("");
    }

    @FXML
    void handleTraslate(ActionEvent event) {
    	String parola = txtParola.getText();
    	parola.toLowerCase();
    	String c[] = parola.split(" ");
    	if(c.length == 2) {
    		if(c[0].matches("[a-zA-Z]*") && c[1].matches("[a-zA-Z]*")) {
   				dizionario.put(c[0], c[1]);
   				txtTraduzione.setText("Parola correttamente salvata nel dizionario.\n");
   				txtErrore.setText("");
    		}
    		else 
    			txtErrore.setText("Errore. Caratteri NON ammessi");
    	}
    	else {
    		if(parola.matches("[a-zA-Z]*")) {
    			if(dizionario.containsKey(parola)) {
    				txtTraduzione.setText(dizionario.get(parola));
    				txtErrore.setText("");
    			}
    			else
    				txtErrore.setText("Errore. Inserire nella forma <parola aliena>_<traduzione>");
    		}
    		else
    			txtErrore.setText("Errore. Caratteri NON ammessi");
    	}
    	txtParola.clear();
    }  		

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }

}
