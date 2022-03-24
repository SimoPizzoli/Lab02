/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Parola;
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
    
    private Map <String,List<String>> dizionario = new TreeMap<String,List<String>>();
    private Parola parolaAliena;
    private List <Parola> listP = new LinkedList<Parola>();

    @FXML
    void handleClear(ActionEvent event) {
    	txtParola.clear();
    	txtTraduzione.clear();
    	txtErrore.setText("");
    }

    @FXML
    void handleTraslate(ActionEvent event) {
    	txtParola.getText().toLowerCase();
    	String parola = txtParola.getText();
    	String c[] = parola.split(" ");
    	
    	if(!dizionario.containsKey(c[0]) && c[0].matches("[a-zA-Z]*")) {
    		parolaAliena = new Parola(c[0]);
    		listP.add(parolaAliena);
    	}
    	else {
    		for(Parola pp : listP)
    			if(pp.getParola().equals(parola)) {
    				parolaAliena = pp;
    			}
    	}		
    	if(c.length == 2) {
    		if(c[0].matches("[a-zA-Z]*") && c[1].matches("[a-zA-Z]*") && !parolaAliena.isDuplicato(c[1])) {
    			parolaAliena.addTraduzione(c[1]);
    			dizionario.put(c[0], parolaAliena.getElencoTraduzioni());		//CAUSA UN EXCEPTION MA NON CAPISCO IL MOTIVO
   				txtTraduzione.setText("Parola correttamente salvata nel dizionario.\n");
   				txtErrore.setText("");
    		}
    		else 
    			txtErrore.setText("Errore. Caratteri NON ammessi e/o traduzione già inserita.");
    	}
    	else {
    		if(parola.matches("[a-zA-Z]*")) {
    			if(dizionario.containsKey(parola)) {
    				String s = "";
    				int contaTrad = 1;
    				for(String ss : parolaAliena.getElencoTraduzioni()) {
    					s+=contaTrad+": "+ss+"\n";
    					contaTrad++;
    				}
    				txtTraduzione.setText(s);
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
