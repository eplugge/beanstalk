/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.controllers;

import javafx.event.Event;
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
    
    public MainController(MainModel mM, MainView mV) {
        this.m = mM;
        this.v = mV;
        
        /* Set default calc stage */
        updateStatusLabel(v.getCalcStage());
        
        /* Set the key handler */
        v.setTfKeyHandler(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER)  {
                    v.setCalcStage(v.getCalcStage()+1);
                    /* Update the label */
                    updateStatusLabel(v.getCalcStage());
                    v.setTfInput("");
                }
            }
        });            
    }
    
    private void updateStatusLabel(int i) {
        /* Increase i */
        switch(i) {
            case 1: v.setlblStatus("I'd like to invest the following amount");
                break;
            case 2: v.setlblStatus("I'd like to purchase the following shares");
                break;
            case 3: v.setlblStatus("I'd like to invest the following percentage of my investment");
                break;
            case 4: v.setlblStatus("I'd like to rebalance my portfolio");
                v.setCalcStage(0);
                break;
            default: v.setlblStatus("I'd like to invest the following amount");
                v.setCalcStage(1);
                break;
        }        
    }
}
