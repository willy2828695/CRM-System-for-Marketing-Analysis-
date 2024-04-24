
package model.Business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import com.github.javafaker.Faker;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.MasterSolutionOderList;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.ProductManagement.SolutionOfferItem;
import model.ProductManagement.SolutionOrder;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  static int upperPriceLimit = 50;
  static int lowerPriceLimit = 10;
  static int range = 5;
  static int productMaxQuantity = 5;
  static ArrayList<String> productList = new ArrayList<String>(
       Arrays.asList( "Women's High Waist Yoga Pants",
       "Eco-Friendly Yoga Mat",
       "Non-Slip Yoga Towel",
       "Yoga Mat Carrier Bag",
       "Cork Yoga Blocks",
       "Stretching Yoga Strap",
       "Yoga Wheel for Back Pain",
       "Breathable Yoga Top",
       "Seamless Sports Bra",
       "Full-Toe Grip Socks",
       "Long Sleeve Yoga Shirt",
       "Compression Yoga Leggings",
       "Yoga Mat Cleaner Spray",
       "Balance Pad",
       "Yoga Bolster Pillow",
       "Water Bottle with Time Marker",
       "Yoga Meditation Cushion",
       "Yoga Sandbags for Weight",
       "Yoga Ball",
       "Yoga Blanket",
       "Yoga Capri Pants",
       "Yoga Beanie and Headbands",
       "Insulated Stainless Steel Water Bottle",
       "Yoga Guide Book for Beginners",
       "Digital Yoga Class Subscription",
       "Yoga Shorts",
       "Yoga Jumpsuit",
       "Aromatherapy Essential Oils Set for Yoga",
       "Yoga Hammock for Aerial Yoga",
       "Yoga Skirt")
  );
  static ArrayList<String> marketList = new ArrayList<String>(
    Arrays.asList("Young Adult Women",  "Middle Age Women", "Senior Women")
  );

  static ArrayList<String> channelList = new ArrayList<String>(
    Arrays.asList("Youtube", "Tiktok", "Television", "Campaign")
  );

  public static Business createABusinessAndLoadALotOfData(String name, int supplierCount,
      int customerCount,int orderCount, int itemCount,  int productCount, int salesCount, int numberOfproductFromEachSupplier, int offerCount) {
    Business business = new Business(name);

    loadMarkets(business);

    loadChannels(business);

    createMarketChannelAssignment(business);

    loadSalesperson(business, salesCount);
    // Add Suppliers +
    loadSuppliers(business, supplierCount);


    loadCustomers(business, customerCount);

    // Add Products +
    loadProducts(business, productCount);

    loadSolutionOffer(business, numberOfproductFromEachSupplier, offerCount);



    // Add Customers
    

    // Add Order
    // loadOrders(business, orderCount, itemCount);
    loadSolutionOfferOrders(business, orderCount, itemCount);
   
    return business;
  }

  public static void loadSuppliers(Business b, int supplierCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    
    Faker faker = new Faker();
    for (int index = 1; index <= supplierCount; index++) {
      supplierDirectory.newSupplier(faker.name().fullName());
    }
  }

  static void loadMarkets(Business b) {
    MarketCatalog marketCatalog = b.getMarketCatalog();
    for (int index = 0; index < marketList.size(); index++) {
      marketCatalog.newMarket(marketList.get(index));
    }
    
    // System.out.println("Markets loaded: " + marketCatalog.getMarketList().size());
   
    // System.out.println("Random Market just after loading: " + b.getMarketCatalog().pickRandomMarket());

  }

  static void loadChannels(Business b) {
    ChannelCatalog channelCatalog = b.getChannelcatalog();
    for (int index = 0; index < channelList.size(); index++) {
      channelCatalog.newChannel(channelList.get(index));
    }
  }

  static void loadProducts(Business b, int productCount) {
    // Create an instance that connects to the supplier directory in the specific business
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();

  
    // give numbers of product to each supplier in the random_supplier list
      for (Supplier randomSupplier : supplierDirectory.getSupplierList()) {
        // For each supplier, create a random number of products
        int randomProductNumber = getRandom(1, productCount);
        ProductCatalog productCatalog = randomSupplier.getProductCatalog();
        Set<Integer> usedIndices = new HashSet<>(); 

        for (int index = 1; index <= randomProductNumber; index++) {
          
          int randomIndex = getRandom(0, productList.size() - 1);
          if (usedIndices.contains(randomIndex)) {
            index -= 1;
            continue;
          }
            usedIndices.add(randomIndex);
            String productName = productList.get(randomIndex) ;
            int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
            int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
            int randomTarget = getRandom(randomFloor, randomCeiling);

            Product p = productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
            
      }
    }
  }
  static void createMarketChannelAssignment(Business b){
    for (Market randomMarket : b.getMarketCatalog().getMarketList()) {
      for (Channel randomChannel : b.getChannelcatalog().getChannelList()) {
        int adBudget = getRandom(50000, 70000);
        MarketChannelAssignment mca = new MarketChannelAssignment(randomMarket, randomChannel,adBudget);
        randomMarket.addMarketChannelAssignment(mca);
        randomChannel.addMarketChannelAssignment(mca);
      }
    }   
  }

  static void loadSolutionOffer(Business b, int numberOfproductFromEachSupplier, int offerCount){
    
    SolutionOfferCatalog solutionOfferCatalog = b.getSolutionoffercatalog();
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();

    // create solution offers
    for (int count = 0; count < offerCount; count++) {
      Market randomMarket = b.getMarketCatalog().pickRandomMarket();
      MarketChannelAssignment randomMarketChannelAssignment = randomMarket.pickrandomMarketChannelAssignment();

      ArrayList<Product> productlist = new ArrayList<Product>();
      int randomProductNumber = getRandom(1, numberOfproductFromEachSupplier);

      // load product into solution offer
      for (int index = 0; index < randomProductNumber; index++) {
        Supplier randomSupplier = supplierDirectory.pickRandomSupplier();
        // get the supplier's product catalog
        ProductCatalog productCatalog = randomSupplier.getProductCatalog();
        Product randomProduct = productCatalog.pickRandomProduct();
        
        if (randomProduct == null) {
          index -= 1;
          continue;
        }
        if (productlist.contains(randomProduct)) {
          index -= 1;
          continue;
        }
        productlist.add(randomProduct);
      }
      String solutionname = "Solution Offer " + count+1;
      // calculate the price of the solution offer
      int solutionOfferPrice = 0;
      for (Product p : productlist) {
        solutionOfferPrice += p.getTargetPrice();
      }
      //  assign products into solution offer
      SolutionOffer so = solutionOfferCatalog.newSolutionOffer(solutionname, solutionOfferPrice, randomMarketChannelAssignment);
      for (Product randomProduct : productlist) {
        so.addProduct(randomProduct);
      }
      // System.out.println("Solution Offer loaded: " + so.getproductlist());
      // System.out.println("count"+ count);
      
    }
   }
   



  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt((upper - lower) + 1);
    return randomInt;
  }

  static void loadCustomers(Business b, int customerCount) {
    
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();
    
    Faker faker = new Faker();

    for (int index = 1; index <= customerCount; index++) {
      Market randomMarket = b.getMarketCatalog().pickRandomMarket();
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      customerDirectory.newCustomerProfile(newPerson,randomMarket);
      
    }
    // System.out.println("customers loaded: " + customerDirectory.getCustomerlist());
  }


  static void loadSalesperson(Business b, int salesCount) {
    SalesPersonDirectory salesPersonDirectory = b.getSalesPersonDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();
    Faker faker = new Faker();

    for (int index = 1; index <= salesCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      salesPersonDirectory.newSalesPersonProfile(newPerson);
      // System.out.println("salespersons loaded: " + salesPersonDirectory.getSalesPersonList());
    }
  }

  static void loadOrders(Business b, int orderCount, int itemCount) {

    // reach out to masterOrderList
    MasterOrderList mol = b.getMasterOrderList();

    // pick a random customer (reach to customer directory)
    CustomerDirectory cd = b.getCustomerDirectory();
    SupplierDirectory sd = b.getSupplierDirectory();
    SalesPersonDirectory spd = b.getSalesPersonDirectory();
    System.out.println("Salesperson Directory: " + spd.getSalesPersonList());
    System.out.println("Customer Directory: " + cd.getCustomerlist());

    for (CustomerProfile eachCustomer : cd.getCustomerlist()) {

      
      if (eachCustomer == null) {
        // System.out.println("Cannot generate orders. No customers in the customer directory.");
        return;
      }

      int randomorderNumber = getRandom(1, orderCount);
      
      SalesPersonProfile randomSalesPerson = spd.pickRandomSalesperson();
      
      
      for (int orderIndex = 0; orderIndex < randomorderNumber; orderIndex++) {
      if (randomSalesPerson == null) {
        // System.out.println("Cannot generate orders. No salesperson in the salesperson directory.");
        return;
      }
      // create an order for that customer
      Order randomOrder = mol.newOrder(eachCustomer, randomSalesPerson);

      // add order items
      // -- pick a supplier first (randomly)
      // -- pick a product (randomly)
      // -- actual price, quantity

      int randomItemCount = getRandom(1, itemCount);
      
        for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

          Supplier randomSupplier = sd.pickRandomSupplier();
          
          if (randomSupplier == null) {
            itemIndex -= 1;
            continue; // if use return, it will exit the whole method, adding no oder in the end
          }

          ProductCatalog pc = randomSupplier.getProductCatalog();
          Product randomProduct = pc.pickRandomProduct();
          if (randomProduct == null) {
            itemIndex -= 1;
            continue;
          }

          int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
          int randomQuantity = getRandom(1, productMaxQuantity);

          OrderItem oi = randomOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
        }
    }
    // Make sure order items are connected to the order

  }

}


static void loadSolutionOfferOrders(Business b, int orderCount, int itemCount) {

  MasterSolutionOderList msl = b.getMasterSolutionOderList();

  // pick a random customer (reach to customer directory)
  CustomerDirectory cd = b.getCustomerDirectory();
  SolutionOfferCatalog soc = b.getSolutionoffercatalog();
  SalesPersonDirectory spd = b.getSalesPersonDirectory();
  

  for (CustomerProfile eachCustomer : cd.getCustomerlist()) {

    
    if (eachCustomer == null) {
      // System.out.println("Cannot generate orders. No customers in the customer directory.");
      return;
    }

    int randomorderNumber = getRandom(1, orderCount);
    
    SalesPersonProfile randomSalesPerson = spd.pickRandomSalesperson();
    
    
    for (int orderIndex = 0; orderIndex < randomorderNumber; orderIndex++) {
    if (randomSalesPerson == null) {
      System.out.println("Cannot generate orders. No salesperson in the salesperson directory.");
      return;
    }
    SolutionOrder randomOrder = msl.newSolutionOrder(eachCustomer, randomSalesPerson);

    // add order items
    // -- pick a supplier first (randomly)
    // -- pick a product (randomly)
    // -- actual price, quantity

    int randomItemCount = getRandom(1, itemCount);
    
      for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

        SolutionOffer randomSolutionOffer = soc.pickRandomSolutionOffer();
        
        if (randomSolutionOffer == null) {
          itemIndex -= 1;
          continue; // if use return, it will exit the whole method, adding no oder in the end
        }

        int actualPrice = randomSolutionOffer.getPrice();
        int randomQuantity = getRandom(1, productMaxQuantity);

        SolutionOfferItem soi = randomOrder.newSolutionOfferItem(randomSolutionOffer, actualPrice, randomQuantity);
      }
  }

}
// System.out.println("Solution Offer Orders loaded successfully \n"); 
}
}
