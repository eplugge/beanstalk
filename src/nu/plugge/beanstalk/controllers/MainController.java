/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.controllers;

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
        
    }
}
