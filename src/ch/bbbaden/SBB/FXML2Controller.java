/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.SBB;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author nicis
 */
public class FXML2Controller implements Initializable {

    @FXML
    private Label lblAbo;
    @FXML
    private Label lblPreis;
    
    double preis;
    String message;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void transferAbo(String message){
        this.message = message;
        lblAbo.setText(message);
    }
    
    public void transferPreis(double preis){
        this.preis = preis;
        lblPreis.setText(preis + " ");
    }
    
}
