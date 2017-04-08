/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.views;

import javafx.collections.ObservableList;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import nu.plugge.beanstalk.models.MainModel;

/**
 *
 * @author eelco
 */
public class MainView {
    String version =  "0.0.1 alpha";
    Stage stage = new Stage();
    Label lblStatus;
    TextField tfInput;
    TableView investTable;
    int calcStage = 0;
    
    /* Constructor method */
    public MainView() {
        /* Define Column Constraints */
        ColumnConstraints rootCC10, rootCC80;
        rootCC10 = new ColumnConstraints();
        rootCC10.setPercentWidth(5);
        rootCC80 = new ColumnConstraints();
        rootCC80.setPercentWidth(90);
        
        /* Define Row Constraints */
        RowConstraints rootRC5, rootRC35, rootRC55;
        rootRC5 = new RowConstraints();
        rootRC5.setPercentHeight(5);
        rootRC35 = new RowConstraints();
        rootRC35.setPercentHeight(35);
        rootRC55 = new RowConstraints();
        rootRC55.setPercentHeight(55);
        
        /* Initialize gridpane objects */
        GridPane rootPane, inputPane, holdingsPane;
        rootPane = new GridPane();
        inputPane = new GridPane();
        holdingsPane = new GridPane();

        /* Define root pane properties */
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setGridLinesVisible(true);
        rootPane.setVgap(10);
        rootPane.setHgap(10);
        
        /* Define root pane layout */
        rootPane.getRowConstraints().addAll(rootRC5,rootRC55,rootRC35,rootRC5);
        rootPane.getColumnConstraints().addAll(rootCC10,rootCC80,rootCC10);
        
        /* Input Pane
        *   This pane is used to hold the calculator-part of the app.
        *   Pane will be positioned on top, and will be a child of the root
        *   pane.
        */
        
        /* Define input pane properties */
        inputPane.setGridLinesVisible(true);        
        
        /* Define Constraints */
        ColumnConstraints inputCC100 = new ColumnConstraints();
        inputCC100.setPercentWidth(100);
        RowConstraints inputRC5, inputRC10, inputRC20, inputRC30, inputRC40, inputRC50;
        inputRC5 = new RowConstraints();
        inputRC5.setPercentHeight(5);
        inputRC10 = new RowConstraints();
        inputRC10.setPercentHeight(10);        
        inputRC20 = new RowConstraints();
        inputRC20.setPercentHeight(20);
        inputRC30 = new RowConstraints();
        inputRC30.setPercentHeight(30);        
        inputRC40 = new RowConstraints();
        inputRC40.setPercentHeight(40);        
        inputRC50 = new RowConstraints();
        inputRC50.setPercentHeight(50);
        
        /* Define input pane layout */
        inputPane.getRowConstraints().addAll(inputRC20,inputRC20,inputRC10,inputRC40);
        inputPane.getColumnConstraints().addAll(inputCC100);
        
        /* Define input pane objects */
        lblStatus = new Label();
        tfInput = new TextField();
        investTable = new TableView();
        TableColumn investTableSymbol, investTablePercentage, investTableCorrectExisting, investTableShares;
        
        /* Define invest table data */ 
        investTableSymbol = new TableColumn("Symbol");
        investTablePercentage = new TableColumn("Percentage");
        investTableCorrectExisting = new TableColumn("Rebalance");
        investTableShares = new TableColumn("Shares to Buy");
        investTable.getColumns().addAll(investTableSymbol,investTablePercentage,investTableCorrectExisting, investTableShares);
        
        investTableSymbol.setCellValueFactory(new PropertyValueFactory<MainModel, String>("symbol"));
        investTablePercentage.setCellValueFactory(new PropertyValueFactory<MainModel, Double>("percentage"));
        investTableCorrectExisting.setCellValueFactory(new PropertyValueFactory<MainModel, Boolean>("rebalance"));
        investTableShares.setCellValueFactory(new PropertyValueFactory<MainModel, Integer>("toBuy"));
        
        
        /* Style input pane's objects */
        lblStatus.setAlignment(Pos.CENTER);
        lblStatus.setMaxWidth(Double.MAX_VALUE);
        lblStatus.setFont(new Font("Arial", 20));        
        tfInput.setMaxWidth(Double.MAX_VALUE);
        tfInput.setMaxHeight(Double.MAX_VALUE);
        tfInput.setFont(new Font("Arial", 40)); 
        tfInput.setAlignment(Pos.CENTER);
        investTable.setEditable(true);
  
        inputPane.add(lblStatus,0,0,1,1);
        inputPane.add(tfInput,0,1,1,1);
        inputPane.add(investTable,0,3,1,1);
        

        /* Holdings Pane
        *   This pane is used to hold the current stock holdings of the user.
        *   Pane will be positioned at the bottom, and will be a child of the root
        *   pane.
        */        
        Label lblPortfolio = new Label("Portfolio Overview");
        TableView holdingsTable = new TableView();
        TableColumn holdingsTableSymbol, holdingsTableNoShares,holdingsTableInvestment,holdingsTableNoTrades,holdingsTablePercentage;
        holdingsTableSymbol = new TableColumn("Symbol");
        holdingsTableNoShares = new TableColumn("No. Shares");
        holdingsTableInvestment = new TableColumn("Invested");
        holdingsTableNoTrades = new TableColumn("Trades");
        holdingsTablePercentage = new TableColumn("%");
        holdingsTable.getColumns().addAll(holdingsTableSymbol,holdingsTableNoShares,holdingsTablePercentage);
        
        holdingsPane.add(lblPortfolio,0,0,1,1);
        holdingsPane.add(holdingsTable,0,1,1,1);
        
        /* Construct the scene */
        rootPane.add(inputPane,1,1);
        rootPane.add(holdingsPane,1,2);
        
        Scene mainScene = new Scene(rootPane,500,700);
        stage.setScene(mainScene);
        stage.setTitle("BeanStalk "+version);
        stage.show();
    }

    
    public void setlblStatus(int i) {
        switch(i) {
            case 0: lblStatus.setText("I'd like to invest the following amount");
                break;
            case 1: lblStatus.setText("I'd like to purchase the following shares");
                break;
            case 2: lblStatus.setText("I'd like to invest the following percentage of my investment");
                break;
            case 3: lblStatus.setText("I'd like to rebalance my portfolio");
                break;
        }         
    }
    
    public void setlblException(String s){
        lblStatus.setText(s);
    }
    
    public String getTfInput(){
        return tfInput.getText();
    }       
    
    public void setTfInput(String s){
        tfInput.setText(s);
    }

    public void setTfKeyHandler(EventHandler<KeyEvent> e) {
        tfInput.setOnKeyPressed(e);
    }
    
    public void setCalcStage(int i){
        calcStage=i;
    }
    
    public int getCalcStage(){
        return calcStage;
    }
    
    public void setTable(ObservableList<MainModel> l){
        investTable.setItems(l);
        investTable.refresh();
    }   
            
}
