package model.ProductManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.MasterOrderReport;
import model.SalesManagement.SalesPersonProfile;


public class MasterSolutionOderList {

    ArrayList<SolutionOrder> SolutionOrders;
    MasterOrderReport masterOrderReport;

    public MasterSolutionOderList() {
        SolutionOrders = new ArrayList<SolutionOrder>();

    }

    
    public SolutionOrder newSolutionOrder(CustomerProfile cp) {
         SolutionOrder o = new SolutionOrder(cp);
         SolutionOrders.add(o);

         return o;
    }
    
    public SolutionOrder newSolutionOrder(CustomerProfile cp, SalesPersonProfile spp) {
        SolutionOrder o = new SolutionOrder(cp, spp);
        SolutionOrders.add(o);

        return o;
    }

    

    // public MasterOrderReport generateMasterOrderReport() {
    //     masterOrderReport = new MasterOrderReport();
    //     masterOrderReport.generateOrderReport(orders);

    //     return masterOrderReport;
    // }

    public int getSalesVolume() {

        int sum = 0;
        for (SolutionOrder so : SolutionOrders) {
            sum = sum + so.getSolutionOrderTotal();
        }
        return sum;
    }

    public void printShortInfo() {
        System.out.println("Checking what's inside the master order list.");
        System.out.println("There are " + SolutionOrders.size() + " order.");
    }

}



