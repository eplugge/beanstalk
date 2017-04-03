/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author eelco
 */
public class MainView {
    String version =  "0.0.1 alpha";
    Stage stage = new Stage();
    Label lblBalance = new Label("Balance:");
    
    /* Constructor method */
    public MainView() {
        /* Establish the root pane */
        GridPane rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setGridLinesVisible(true);
        rootPane.setVgap(10);
        rootPane.setHgap(10);
        
        rootPane.add(lblBalance,1,0,1,1);
        
        /* Construct the scene */
        Scene mainScene = new Scene(rootPane,1024,768);
        stage.setScene(mainScene);
        stage.setTitle("BeanStalk "+version);
        stage.show();
    }
}
