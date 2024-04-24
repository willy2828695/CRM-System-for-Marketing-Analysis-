
package ui;

import java.util.Scanner;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.ChannelReport;
import model.MarketModel.ChannelSummary;
import model.MarketModel.Market;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketReport;
import model.MarketModel.MarketSummary;


public class DigitalMarketingApplication {

 
  public static void main(String[] args) {
    // TODO code application logic here

    // 1. Populate the model +

    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("My Store", 10, 50, 10, 10, 10, 10,10,10);
    
    // Market Report
    MarketCatalog mc = business.getMarketCatalog();
    MarketReport mr = new MarketReport();
    for(Market m: mc.getMarketList()){
      mr.addMarketSummary(new MarketSummary(m));
    }

    // Channel Report
    ChannelCatalog cc = business.getChannelcatalog();
    ChannelReport cr = new ChannelReport();
    for (Channel c : cc.getChannelList()) {
      cr.addChannelSummary(new ChannelSummary(c));
    }
    
    

    Scanner sc = new Scanner(System.in);

    boolean exitCode = false;

    while (!exitCode) {
      System.out.println("Welcome to Digital Market Analysis. Please pick an option:");
      System.out.println("1. Print Market Performance Report");
      System.out.println("2. Print Channel Performance Report");
      System.out.println("3. Exit");

      String input = sc.next();

      // System.out.println(input);

      if (input.equals("1")) {
        
        mr.printMarketReport();

      }

      if (input.equals("2")){
        
        cr.sortChannelSummaries(false);
        cr.printChannelReport();

        cr.sortedByEfficiency(false);
        cr.printChannelReportEfficiency();
      }
      if (input.equals("3")){
        exitCode = true;
      }
      
    }

    System.out.println("Thank you, have a nice day.");
  }
}
