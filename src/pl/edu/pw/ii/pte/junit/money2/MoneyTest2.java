package pl.edu.pw.ii.pte.junit.money2;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest2 {
    private Money m12CHF;
    private Money m14CHF;

    @BeforeEach
    public void setUp() throws Exception {
        m12CHF = new Money(12, CurrencyType.CHF);
        m14CHF = new Money(14, CurrencyType.CHF);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testSimpleAdd2() {
        Money expected = new Money(26, CurrencyType.CHF);
        Money result = m12CHF.add(m14CHF); //
        assertTrue(expected.equals(result)); //
    }

    @Test
    public void testEquals2() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new Money(12, CurrencyType.CHF));
        assertTrue(!m12CHF.equals(m14CHF));
    }

    // TESTY ZADANIE A PUNKT 1
    @Test
    public void testMultiplyByTwo() {
        Money expected = new Money(24, CurrencyType.CHF);

        Money result = m12CHF.multiplyBy(2);

        assertTrue(expected.equals(result));
    }

    @Test
    public void testMultiplyByOne() {
        Money expected = new Money(14, CurrencyType.CHF);

        Money result = m14CHF.multiplyBy(1);

        assertTrue(expected.equals(result));
    }
}
