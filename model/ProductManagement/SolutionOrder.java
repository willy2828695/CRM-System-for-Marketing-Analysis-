package model.ProductManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.OrderItem;
import model.SalesManagement.SalesPersonProfile;

public class SolutionOrder {
    ArrayList<SolutionOfferItem> SolutionOfferItem;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    MarketChannelAssignment mca;
    String status;

    

    public SolutionOrder(CustomerProfile cp) {
        SolutionOfferItem = new ArrayList<SolutionOfferItem>();
        customer = cp;
        customer.addSolutionOrder(this); // we link the order to the customer
        status = "in process";
    }

    public SolutionOrder(CustomerProfile cp, SalesPersonProfile ep) {
        SolutionOfferItem = new ArrayList<SolutionOfferItem>();
        customer = cp;
        salesperson = ep;
        customer.addSolutionOrder(this); // we link the order to the customer
        salesperson.addSolutionOrder(this);
        status = "in process";
    }


    public SolutionOfferItem newSolutionOfferItem(SolutionOffer so, int actualPrice, int q) {
        SolutionOfferItem soi = new SolutionOfferItem(so, actualPrice, q);
        SolutionOfferItem.add(soi);
        return soi;
    }
    

    // order total is the sumer of the order item totals
    public int getSolutionOrderTotal() {
        int sum = 0;
        for ( SolutionOfferItem sf : SolutionOfferItem) {
            sum = sum + sf.getSolutionOfferItemTotal();
        }
        return sum;
    }

    public int getSolutionOrderPricePerformance() {
        int sum = 0;
        for (SolutionOfferItem sf : SolutionOfferItem) {
            sum = sum + sf.calculatePricePerformance(); // positive and negative values
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (SolutionOfferItem sf : SolutionOfferItem) {
            if (sf.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    // sum all the item targets and compare to the total of the order
    public boolean isOrderAboveTotalTarget() {
        int sum = 0;
        for (SolutionOfferItem sf : SolutionOfferItem) {
            sum = sum + sf.getSolutionOfferItemTargetTotal(); // product targets are added
        }
        if (getSolutionOrderTotal() > sum) {
            return true;
        } else {
            return false;
        }

    }

    public void CancelOrder() {
        status = "Cancelled";
    }

    public void Submit() {
        status = "Submitted";
    }

    public int getNumberOfItems() {
        return SolutionOfferItem.size();
    }

    public String getCustomerId() {
        return customer.getCustomerId();
    }

}
