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
}
