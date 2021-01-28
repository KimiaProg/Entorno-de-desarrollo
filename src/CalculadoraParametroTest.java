import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculadoraParametroTest {

	@Parameters
	public static Iterable<Object[]> getData() {
		return Arrays.asList(new Object[][] { { 3, 1, 4 }, { 5, 5, 10 }, { 6, 4, 10 } });

		/*
		 * List<Object[]> obj = new ArrayList<>(); obj.add(new Object[] { 3, 1, 4 });
		 * obj.add(new Object[] { 5, 5, 10 }); obj.add(new Object[] { 6, 4, 10 });
		 * return obj;
		 */
	}

	private int a, b, exp;

	public CalculadoraParametroTest(int a, int b, int exp) {
		super();
		this.a = a;
		this.b = b;
		this.exp = exp;
	}

	@Test
	public void testAdd() {
		Calculadora cal = new Calculadora();
		System.out.println("Add");
		int resul = cal.add(a, b);
		assertEquals(exp, resul);

	}
}
