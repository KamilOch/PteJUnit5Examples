package pl.edu.pw.ii.pte.junit.money2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

	@Test
	public void testSimpleAdd() {
		Money m12CHF = new Money(12, CurrencyType.CHF); //
		Money m14CHF = new Money(14, CurrencyType.CHF);
		Money expected = new Money(26, CurrencyType.CHF);
		Money result = m12CHF.add(m14CHF); //
		assertTrue(expected.equals(result)); //
		}

	@Test
	public void testEquals() {
		Money m12CHF = new Money(12, CurrencyType.CHF);
		Money m14CHF = new Money(14, CurrencyType.CHF);

		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, CurrencyType.CHF));
		assertTrue(!m12CHF.equals(m14CHF));
		}

}