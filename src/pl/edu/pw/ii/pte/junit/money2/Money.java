package pl.edu.pw.ii.pte.junit.money2;

class Money {
    private double fAmount;
    private CurrencyType fCurrency;

    public Money(double amount, CurrencyType currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public double amount() {
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
        double inputCurrencyValue = inputMoney.fAmount;
        //
        double conversionFactor = useOfficialConversionValue(currentCurrencyType, inputCurrencyCode);

        return new Money(inputCurrencyValue * conversionFactor, currentCurrencyType);
    }

    private static double useOfficialConversionValue(CurrencyType currentCurrencyType, CurrencyType inputCurrencyCode) {
        double conversionFactor;
        //TODO make separate map ?????
        if (currentCurrencyType == inputCurrencyCode) {
            conversionFactor = 1;
        } else if (currentCurrencyType == CurrencyType.PLN && inputCurrencyCode == CurrencyType.EUR) {
            conversionFactor = 4;
        } else if (currentCurrencyType == CurrencyType.PLN && inputCurrencyCode == CurrencyType.USD) {
            conversionFactor = 3;
        } else if (currentCurrencyType == CurrencyType.PLN && inputCurrencyCode == CurrencyType.CHF) {
            conversionFactor = 2;
        } else if (currentCurrencyType == CurrencyType.EUR && inputCurrencyCode == CurrencyType.PLN) {
            conversionFactor = 0.25;
        } else if (currentCurrencyType == CurrencyType.EUR && inputCurrencyCode == CurrencyType.USD) {
            conversionFactor = 0.9;
        } else if (currentCurrencyType == CurrencyType.EUR && inputCurrencyCode == CurrencyType.CHF) {
            conversionFactor = 0.5;
        } else if (currentCurrencyType == CurrencyType.USD && inputCurrencyCode == CurrencyType.PLN) {
            conversionFactor = 0.3;
        } else if (currentCurrencyType == CurrencyType.USD && inputCurrencyCode == CurrencyType.EUR) {
            conversionFactor = 1.1;
        }  else if (currentCurrencyType == CurrencyType.USD && inputCurrencyCode == CurrencyType.CHF) {
            conversionFactor = 0.6;
        }  else if (currentCurrencyType == CurrencyType.CHF && inputCurrencyCode == CurrencyType.PLN) {
            conversionFactor = 0.5;
        } else if (currentCurrencyType == CurrencyType.CHF && inputCurrencyCode == CurrencyType.EUR) {
            conversionFactor = 2;
        } else if (currentCurrencyType == CurrencyType.CHF && inputCurrencyCode == CurrencyType.USD) {
            conversionFactor = 1.5;
        } else conversionFactor = 0;


        return conversionFactor;
    }


}