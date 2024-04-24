package model.MarketModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;


public class MarketCatalog {
    Business business;
    ArrayList<Market> markets;

    public MarketCatalog(Business b) {
        business = b;
        markets = new ArrayList<Market>();
        // System.out.println("Market list initialized. Current size: " + markets.size());
    }

    public Market newMarket(String s) {
        Market m = new Market(s);
        markets.add(m);
        return m;
    }

    public ArrayList<Market> getMarketList() {
        return markets;
    }

    public Market pickRandomMarket(){
        if (markets.size() == 0) return null;
        Random r = new Random();
        int randomIndex = r.nextInt(markets.size());
        return markets.get(randomIndex);
    }

    

}
