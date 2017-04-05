/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import nu.plugge.beanstalk.models.MainModel;
import nu.plugge.beanstalk.views.MainView;

/**
 *
 * @author eelco
 */
public class MainController {
    private MainView v;
    private MainModel m;
    double totalPercentage = 0.0;
    
    public MainController(MainModel mM, MainView mV) {
        this.m = mM;
        this.v = mV;
        ObservableList<MainModel> tableData = FXCollections.observableArrayList();
        
        
        /* Set default calc stage */
        v.setlblStatus(v.getCalcStage());
        
        /* Set the key handler */
        v.setTfKeyHandler(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER)  {
                    switch(v.getCalcStage()) {
                        case 0:
                            m.setInvestAmount(Double.parseDouble(v.getTfInput()));
                            v.setCalcStage(v.getCalcStage()+1);
                            v.setlblStatus(v.getCalcStage());
                            v.setTfInput("");
                            break;
                        case 1:
                            m.setSymbol(v.getTfInput());
                            v.setCalcStage(v.getCalcStage()+1);
                            v.setlblStatus(v.getCalcStage());
                            v.setTfInput("");                            
                            break;
                        case 2:
                            if(totalPercentage + (Double.parseDouble(v.getTfInput())) > 100.0) {
                                System.out.println("Investing " + totalPercentage);
                                v.setlblException("You can't invest over 100%, silly.");
                                v.setTfInput("");
                            } else {
                                totalPercentage += Double.parseDouble(v.getTfInput());
                                m.setPercentage(Double.parseDouble(v.getTfInput()));
                                v.setCalcStage(v.getCalcStage()+1);
                                v.setlblStatus(v.getCalcStage());
                                v.setTfInput("");
                            }
                            break;
                        case 3:
                            /* Silly hack */
                            m.setBoolean(Boolean.TRUE);
                            /* Check if we completed the cycle */
                            if(totalPercentage!=100.0) {
                                v.setCalcStage(1);
                            }else{
                                v.setCalcStage(0);
                                totalPercentage=0.0;
                                /* We're done */
                                // implement api handling http://finance.yahoo.com/d/quotes.csv?s=BND&f=o
                            }
                            v.setlblStatus(v.getCalcStage());
                            v.setTfInput("");
                            tableData.add(m);
                            v.setTable(tableData);
                            m=new MainModel();
                            break;
                    }
                }
            }
        });            
    }
    
}
