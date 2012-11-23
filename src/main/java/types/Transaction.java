package types;

import java.util.Date;

import enums.Currency;
import enums.Type;

public class Transaction {
	private String uuid;
	private Amount amount;
	private Type type;
	private Date date;
	
	public Transaction(Amount amount, Type type, Date timestamp) {
		this.amount = amount;
		this.type = type;
		this.date=timestamp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String val) {
		this.uuid = val;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount val) {
		this.amount = val;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmountValue() {
		return amount.getValueOfTheTransaction();
	}

	public Currency getAmountCurrency() {
		return amount.getCurrency();
	}

}
