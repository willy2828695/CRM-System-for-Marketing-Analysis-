/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;

import model.MarketModel.ChannelCatalog;
import model.CustomerManagement.CustomerDirectory;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.MasterSolutionOderList;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;
import model.MarketModel.MarketCatalog;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory;
    MasterOrderList masterorderlist;
    SupplierDirectory suppliers;
    MarketCatalog marketCatalog;
    ChannelCatalog channelcatalog;
    SolutionOfferCatalog solutionoffercatalog;
    MasterSolutionOderList mastersolutionorderlist;

    CustomerDirectory customerdirectory;
    EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;
    

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        marketCatalog = new MarketCatalog(this);
        channelcatalog = new ChannelCatalog(this);
        suppliers = new SupplierDirectory();
        solutionoffercatalog = new SolutionOfferCatalog(this);
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory = new EmployeeDirectory(this);
        mastersolutionorderlist = new MasterSolutionOderList();
        

    }

    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }
    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return this.salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }
        public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public void printShortInfo(){
        System.out.println("Checking what's inside the business hierarchy.");
        suppliers.printShortInfo();
        customerdirectory.printShortInfo();
        masterorderlist.printShortInfo();
    }
    public MarketCatalog getMarketCatalog() {
            return marketCatalog;
        }

    public void setMarketCatalog(MarketCatalog marketCatalog) {
        this.marketCatalog = marketCatalog;
    }

    public ChannelCatalog getChannelcatalog() {
        return channelcatalog;
    }

    public void setChannelcatalog(ChannelCatalog channelcatalog) {
        this.channelcatalog = channelcatalog;
    }
    public void setSalespersondirectory(SalesPersonDirectory salespersondirectory) {
        this.salespersondirectory = salespersondirectory;
    }

    public SolutionOfferCatalog getSolutionoffercatalog() {
        return solutionoffercatalog;
    }

    public void setSolutionoffercatalog(SolutionOfferCatalog solutionoffercatalog) {
        this.solutionoffercatalog = solutionoffercatalog;
    }
    public MasterSolutionOderList getMasterSolutionOderList() {
        return mastersolutionorderlist;
    }

    public void setMastersolutionorderlist(MasterSolutionOderList mastersolutionorderlist) {
        this.mastersolutionorderlist = mastersolutionorderlist;
    }

}
