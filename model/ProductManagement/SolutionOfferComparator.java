package model.ProductManagement;

import java.util.Comparator;
public class SolutionOfferComparator implements Comparator<SolutionOffer> {
    private boolean ascending;

    public SolutionOfferComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(SolutionOffer so1, SolutionOffer so2) {
        // Assuming you want to sort by total revenue, adjust as necessary
        int revenueComparison = Integer.compare(so1.getRevenue(), so2.getRevenue());
        return ascending ? revenueComparison : -revenueComparison;
    }
}