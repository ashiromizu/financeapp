package types;

import enums.Currency;
import enums.Type;

public class Transaction {
	private String uuid;
	private Amount amount;
	private Type type;
    
	
	public Transaction(Amount amount, Type type) {
		this.amount = amount;
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String val) {
		this.uuid = val;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount val) {
		this.amount = val;
	}

	public double getAmountValue() {
		return amount.getValueOfTheTransaction();
	}

	public Currency getAmountCurrency() {
		return amount.getCurrency();
	}

}
