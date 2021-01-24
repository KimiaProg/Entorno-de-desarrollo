import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class AssertTest {

	@Test
	public void test() {

		Date date1 = new Date();
		Date date2 = new Date();
		
		assertEquals(date1, date2);
		assertSame(date1, date2);
		
		assertFalse(false);
	}

}
