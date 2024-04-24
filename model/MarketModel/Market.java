/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Random;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {
    
    String name;
    
    ArrayList<SolutionOffer> so;
    ArrayList<MarketChannelAssignment> masket;
    ArrayList<String> characteristics;
    ArrayList<Market> submarkets;
    int size;

    public Market(String s) {
        name = s;
        characteristics = new ArrayList<String>();
        characteristics.add(s);
        masket = new ArrayList<MarketChannelAssignment>();
        so = new ArrayList<SolutionOffer>();
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public void addCharacteristic(String s) {
        characteristics.add(s);
    }
    public void addSolutioninMarket(SolutionOffer s){
        so.add(s);
    }

    public ArrayList<SolutionOffer> getSolutionOffers() {
        return so;
    }

    @Override
    public String toString() {
        return name;
    }
    public void addMarketChannelAssignment(MarketChannelAssignment mkca){
        masket.add(mkca);

    }
    public MarketChannelAssignment pickrandomMarketChannelAssignment(){
        if (masket.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(masket.size());
        return masket.get(randomIndex);
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

    public int calculateProfit(){
        return calculateTotalrevenue() - getTotalAdBudget();
    }
    

}
