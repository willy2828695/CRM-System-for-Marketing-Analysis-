package model.MarketModel;

import java.util.Comparator;

public class ChannelComparator implements Comparator<ChannelSummary> {
    private boolean ascending;

    public ChannelComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(ChannelSummary cs1, ChannelSummary cs2) {
        // Assuming you want to sort by total revenue, adjust as necessary
        int revenueComparison = Integer.compare(cs1.getTotalRevenue(), cs2.getTotalRevenue());
        return ascending ? revenueComparison : -revenueComparison;
    }
}
