package model.MarketModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ChannelReport {
    ArrayList<ChannelSummary> channelSummaries;

    public ChannelReport() {
        channelSummaries = new ArrayList<ChannelSummary>();
    }

    public void addChannelSummary(ChannelSummary cs) {
        channelSummaries.add(cs);
    }

    public void sortChannelSummaries(boolean ascending) {
        
        Collections.sort(channelSummaries, new ChannelComparator(ascending));
        
    }

    public void sortedByEfficiency(boolean ascending){
        
        Collections.sort(channelSummaries, new ChannelComparatorByEfficiancy(ascending));
        
    }

    public void printChannelReport() {
        System.out.println("Channel Report:");
        System.out.println("Channel | Total Revenue | Total Ad Budget | Total Sales");
        for (ChannelSummary cs : channelSummaries) {
            cs.printChannelSummary();
        }
        System.out.println("-----------------------------------------------------");

    }

    public void printChannelReportEfficiency() {
        System.out.println("Channel profitability report:");
        System.out.println("Channel    | Efficiency");
        System.out.println("-----------------------------");
        for (ChannelSummary cs : channelSummaries) {
        
            cs.printChannelSummaryEfficiency();
        }
        System.out.println("-----------------------------------------------------");

    }

}
