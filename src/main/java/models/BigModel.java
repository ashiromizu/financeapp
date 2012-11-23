package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import types.Amount;
import types.Transaction;
import enums.Currency;
import enums.Type;

public class BigModel {
	private Map<String, Transaction> transactions;
	private PropertyChangeSupport listenerSupport;

	public BigModel() {
		listenerSupport = new PropertyChangeSupport(this);
		transactions = new HashMap<String, Transaction>();
	}

	public List<Transaction> getTransactions() {
		return new ArrayList<Transaction>(transactions.values());
	}

	public List<Currency> getCurrencies() {
		return Arrays.asList(Currency.values());
	}
	
	public List<Type> getTypes() {
		return Arrays.asList(Type.values());
	}

	public void add(double amount, Currency selectedCurrency, Type selectedType) {
		Transaction transaction = new Transaction(new Amount(amount, selectedCurrency), selectedType);
		transaction.setUuid(UUID.randomUUID().toString());
		transactions.put(transaction.getUuid(), transaction);
		listenerSupport.firePropertyChange("transactions", false, true);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listenerSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener)  {
		listenerSupport.removePropertyChangeListener(listener);
	}
	
}
