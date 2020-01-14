package pl.edu.pw.ii.pte.junit.money2;

class Money {
    private int fAmount;
    private CurrencyType fCurrency;

    public Money(int amount, CurrencyType currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public CurrencyType currency() {
        return fCurrency;
    }

    public Money add(Money m) {
        return new Money(amount() + m.amount(), currency());
    }

    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money a = (Money) anObject;

            return a.currency().equals(currency()) && amount() == a.amount();
        }
        return false;

    }

    // ZADANIE A PUNKT 1
    public Money multiplyBy(int multiplier) {
        return new Money(this.fAmount * multiplier, this.currency());
    }


    //ZADANIE A PUNKT 2
    public Money addSomeCurrency(Money inputMoney) {

        Money inputMoneySameCurrency = changeCurrencyToCurrent(currency(), inputMoney);

        return new Money(amount() + inputMoneySameCurrency.amount(), currency());
    }


    private Money changeCurrencyToCurrent(CurrencyType currentCurrencyType, Money inputMoney) {

        CurrencyType inputCurrencyCode = inputMoney.currency();
        int inputCurrencyValue = inputMoney.fAmount;
        //
        int conversionFactor = useOfficialConversionValue(currentCurrencyType, inputCurrencyCode);

        return new Money(inputCurrencyValue * conversionFactor, currentCurrencyType);
    }

    private static int useOfficialConversionValue(CurrencyType currentCurrencyType, CurrencyType inputCurrencyCode) {
        int conversionFactor = 0;

        if (currentCurrencyType == inputCurrencyCode) {
            conversionFactor = 1;
        } else if (currentCurrencyType == CurrencyType.PLN && inputCurrencyCode == CurrencyType.EUR) {
            conversionFactor = 4;
        } else if(currentCurrencyType == CurrencyType.PLN && inputCurrencyCode == CurrencyType.USD){
        	conversionFactor = 3;
		}  else if (currentCurrencyType == CurrencyType.PLN && inputCurrencyCode == CurrencyType.CHF){
        	conversionFactor = 2;
        }

        return conversionFactor;
    }


}