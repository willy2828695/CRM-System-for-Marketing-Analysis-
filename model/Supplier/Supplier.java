
package model.Supplier;

import java.util.ArrayList;

import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;


public class Supplier {
    String name;
    ProductCatalog productCatalog;
    ProductsReport productsReport;

    public Supplier(String n) {
        name = n;
        productCatalog = new ProductCatalog("software");
    }

    public ProductsReport prepareProductsReport() {

        productsReport = productCatalog.generateProductPerformanceReport("");
        return productsReport;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {

        if (productsReport == null)
            productsReport = prepareProductsReport();
        return productsReport.getProductsAlwaysAboveTarget();

    }

    public String getName() {
        return name;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void printShortInfo() {
        System.out.println("Checking supplier " + name);
        productCatalog.printShortInfo();
    }

    // add supplier product ..

    // update supplier product ...
    @Override
    public String toString() {
        return name;
    }
}
