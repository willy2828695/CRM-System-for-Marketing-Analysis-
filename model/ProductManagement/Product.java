
package model.ProductManagement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import model.OrderManagement.OrderItem;


public class Product {
    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    ArrayList<OrderItem> orderItems;
    ArrayList<SolutionOffer> SolutionOffer;
    

    public Product(int fp, int cp, int tp) {

        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderItems = new ArrayList<OrderItem>();
        SolutionOffer = new ArrayList<SolutionOffer>();
   
    }

    public Product(String n, int fp, int cp, int tp) {
        name = n;
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderItems = new ArrayList<OrderItem>();
        SolutionOffer = new ArrayList<SolutionOffer>();
    }

    public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; // returns itself
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void addOrderItem(OrderItem oi) {
        orderItems.add(oi);
    }

    public void addSolutionOffer(SolutionOffer so) {
        SolutionOffer.add(so);
    }

    

    // Number of item sales above target
    public int getNumberOfProductSalesAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            if (oi.isActualAboveTarget() == true)
                sum = sum + 1;
        }
        return sum;
    }

    public int getNumberOfProductSalesBelowTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            if (oi.isActualBelowTarget() == true)
                sum = sum + 1;
        }
        return sum;
    }

    public boolean isProductAlwaysAboveTarget() {

        for (OrderItem oi : orderItems) {
            if (oi.isActualAboveTarget() == false)
                return false; //
        }
        return true;
    }
    // calculates the revenues gained or lost (in relation to the target)
    // For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will
    // be $200
    // Add all these difference to get the total including wins and loses

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.calculatePricePerformance(); // positive and negative values
        }
        return sum;
    }

    public int getSalesVolume() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getOrderItemTotal(); // positive and negative values
        }
        return sum;
    }

    public void setName(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false;  // Check for null and ensure exact class match
        Product product = (Product) obj;
        return Objects.equals(name, product.name);  // Compare based on productName
    }
   

}
