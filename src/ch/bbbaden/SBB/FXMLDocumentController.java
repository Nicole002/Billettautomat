/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.SBB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author nicis
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private RadioButton rbtn1;
    @FXML
    private ToggleGroup zone;
    @FXML
    private RadioButton rbtn2;
    @FXML
    private RadioButton rbtn3;
    @FXML
    private RadioButton rbtn4;
    @FXML
    private RadioButton rbtnGanz;
    @FXML
    private ToggleGroup abo;
    @FXML
    private RadioButton rbtnHalb;
    @FXML
    private Button btnBerechnen;
    @FXML
    private Button btnBezahlen;
    @FXML
    private Label lblBetr;
    @FXML
    private Label lblBezahlen;
    @FXML
    private Button btnDrucken;
    @FXML
    private ListView<String> lvAusgabe;
    
    
    @FXML
    private Label lbl1;
    @FXML
    private TextField tfBetrag;
    
    double endbetrag;
    int counter;
    
    double betrag;
    String summary;
    @FXML
    private AnchorPane rootPane;
    
    
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }   

    @FXML
    private void zoneOne(ActionEvent event) {
        betrag = 2.50;
        lblBezahlen.setText("" + betrag);
        
        if(rbtnHalb.isSelected()){
            betrag = betrag / 2;
            lblBezahlen.setText("" + betrag);
        }
    }

    @FXML
    private void zoneTwo(ActionEvent event) {
        betrag = 5;
        lblBezahlen.setText("" + betrag);
        
        if(rbtnHalb.isSelected()){
            betrag = betrag / 2;
            lblBezahlen.setText("" + betrag);
        }
    }

    @FXML
    private void zoneThree(ActionEvent event) {
        betrag = 7.50;
        lblBezahlen.setText("" + betrag);
        
        if(rbtnHalb.isSelected()){
            betrag = betrag / 2;
            lblBezahlen.setText("" + betrag);
        }
    }

    @FXML
    private void zoneFour(ActionEvent event) {
        betrag = 10;
        lblBezahlen.setText("" + betrag);
        
        if(rbtnHalb.isSelected()){
            betrag = betrag / 2;
            lblBezahlen.setText("" + betrag);
        }
    }

    @FXML
    private void ganz(ActionEvent event) {
         if(rbtn1.isSelected() && betrag == 1.25){
            betrag = betrag * 2;
            lblBezahlen.setText("" + betrag);
        }
         if(rbtn2.isSelected() && betrag == 2.5){
             betrag = betrag * 2;
            lblBezahlen.setText("" + betrag);
         }
         if(rbtn3.isSelected() && betrag == 3.75){
             betrag = betrag * 2;
            lblBezahlen.setText("" + betrag);
         }
         if(rbtn4.isSelected() && betrag == 5){
             betrag = betrag * 2;
            lblBezahlen.setText("" + betrag);
         }
        
        lblBezahlen.setText("" + betrag);
    }

    @FXML
    private void halb(ActionEvent event) {
        betrag = betrag / 2;
        lblBezahlen.setText("" + betrag);
    }

    @FXML
    private void berechnen(ActionEvent event) {
        
            RadioButton selectedRadioButton = (RadioButton) zone.getSelectedToggle();
        summary = selectedRadioButton.getText();
        
        selectedRadioButton = (RadioButton) abo.getSelectedToggle();
        summary = summary + " / " + selectedRadioButton.getText();
        
        lvAusgabe.getItems().add(summary + " / " + betrag);
        
        endbetrag = betrag;
        counter++;
        
        
        
    }

    @FXML
    private void bezahlen(ActionEvent event) {
        double bezahlen;
        String zahl;
        
        
        zahl = tfBetrag.getText();
        bezahlen = Double.valueOf(zahl);
        betrag = betrag - bezahlen;
        lblBezahlen.setText("" + betrag);
        
        
        if(betrag == 0.00){
            lbl1.setText("Beleg bitte drucken. Vielen Dank!");
        }
        if(betrag < 0){
            lbl1.setText("Geld entnehmen und drucken.");
        }
        
        
    }

    @FXML
    private void drucken(ActionEvent event){
        RadioButton selectedRadioButton = (RadioButton) abo.getSelectedToggle();
        
        try{
             
             //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
            Parent root = loader.load();
             
            //Get controller of scene2
            FXML2Controller scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferPreis(endbetrag);
            scene2Controller.transferAbo(selectedRadioButton.getText());
 
            //Show scene 2 in new window            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Second Window");
            stage.show();
             
             
             
        }catch(Exception e){
            System.out.println("oops");   
        }
       
       
        
    }
    
}
