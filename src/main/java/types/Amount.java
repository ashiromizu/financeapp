package types;
import enums.Currency;


public class Amount {

	private Currency currency;
	private double valueOfTheTransaction;

	
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


	public double getValueOfTheTransaction() {
		return valueOfTheTransaction;
	}

	public void setValueOfTheTransaction(double valueOfTheTransaction) {
		this.valueOfTheTransaction = valueOfTheTransaction;
	}
	
	
	
}
