package model.MarketModel;

public class ChannelSummary {
    Channel channel;
    int totalRevenue;
    int totalAdBudget;
    int totalSales;
    
   
    public ChannelSummary(Channel c){
        channel = c;
        totalRevenue = c.calculateTotalrevenue();
        totalAdBudget = c.getTotalAdBudget();
        totalSales = c.getNumberOfSales();
    }

    public Channel getChannel() {
        return channel;
    }
    
    public int getTotalRevenue() {
        return totalRevenue;
    }

    public int getTotalAdBudget() {
        return totalAdBudget;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int CalculateEfficiency(){
        return totalRevenue*100/totalAdBudget;
    }

    public void printChannelSummary(){
        // System.out.println(channel.getName()+" | "+totalRevenue+" | "+totalAdBudget+" | "+totalSales);
        System.out.printf("%-10s | $%5d | $%5d | %3d\n", 
        channel.getName(), totalRevenue, totalAdBudget, totalSales);
    }

    public void printChannelSummaryEfficiency(){
        // System.out.println(channel.getName()+" | "+CalculateEfficiency()+"%");
        System.out.printf("%-10s | %d%%\n", 
            channel.getName(), CalculateEfficiency());
    }

    


}
