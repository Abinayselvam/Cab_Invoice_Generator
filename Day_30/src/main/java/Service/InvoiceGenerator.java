package Service;

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
}