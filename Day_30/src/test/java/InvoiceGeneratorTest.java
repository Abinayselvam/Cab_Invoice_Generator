import Entity.InvoiceSummary;
import Entity.Ride;
import Service.InvoiceGenerator;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

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
                new Ride(2.0,5),
                new Ride(3.0,10)
        };
        double totalFare=generator.calculateFare(rides);
        assertEquals(65.0,totalFare);
    }
    @Test
    void givenCalculate_ShouldReturnInvoiceSummary()
    {
        InvoiceGenerator generator= new InvoiceGenerator();
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(3.0,10)
        };
        InvoiceSummary summary=generator.calculateInvoiceSummary(rides);
        assertEquals(2,summary.getNumberOfRide());
        assertEquals(65.0,summary.getTotalFare());
        assertEquals(32.5,summary.getAveragePerFare());
    }
}
