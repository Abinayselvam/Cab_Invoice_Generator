package Service;

import Entity.InvoiceSummary;
import Entity.Ride;
import Repository.RideRepository;

public class InvoiceService {
    private RideRepository repository=new RideRepository();
    private InvoiceGenerator generator=new InvoiceGenerator();

    public void addRides(String userId, Ride[] rides)
    {
        repository.addRide(userId,rides);
    }
    public InvoiceSummary getInvoice(String userId)
    {
        Ride[] rides= repository.getRides(userId);
        return generator.calculateInvoiceSummary(rides);
    }
}
