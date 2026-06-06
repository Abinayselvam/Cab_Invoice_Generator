package Entity;

public class InvoiceSummary {
    private int numberOfRide;
    private double totalFare;
    private double averagePerFare;
    public InvoiceSummary(int numberOfRide,double totalFare)
    {
        this.numberOfRide=numberOfRide;
        this.totalFare=totalFare;
        this.averagePerFare=totalFare/numberOfRide;
    }
    public int getNumberOfRide()
    {
        return numberOfRide;
    }
    public double getTotalFare()
    {
        return totalFare;
    }
    public double getAveragePerFare()
    {
        return averagePerFare;
    }
    @Override
    public String toString()
    {
        return "Invoice Summary \nTotal Rides: "+ numberOfRide+" | Total Fare: "+ totalFare+" | AverageFare: "+averagePerFare;
    }
}
