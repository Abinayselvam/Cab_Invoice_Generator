import Entity.InvoiceSummary;
import Entity.Ride;
import Service.InvoiceGenerator;
import Service.InvoiceService;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import Enum.RideType;

public class InvoiceGeneratorTest {
    @Test
    void givenDistanceAndTime_ShouldReturnFare() {

        InvoiceGenerator generator =
                new InvoiceGenerator();

        double fare =
                generator.calculateFare(2.0, 5);

        assertEquals(25.0, fare);
    }

    @Test
    void givenMultipleRides_ShouldReturnTotalFare()
    {
        InvoiceGenerator generator=new InvoiceGenerator();
        Ride[] rides={
                new Ride(2.0,5,RideType.Premium),
                new Ride(3.0,10,RideType.Normal)
        };
        double totalFare=generator.calculateFare(rides);
        assertEquals(65.0,totalFare);
    }
    @Test
    void givenCalculate_ShouldReturnInvoiceSummary()
    {
        InvoiceGenerator generator= new InvoiceGenerator();
        Ride[] rides={
                new Ride(2.0,5,RideType.Premium),
                new Ride(3.0,10,RideType.Normal)
        };
        InvoiceSummary summary=generator.calculateInvoiceSummary(rides);
        assertEquals(2,summary.getNumberOfRide());
        assertEquals(65.0,summary.getTotalFare());
        assertEquals(32.5,summary.getAveragePerFare());
    }
    @Test
    void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        Ride[] rides = {

                new Ride(2.0,5,RideType.Normal),
                new Ride(3.0,10,RideType.Premium)
        };
        InvoiceService service=new InvoiceService();
        service.addRides("101",rides);
        InvoiceSummary summary=service.getInvoice("101");
        assertEquals(65.0,summary.getTotalFare());
    }
    @Test
    void givenPremiumRide_ShouldReturnFare() {

        Ride ride =
                new Ride(
                        2,
                        5,
                        RideType.Premium
                );

        InvoiceGenerator generator =
                new InvoiceGenerator();

        double fare =
                generator.calculateFare(
                        ride
                );

        assertEquals(
                40.0,
                fare
        );
    }
}
