/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.plugge.beanstalk.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author eelco
 */
public class InvestModel {
    private final SimpleStringProperty symbol;
    private final SimpleDoubleProperty percentage;
    private final SimpleBooleanProperty rebalance;
    private final SimpleDoubleProperty shares;
    
    public InvestModel(String symbol, Double percentage, Boolean rebalance, Double shares) {
        this.symbol = new SimpleStringProperty(symbol);
        this.percentage = new SimpleDoubleProperty(percentage);
        this.rebalance = new SimpleBooleanProperty(rebalance);
        this.shares = new SimpleDoubleProperty(shares);
    }
    
    public String getSymbol() {
        return symbol.get();
    }
    
    public Double getPercentage() {
        return percentage.get();
    }
    
    public Boolean getRebalance() {
        return rebalance.get();
    }
    
    public Double getShares() {
        return shares.get();
    }
    
    public void setSymbol(String s) {
        symbol.set(s);
    }
    
    public void setPercentage(Double d){
        percentage.set(d);
    }
    
    public void setBoolean(Boolean b){
        rebalance.set(b);
    }
    
    public void setShares(Double d) {
        shares.set(d);
    }
}
