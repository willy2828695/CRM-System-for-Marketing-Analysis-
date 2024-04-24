
package model.CustomerManagement;

import java.util.ArrayList;

import model.MarketModel.Market;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.ProductManagement.SolutionOrder;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferItem;


public class CustomerProfile {
    ArrayList<Order> orders;
    ArrayList<Market> market;
    ArrayList<SolutionOrder> SolutionOder;

    Person person;
    

    public CustomerProfile(Person p) {
        person = p;
        orders = new ArrayList<Order>();
        market = new ArrayList<Market>();
        SolutionOder = new ArrayList<SolutionOrder>();
       
    }

    public void defineMarket(Market m) {
        market.add(m);
    }

    public int getTotalPricePerformance() {
        // for each order in the customer orderlist
        // calculate order price performance and add it to the sum

        return 0;
    }

    public int getNumberOfOrdersAboveTotalTarget() {
        // for each order in the customer order list
        // calculate if order is positive (actual order total is greater than sum of
        // item targets
        // if yes then add 1 to total
        int sum = 0;
        for (Order o : orders) {
            if (o.isOrderAboveTotalTarget() == true)
                sum = sum + 1;
        }

        return sum;
    }

    public int getNumberOfOrdersBelowTotalTarget() {
        return 0;
    }
    // for each order in the customer order list
    // calculate if order is negative
    // if yes then add 1 to total

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public void addCustomerOrder(Order o) {
        orders.add(o);
    }

    
    public void addSolutionOrder(SolutionOrder so) {
        SolutionOder.add(so);
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }

    public String getCustomerId() {
        return person.getPersonId();
    }

    public Person getPerson() {
        return person;
    }

}
