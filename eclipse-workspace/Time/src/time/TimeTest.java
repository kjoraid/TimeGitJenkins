package time;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	//assertTrue
	//assertFales
	//assertEquals
	//assertNotNull
	//assertNull
	//assertSame
	//assertNotSame
	//assertArrayEquals
	
	@ParameterizedTest
	@ValueSource(strings = {"05:10:10:10", "05:10:20:20", "05:30:30:30" })
	void testValueSource(String parameter) {
		int hours = Time.getTotalHours(parameter);
		assertTrue(hours == 5);
	}

	@Test
	void testgetMilliSecondsGood() {
		int mseconds = Time.getMilliSeconds("20:05:05:05");
		assertTrue("The Milli seconds were not calculated properly", mseconds==5);
		//fail("Not yet implemented");
	}
	@Test
	void testgetMilliSecondsBad() {
		//assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliSeconds("20:05:05:");});
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliSeconds("10:10:10:1");});
		//assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliSeconds("10:10:10");});
		//fail("Not yet implemented");
	}
	@Test
	void testgetMilliSecondsBoundry() {
		int mseconds = Time.getMilliSeconds("23:59:59:99");
		assertTrue("The seconds were not calculated properly", mseconds==99);
		//fail("Not yet implemented");
	}
	
	//--------------
	@Disabled
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
		//fail("Not yet implemented");
	}

	@Disabled
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
		//fail("Not yet implemented");
	}
	@Disabled
	void testGetSecondsBoundary() {
		int seconds = Time.getTotalSeconds("23:59:59");
		assertTrue("The seconds were not calculated properly", seconds==86399);
		//fail("Not yet implemented");
	}

	
	@Disabled
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:05:05");
		assertTrue("The Minutes were not calculated properly", minutes==305);
		//fail("Not yet implemented");
	}
	@Disabled
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalMinutes("10:00");});
	}
	@Disabled
	void testGetTotalMinutesBoundray() {
		int minutes = Time.getTotalMinutes("23:59:59");
		assertTrue("The seconds were not calculated properly", minutes==1440);
	}

	
	@Disabled
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("05:05:05");
		assertTrue("The Hourse were not calculated properly", hours==5);
		//fail("Not yet implemented");
	}
	@Disabled
	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalHours("05:05:05");});

	}
	@Disabled
	void testGetTotalHoursBoundray() {
		int hours = Time.getTotalHours("23:59:59");
		assertTrue("The hours were not calculated properly", hours==24);
	}
	
	@Before
	@Test
	void testPreparation() {
		Time.whereAmI();
		
	}
	
}
