package domain;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlightTest.class, ItineraryTest.class, ReservationManagerTest.class, TravelerTest.class })
public class AllDomainLayerTests {
	
}
