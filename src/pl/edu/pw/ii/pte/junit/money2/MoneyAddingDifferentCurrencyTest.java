package pl.edu.pw.ii.pte.junit.money2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyAddingDifferentCurrencyTest {

    Money startMoneyInPLN;
    Money startMoneyInEUR;
    Money startMoneyInUSD;
    Money startMoneyInCHF;


    void createStartMoneyValue10InPLN() {
        startMoneyInPLN = new Money(10, CurrencyType.PLN);
    }

    void createStartMoneyValue10InEUR() {
        startMoneyInEUR = new Money(10, CurrencyType.EUR);
    }

    void createStartMoneyValue10InUSD() {
        startMoneyInUSD = new Money(10, CurrencyType.USD);
    }

    void createStartMoneyValue10InCHF() {
        startMoneyInCHF = new Money(10, CurrencyType.CHF);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void addingDifferentCurrencyCaseAddedValueZero() {
        //given
        createStartMoneyValue10InPLN();
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
        createStartMoneyValue10InPLN();
        Money moneyInEuro = new Money(100, CurrencyType.EUR);

        Money expected = new Money(10, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInEuro);
        //then
        assertEquals(expected.currency(), result.currency());
    }

    @Test
    public void addingDifferentCurrencyCasePLNPlusPLN() {
        //given
        createStartMoneyValue10InPLN();
        Money moneyInPln = new Money(100, CurrencyType.PLN);

        Money expected = new Money(110, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInPln);
        //then
        assertEquals(expected.currency(), result.currency());
    }

    @Test
    public void addingDifferentCurrencyCasePLNPlusEUR() {
        //given
        createStartMoneyValue10InPLN();
        Money moneyInEUR = new Money(1, CurrencyType.EUR);
        Money expected = new Money(14, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInEUR);
        //then
        assertEquals(expected.amount(), result.amount());
    }

    @Test
    public void addingDifferentCurrencyCasePLNPlusUSD() {
        //given
        createStartMoneyValue10InPLN();
        Money moneyInUSD = new Money(2, CurrencyType.USD);
        Money expected = new Money(16, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInUSD);
        //then
        assertEquals(expected.amount(), result.amount());
    }

    @Test
    public void addingDifferentCurrencyCasePLNPlusCHF() {
        //given
        createStartMoneyValue10InPLN();
        Money moneyInCHF = new Money(2, CurrencyType.CHF);
        Money expected = new Money(14, CurrencyType.PLN);
        //when
        Money result = startMoneyInPLN.addSomeCurrency(moneyInCHF);
        //then
        assertEquals(expected.amount(), result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseEURPlusPLN() {
        //given
        createStartMoneyValue10InEUR();
        Money moneyInPLN = new Money(2,CurrencyType.PLN);
        Money expected = new Money(10.5, CurrencyType.EUR);
        //when
        Money result = startMoneyInEUR.addSomeCurrency(moneyInPLN);
        //then
        assertEquals(expected.amount(), result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseEURPlusUSD(){
        //given
        createStartMoneyValue10InEUR();
        Money moneyInUSD = new Money(1,CurrencyType.USD);
        Money expected = new Money(10.9,CurrencyType.USD);
        //when
        Money result = startMoneyInEUR.addSomeCurrency(moneyInUSD);
        //then
        assertEquals(expected.amount(),result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseEURPlusCHF(){
        //given
        createStartMoneyValue10InEUR();
        Money moneyInCHF = new Money(1,CurrencyType.CHF);
        Money expected = new Money(10.5,CurrencyType.USD);
        //when
        Money result = startMoneyInEUR.addSomeCurrency(moneyInCHF);
        //then
        assertEquals(expected.amount(),result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseUSDPlusPLN(){
        //given
        createStartMoneyValue10InUSD();
        Money moneyInPln = new Money(100, CurrencyType.PLN);
        Money expected = new Money(40,CurrencyType.USD);
        //when
        Money result = startMoneyInUSD.addSomeCurrency(moneyInPln);
        //then
        assertEquals(expected.amount(),result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseUSDPlusEUR(){
        //given
        createStartMoneyValue10InUSD();
        Money moneyInEUR = new Money(1, CurrencyType.EUR);
        Money expected = new Money(11.1,CurrencyType.USD);
        //when
        Money result = startMoneyInUSD.addSomeCurrency(moneyInEUR);
        //then
        assertEquals(expected.amount(),result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseUSDPlusCHF(){
        //given
        createStartMoneyValue10InUSD();
        Money moneyInCHF = new Money(1,CurrencyType.CHF);
        Money expected = new Money(10.6,CurrencyType.USD);
        //when
        Money result = startMoneyInUSD.addSomeCurrency(moneyInCHF);
        //then
        assertEquals(expected.amount(),result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseCHFPlusPLN(){
        //given
        createStartMoneyValue10InCHF();
        Money moneyInPln = new Money(100, CurrencyType.PLN);
        Money expected = new Money(60,CurrencyType.CHF);
        //when
        Money result = startMoneyInCHF.addSomeCurrency(moneyInPln);
        //then
        assertEquals(expected.amount(),result.amount());
    }

    @Test
    public void addingDifferentCurrencyCaseCHFPlusEUR(){
        //given
        createStartMoneyValue10InCHF();
        Money moneyInEUR = new Money(1, CurrencyType.EUR);
        Money expected = new Money(12,CurrencyType.CHF);
        //when
        Money result = startMoneyInCHF.addSomeCurrency(moneyInEUR);
        //then
        assertEquals(expected.amount(),result.amount());
    }
    @Test
    public void addingDifferentCurrencyCaseCHFPlusUSD(){
        //given
        createStartMoneyValue10InCHF();
        Money moneyInCHF = new Money(1,CurrencyType.USD);
        Money expected = new Money(11.5,CurrencyType.CHF);
        //when
        Money result = startMoneyInCHF.addSomeCurrency(moneyInCHF);
        //then
        assertEquals(expected.amount(),result.amount());
    }

}
