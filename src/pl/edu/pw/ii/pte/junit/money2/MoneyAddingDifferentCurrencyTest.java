package pl.edu.pw.ii.pte.junit.money2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyAddingDifferentCurrencyTest {

    Money startMoneyInPLN;
    Money startMoneyInEUR;
    Money startMoneyInUSD;
    Money startMoneyInCHF;


    @BeforeEach
    public void setUp() throws Exception {
        startMoneyInPLN = new Money(10, CurrencyType.PLN);
        startMoneyInEUR = new Money(10, CurrencyType.EUR);
        startMoneyInUSD = new Money(10, CurrencyType.USD);
        startMoneyInCHF = new Money(10, CurrencyType.CHF);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void addingDifferentCurrencyCaseAddedValueZero() {
        //given
        Money moneyInEuroZeroValue = new Money(0, CurrencyType.EUR);
        Money expected = new Money(10, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInEuroZeroValue);
        //then
        assertEquals(expected.amount(), result.amount());
    }

    @Test
    public void addingDifferentCurrencyCheckIfBaseCurrencyStayTheSame() {
        //given
        Money moneyInEuro = new Money(100, CurrencyType.EUR);

        Money expected = new Money(10, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInEuro);
        //then
        assertEquals(expected.currency(), result.currency());
    }

    @Test
    public void addingDifferentCurrencyCasePLNToPLN() {
        //given
        Money moneyInPln = new Money(100, CurrencyType.PLN);

        Money expected = new Money(110, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInPln);
        //then
        assertEquals(expected.currency(), result.currency());
    }

    @Test
    public void addingDifferentCurrencyCasePLNToEUR() {
        //given
        Money moneyInEUR = new Money(1, CurrencyType.EUR);
        Money expected = new Money(14, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInEUR);
        //then
        assertEquals(expected.amount(), result.amount());
    }

    @Test
    public void addingDifferentCurrencyCasePLNToUSD(){
        //given
        Money moneyInUSD = new Money(2, CurrencyType.USD);
        Money expected = new Money(16, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInUSD);
        //then
        assertEquals(expected.amount(),result.amount());
    }
    @Test
    public void addingDifferentCurrencyCasePLNToCHF(){
        //given
        Money moneyInCHF = new Money(2, CurrencyType.CHF);
        Money expected = new Money(14, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInCHF);
        //then
        assertEquals(expected.amount(),result.amount());
    }


}
