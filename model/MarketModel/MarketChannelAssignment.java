/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {
    
    Market market;
    Channel channel;
    int adBudget;

    public MarketChannelAssignment(Market m, Channel c, int adBudget){
        
        market = m;
        channel = c;
        this.adBudget = adBudget;
        
    }
    
    public String getMarket() {
        return market.getName();
    }
    public Market getMarketObject() {
        return market;
    }
    public Channel getChannelObject() {
        return channel;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String getChannel() {
        return channel.getName();
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public int getAdBudget() {
        return adBudget;
    }

    public void setAdBudget(int adBudget) {
        this.adBudget = adBudget;
    }

   
    
}
