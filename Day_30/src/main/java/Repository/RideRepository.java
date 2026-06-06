package Repository;

import Entity.Ride;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    private Map<String, Ride[]> userRides= new HashMap<>();

    public void addRide(String userId,Ride[] rides)
    {
        userRides.put(userId,rides);
    }
    public Ride[] getRides(String userId)
    {
        return userRides.get(userId);
    }

}
