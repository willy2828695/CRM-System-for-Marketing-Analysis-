/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Random;
import model.Business.Business;


import model.MarketModel.MarketChannelAssignment;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
     model.Business.Business business;
    ArrayList<SolutionOffer> SolutionOffer; // list of SolutionOffer initially empty

    public SolutionOfferCatalog(Business b) {
        business = b;
        SolutionOffer = new ArrayList<SolutionOffer>(); /// create the list of elements otherwise it is null
    }




    public SolutionOffer newSolutionOffer(String name, int price, MarketChannelAssignment m) {
        SolutionOffer so = new SolutionOffer(name,price, m);
        SolutionOffer.add(so);
        return so;
    }

  

    // public ProductsReport generateProductPerformanceReport(String sortingRule) {
    //     ProductsReport productsReport = new ProductsReport(sortingRule);

    //     for (Product p : products) {

    //         ProductSummary ps = new ProductSummary(p);
    //         productsReport.addProductSummary(ps);
    //     }
    //     return productsReport;
    // }

    public ArrayList<SolutionOffer> getSolutionOfferList() {
        return SolutionOffer;
    }

    public SolutionOffer pickRandomSolutionOffer() {
        if (SolutionOffer.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(SolutionOffer.size());
        return SolutionOffer.get(randomIndex);
    }

    public void printShortInfo() {
        System.out.println("There are " + SolutionOffer.size() + " SolutionOffers in this catalog");
    }
}
