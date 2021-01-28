import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {
	static Calculadora cal;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
		cal = new Calculadora();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}

	@Before
	public void before() {
		System.out.println("Before");
		cal.clear();
	}

	@After
	public void after() {
		System.out.println("After");
		cal.clear();
	}

	@Test
	public void testSuma() {
		System.out.println("Sum");
		int res = cal.add(3, 2);
		int esperado = 5;
		assertEquals(esperado, res);
	}

	@Test
	public void testAnsSum() {
		System.out.println("ansSum");
		cal.add(3, 2);
		int res = cal.ans();
		int esperado = 5;
		assertEquals(esperado, res);
	}

	@Test
	public void testDiv() {
		System.out.println("Div");
		cal.div(6, 2);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivPorCero() {
		System.out.println("DivPorCero");
		cal.div(6, 0);
	}

	/*
	 * @Test(timeout = 100) public void testAlgoritmoOptimo() {
	 * System.out.println("Div"); cal.operacionOptima(); }
	 */

}
