package Service;
import Entity.InvoiceSummary;
import Entity.Ride;
import Enum.RideType;

public class InvoiceGenerator {

    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {

        double fare =
                (distance * COST_PER_KM)
                        +
                        (time * COST_PER_MINUTE);

        return Math.max(fare, MINIMUM_FARE);
    }
    public double calculateFare(Ride[] rides) {

        double totalFare = 0;

        for(Ride ride : rides) {

            totalFare +=
                    calculateFare(
                            ride.distance,
                            ride.time
                    );
        }

        return totalFare;
    }
    public InvoiceSummary calculateInvoiceSummary(Ride[] rides)
    {
        double totalFare=0;
        for(Ride ride:rides)
        {
            totalFare+=calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);

    }
    public double calculateFare(
            Ride ride) {

        double fare;

        if(ride.type
                ==
                RideType.Normal) {

            fare =
                    (ride.distance * 10)
                            +
                            (ride.time * 1);

            return Math.max(
                    fare,
                    5
            );
        }

        fare =
                (ride.distance * 15)
                        +
                        (ride.time * 2);

        return Math.max(
                fare,
                20
        );
    }
}