
package model.MarketingManagement;

import java.util.ArrayList;

import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.Profile;


public class MarketingPersonProfile extends Profile {
    ArrayList<Order> salesOrders;

    public MarketingPersonProfile(Person p) {

        super(p);
        salesOrders = new ArrayList<Order>();

    }

    public void addSalesOrder(Order o) {
        salesOrders.add(o);
    }

    @Override
    public String getRole() {
        return "Marketing";
    }

}
