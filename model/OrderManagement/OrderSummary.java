
package model.OrderManagement;


public class OrderSummary {
    int salesvolume;
    int numberOfItems;
    boolean totalabovetarget;
    int orderpriceperformance;
    int numberofOrderitemsabovetarget;
    String customerId;
    
public OrderSummary(Order o){
    salesvolume = o.getOrderTotal();
    numberOfItems = o.getNumberOfItems();
    totalabovetarget = o.isOrderAboveTotalTarget();
    orderpriceperformance = o.getOrderPricePerformance();
    numberofOrderitemsabovetarget = o.getNumberOfOrderItemsAboveTarget();
    customerId = o.getCustomerId();
    

}
public int getOrderProfit(){
    return orderpriceperformance;
}

public void printOrderSummary(){
    System.out.println("| " + customerId + " | " + numberOfItems + " | " + salesvolume);
}

}
