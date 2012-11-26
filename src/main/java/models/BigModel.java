package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import types.Amount;
import types.Calculations;
import types.Transaction;
import enums.Currency;
import enums.Type;

public class BigModel {
	private ArrayList<Transaction> transactions;

	private Currency selectedCurrency;
	private Type selectedType;
	private Type selectedTypeOutput;

	private PropertyChangeSupport listenerSupport;

	public BigModel() {
		listenerSupport = new PropertyChangeSupport(this);
		transactions = new ArrayList<Transaction>();
		this.selectedCurrency = Currency.NOK;
		this.selectedType = Type.Supermarket;
	}

	public List<Transaction> getTransactions() {
		return new ArrayList<Transaction>(transactions);
	}

	public List<Currency> getCurrencies() {
		return Arrays.asList(Currency.values());
	}

	public List<Type> getTypes() {
		return Arrays.asList(Type.values());
	}

	public void add(double amount, Currency selectedCurrency, Type selectedType, Date timestamp) {
		Transaction transaction = new Transaction(new Amount(amount, selectedCurrency), selectedType, timestamp);
		transaction.setUuid(UUID.randomUUID().toString());
		transactions.add(0, transaction);
		listenerSupport.firePropertyChange("transactions", false, true);
		// it should add the last input in the top of the list.
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.removePropertyChangeListener(listener);
	}

	public Currency getSelectedCurrency() {
		return selectedCurrency;
	}

	public void setSelectedCurrency(Currency val) {
		this.selectedCurrency = val;
		System.out.println("i'm being set to " + val);
	}

	public Type getSelectedType() {
		return selectedType;
	}

	public Type getSelectedTypeOutput() {
		return selectedTypeOutput;
	}

	public void setSelectedType(Type val) {
		this.selectedType = val;
		System.out.println("i'm being set to " + val);
	}

	public void setSelectedTypeOutput(Type val) {
		this.selectedTypeOutput = val;
		System.out.println("The total calculated for " + val + " is ");
		listenerSupport.firePropertyChange("selectedTypeTotal", 0, 1);
	}

	public double getSelectedTypeTotal() {
		double total = new Calculations().getTotal(getTransactions(), selectedTypeOutput);
		return total;
	}

}
