package models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.server.ExportException;
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
import enums.User;

public class BigModel {
	private ExpensesDatabase expenses;
	private Currency selectedCurrency;
	private Type selectedType;
	private Type selectedTypeOutput;
	private User selectedUser;


	private PropertyChangeSupport listenerSupport;

	public BigModel(ExpensesDatabase expenses) {
		listenerSupport = new PropertyChangeSupport(this);
		this.expenses = expenses;
		this.selectedCurrency = Currency.NOK;
		this.selectedType = Type.Supermarket;
		this.selectedTypeOutput = Type.Supermarket;
		this.selectedUser = User.Akira;
	}

	public List<Transaction> getTransactions() {
		return new ArrayList<Transaction>(expenses.getTransaction());
	}

	public List<Currency> getCurrencies() {
		return Arrays.asList(Currency.values());
	}

	public List<Type> getTypes() {
		return Arrays.asList(Type.values());
	}
	
	public List<User> getUser(){
		return Arrays.asList(User.values());
	}

	public void add(double amount, Currency selectedCurrency, Type selectedType, Date timestamp, User selectedUser) {
		expenses.add(amount, selectedCurrency, selectedType, timestamp, selectedUser);
		listenerSupport.firePropertyChange("transactions", false, true);
		listenerSupport.firePropertyChange("selectedTypeTotal", false, true);
		listenerSupport.firePropertyChange("selectedUser", false, true);
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
		listenerSupport.firePropertyChange("selectedType", false, true);
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

	public User getSelectedUser() {
		return selectedUser;
	}
	
	public void setSelectedUser(User val) {
		this.selectedUser = val;
		System.out.println("the user is set to " + val);
		listenerSupport.firePropertyChange("selectedUser", 0, 1);
	}
}
