import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	Calculadora cal;
	@Before
	public void before() {
		System.out.println("Before");
		cal= new Calculadora();
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
		int res= cal.ans();
		int esperado = 5;
		assertEquals(esperado, res);
	}

}
