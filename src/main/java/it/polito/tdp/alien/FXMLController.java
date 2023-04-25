/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdt.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Dizionario dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtDictonary;

    @FXML
    private TextField txtWord;

    @FXML
    void handleClTxt(ActionEvent event) {

    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	ArrayList<String> array= new ArrayList<>();

    	String [] arrayInserimenti= txtWord.getText().split(" ");	
    	String chiave= arrayInserimenti[0].toLowerCase();
    	
    	String patternTra = "[a-z A-Z ?]*";
    	String pattern = "[a-z A-Z]*";
    	int spy= occorenze(chiave);
    	
    	
    	
    	if (arrayInserimenti.length==1 && chiave.matches(patternTra) && spy<2) {
    		txtDictonary.setText(dizionario.stampa(chiave));
    	}
    	
    	else if( chiave.matches(patternTra) && spy<2) {
    		for(int i=1;i<arrayInserimenti.length;i++) { 
    			if (arrayInserimenti[i].matches(pattern)) 
    				array.add(arrayInserimenti[i].toLowerCase());
        	}
    		
    		dizionario.add(chiave, array);
    		txtDictonary.setText(dizionario.stampa(chiave));
    	}
    	
    	else {
    		txtDictonary.setText("Nessun risultato");
    	}
    	
    	txtWord.setText("");
    	

    }

    @FXML
    void initialize() {
        assert txtDictonary != null : "fx:id=\"txtDictonary\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dizionario model) {
		this.dizionario=model;
		
	}
	
	public int occorenze(String s) {
		int counter=0;
		for(int i=0;i<s.length();i++) {
			if (s.charAt(i)=='?') 
				counter++;
		}
		return counter;
	}
	
	

}


