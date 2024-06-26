
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;
import model.MarketModel.Market;
import model.Personnel.Person;

public class CustomerDirectory {

    Business business;
    ArrayList<CustomerProfile> customerlist;

    public CustomerDirectory(Business d) {

        business = d;
        customerlist = new ArrayList<CustomerProfile>();

    }

    public void addCustomerProfile(CustomerProfile cp) {
        customerlist.add(cp);
    }

    public CustomerProfile newCustomerProfile(Person p, Market m) {
       

        CustomerProfile sp = new CustomerProfile(p);
        sp.defineMarket(m);
        customerlist.add(sp);
        return sp;
    }

    public CustomerProfile findCustomer(String id) {

        for (CustomerProfile sp : customerlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
        public CustomersReport generatCustomerPerformanceReport(){
        CustomersReport customersreport = new CustomersReport();
    
        for(CustomerProfile cp: customerlist){
            
            CustomerSummary cs = new CustomerSummary(cp);
            customersreport.addCustomerSummary(cs);
        }
        return customersreport; 
    }

    public CustomerProfile pickRandomCustomer(){
        if (customerlist.size() == 0) return null;
        Random r = new Random();
        int randomIndex = r.nextInt(customerlist.size());
        return customerlist.get(randomIndex);
    }
    public ArrayList<CustomerProfile> getCustomerlist() {
        return customerlist;
    }


    public void printShortInfo(){
        System.out.println("Checking what's inside the Customer directory.");
        System.out.println("There are " + customerlist.size() + " customers.");
    }
}
