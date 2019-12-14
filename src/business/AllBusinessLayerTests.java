package business;
import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlightMgrTest.class, ItineraryMgrTest.class, LoginMgrTest.class, TravelerMgrTest.class })
public class AllBusinessLayerTests {
	
}
