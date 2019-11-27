package service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FlightSvcTest.class, ItinerarySvcTest.class, LoginSvcTest.class, TravelerSvcTest.class })
public class AllServiceLayerTests {}
