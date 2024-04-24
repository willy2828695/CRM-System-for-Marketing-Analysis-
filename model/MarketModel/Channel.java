/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    String name;
    

    ArrayList<SolutionOffer> so;
    ArrayList<MarketChannelAssignment> masket;

    public Channel(String s) {
        name = s;
        masket = new ArrayList<MarketChannelAssignment>();
        so = new ArrayList<SolutionOffer>();
        
        
    }

    public void addMarketChannelAssignment(MarketChannelAssignment mkca){
        masket.add(mkca);

    }

    public void addSolutionOfferinChannel(SolutionOffer s) {
        so.add(s);
    }
    public ArrayList<SolutionOffer> getSolutionOffers() {
        return so;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int calculateTotalrevenue(){
        int total = 0;
        for (SolutionOffer s: so){
            total += s.getRevenue();
        }
        return total;
    }

    public int getTotalAdBudget(){
        int total = 0;
        for (MarketChannelAssignment m: masket){
            total += m.getAdBudget();
        }
        return total;
    }

    public int getNumberOfSales(){
        return so.size();
    }


}
