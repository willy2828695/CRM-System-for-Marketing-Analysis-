
package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.MarketChannelAssignment;


public class SolutionOffer {
    String name;
    ArrayList<Product> products;
    int price;// floor, ceiling, and target ideas
    MarketChannelAssignment marketChannelComb;
    ArrayList<SolutionOfferItem> SolutionOfferItemList;

    public SolutionOffer(String name, int price, MarketChannelAssignment m) {
        this.name = name;
        this.price = price;
        marketChannelComb = m;
        SolutionOfferItemList = new ArrayList<SolutionOfferItem>();
        products = new ArrayList<Product>();
        m.getMarketObject().addSolutioninMarket(this);
        m.getChannelObject().addSolutionOfferinChannel(this);
    }

    public void addProduct(Product p) {
        products.add(p);
        p.addSolutionOffer(this);
        
    }
    public void addSolutionOfferItem(SolutionOfferItem soi) {
        SolutionOfferItemList.add(soi);
    }

    public void setPrice(int p) {
        price = p;

    }
    public int getPrice() {
        return price;
    }

    public  ArrayList<Product> getproductlist(){
        return products;
    }

    public String getMarket() {
        return marketChannelComb.getMarket();
    }
    
    public String getChannel() {
        return marketChannelComb.getChannel();
    }

    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelComb;
    }

    public int getAdBudget(){
        return marketChannelComb.getAdBudget();
    }

    public String getName() {
        return name;
    }

    public int getRevenue(){
        int revenue = 0;
        for (SolutionOfferItem soi: SolutionOfferItemList){
            revenue += soi.getSolutionOfferItemTotal();
        }
        return revenue;
    }

    public  ArrayList<Product> getproductsList(){
        return products;
    }

    public int getProfit(){
        return getRevenue() - marketChannelComb.getAdBudget();
    }

}
