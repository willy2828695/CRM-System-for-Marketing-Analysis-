

package model.MarketModel;

import java.util.Comparator;

public class ChannelComparatorByEfficiancy implements Comparator<ChannelSummary> {
    private boolean ascending;

    public ChannelComparatorByEfficiancy(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(ChannelSummary cs1, ChannelSummary cs2) {
        // Assuming you want to sort by total revenue, adjust as necessary
        int revenueComparison = Integer.compare(cs1.CalculateEfficiency(), cs2.CalculateEfficiency());
        return ascending ? revenueComparison : -revenueComparison;
    }
}

