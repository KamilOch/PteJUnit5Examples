package pl.edu.pw.ii.pte.junit.money2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.pw.ii.pte.junit.money2.Money.compareTwoDifferentCurrencyAmount;

public class MoneyCompareTwoDifferentCurrencyAmountTest {

    Money startMoneyInPLN;
    Money startMoneyInEUR;

    void createStartMoneyValue10InPLN() {
        startMoneyInPLN = new Money(10, CurrencyType.PLN);
    }

    void createStartMoneyValue10InEUR() {
        startMoneyInEUR = new Money(10, CurrencyType.EUR);
    }

    @Test
    public void compareTestFirstValueIsBigger() {
        //given
        createStartMoneyValue10InPLN();
        createStartMoneyValue10InEUR();
        String expected = "Pierwsza kwota jest wieksza";
        //when
        String result = compareTwoDifferentCurrencyAmount(startMoneyInEUR, startMoneyInPLN);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void compareTestSecondValueIsBigger() {
        //given
        createStartMoneyValue10InPLN();
        createStartMoneyValue10InEUR();
        String expected = "Druga kwota jest wieksza";
        //when
        String result = compareTwoDifferentCurrencyAmount(startMoneyInPLN, startMoneyInEUR);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void compareTestTwoValuesAreSame() {
        //given
        Money firstValue = new Money(10, CurrencyType.PLN);
        Money secondValue = new Money(5, CurrencyType.CHF);
        String expected = "Obie kwoty są takie same";
        //when
        String result = compareTwoDifferentCurrencyAmount(firstValue, secondValue);
        //then
        assertEquals(expected, result);
    }
}
