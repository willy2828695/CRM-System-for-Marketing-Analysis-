package model.MarketModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferComparator;

public class MarketSummary {
    Market market;
    
    int totalRevenue;
    int totalAdBudget;
    int totalProfit;
    
    
    public MarketSummary(Market m){
        market = m;
        totalAdBudget = m.getTotalAdBudget();
        totalProfit = m.calculateProfit();
        totalRevenue = m.calculateTotalrevenue();
    }

    public Market getMarket() {
        return market;
    }
    
    

    public int getTotalAdBudget() {
        return totalAdBudget;
    }

    public Map<String, List<SolutionOffer>> productContainSolution(Market market){
        ArrayList<SolutionOffer> so = market.getSolutionOffers();
        Map<String, List<SolutionOffer>> PorductsSolutionMap = new HashMap<>();


        for (SolutionOffer p: so){
            ArrayList<Product> productList = p.getproductsList();
            for (Product pr: productList){
                String productName = pr.getName();

                if (PorductsSolutionMap.containsKey(productName)){
                    PorductsSolutionMap.get(productName).add(p);
            }
                else{
                    List<SolutionOffer> sol = new ArrayList<>();
                    sol.add(p);
                    PorductsSolutionMap.put(productName, sol);
                }
            }
        }
        return PorductsSolutionMap;
    }


    public void printMarketSummary(){
        System.out.println("Market Summary for " + market.getName()+"\n");
        System.out.println("Total Ad Budget: $" + totalAdBudget);
        System.out.println("Total Profit: $" + totalProfit);
        System.out.println("Total Product Revenue: $" + totalRevenue+"\n");
        System.out.println("Products and Solutions Analysis: ");
        Map<String, List<SolutionOffer>> productSolutionMap = productContainSolution(market);
        for (String productName: productSolutionMap.keySet()){
            System.out.println("Product: " + productName+"\n");

            List<SolutionOffer> sol = productSolutionMap.get(productName);
            
            // Sort the solution offers by revenue
            Collections.sort(sol, new SolutionOfferComparator(false));
            System.out.printf("%-20s | %-8s | %-7s | %-6s\n", "Solution Offer", "Revenue", "Ad Budget", "Profit");
            // System.out.println("Solution Offer   | Revenue | Ad Budget | Profit"+ "\n");
            for (SolutionOffer s: sol){
                // System.out.println(s.getName()+ "| $" + s.getRevenue() + "  | $" + s.getgetAdBudget() + " | $" + s.getProfit() +"\n");
                String formattedOutput = String.format("%-20s | $%7d | $%8d | $%5d",
                s.getName(),
                s.getRevenue(),  // Assuming getRevenue() returns an int
                s.getAdBudget(),  // Assuming getAdBudget() returns an int
                s.getProfit());  // Assuming getProfit() returns an int

            System.out.println(formattedOutput);
            }
            System.out.println("-----------------------------------------------------");
        }

    }

    

    
}
