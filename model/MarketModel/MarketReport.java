package model.MarketModel;

import java.util.ArrayList;

public class MarketReport {
    ArrayList<MarketSummary> marketSummaries;

    public MarketReport() {
        marketSummaries = new ArrayList<MarketSummary>();
    }

    public void addMarketSummary(MarketSummary ms) {
        marketSummaries.add(ms);
    }

    public void printMarketReport(){
        System.out.println("Market Report:");
        for (MarketSummary ms: marketSummaries){
            ms.printMarketSummary();
            System.out.println("=====================================================");
        }
    }

}
