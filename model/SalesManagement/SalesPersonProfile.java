
package model.SalesManagement;

import java.util.ArrayList;

import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.Profile;
import model.ProductManagement.SolutionOrder;


public class SalesPersonProfile  {
    ArrayList<Order> salesOrders;
    ArrayList<SolutionOrder> SolutionOder;
    Person person;

    public SalesPersonProfile(Person p) {

        person = p;
        salesOrders = new ArrayList<Order>();
        SolutionOder = new ArrayList<SolutionOrder>();

    }

    public void addSalesOrder(Order o) {
        salesOrders.add(o);
    }

    public void addSolutionOrder(SolutionOrder so) {
        SolutionOder.add(so);
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }

}
