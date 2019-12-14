import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import business.AllBusinessLayerTests;
import domain.AllDomainLayerTests;
import service.AllServiceLayerTests;

@RunWith(Suite.class)
@SuiteClasses({ AllBusinessLayerTests.class, AllDomainLayerTests.class, AllServiceLayerTests.class })
public class AllTests {
	
}
