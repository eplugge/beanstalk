/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.views;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author eelco
 */
public class MainView {
    String version =  "0.0.1 alpha";
    Stage stage = new Stage();
    
    /* Constructor method */
    public MainView() {
        GridPane rootPane, inputPane, holdingsPane;
        rootPane = new GridPane();
        inputPane = new GridPane();
        holdingsPane = new GridPane();
        
        /* Define root pane properties */
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setGridLinesVisible(true);
        rootPane.setVgap(20);
        rootPane.setHgap(20);
        
        ColumnConstraints inputColumn = new ColumnConstraints();
        inputColumn.setPercentWidth(100);
        ColumnConstraints holdingsColumn = new ColumnConstraints();
        holdingsColumn.setPercentWidth(100);
        rootPane.getColumnConstraints().addAll(inputColumn,holdingsColumn);
        
        /* Establish the input pane, to be added as a child to rootPane */
        Label lblToSpend = new Label("I'd like to spend:");
        TextField tfSpendInput = new TextField();        
        
        
        inputPane.add(lblToSpend,0,0);
        inputPane.add(tfSpendInput,0,1);
        

        
        
        
        
        /* Construct the scene */
        rootPane.add(inputPane,0,0);
        rootPane.add(holdingsPane,0,1);
        
        Scene mainScene = new Scene(rootPane,500,700);
        stage.setScene(mainScene);
        stage.setTitle("BeanStalk "+version);
        stage.show();
    }
}
