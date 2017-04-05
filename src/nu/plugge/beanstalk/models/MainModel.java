/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author eelco
 */
public class MainModel {
    private DoubleProperty investAmount;
    private StringProperty symbol;
    private DoubleProperty percentage;
    private BooleanProperty rebalance;
    
    /* Constructors */
    public MainModel() {  
        this(0.0,"BND",0.0,false);
    }
    
    public MainModel(Double i, String s, Double p, Boolean r) {
        this.investAmount = new SimpleDoubleProperty(i);
        this.symbol = new SimpleStringProperty(s);
        this.percentage = new SimpleDoubleProperty(p);
        this.rebalance = new SimpleBooleanProperty(r);
    }
    
    public Double getInvestAmount(){
        return investAmount.get();
    }
    public String getSymbol(){
        return symbol.get();
    }
    public Double getPercentage(){
        return percentage.get();
    }
    public Boolean getRebalance(){
        return rebalance.get();
    }
    public void setInvestAmount(Double d){
        investAmount.set(d);
    }
    public void setSymbol(String s){
        symbol.set(s);
    }
    public void setPercentage(Double d){
        percentage.set(d);
    }
    public void setBoolean(Boolean b){
        rebalance.set(b);
    }
    public Double calcInvestmentInCurrency(){
        Double res = (this.investAmount.get() / 100.00) * this.percentage.get();
        //
        return res;
    }
}
