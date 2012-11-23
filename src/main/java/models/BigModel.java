package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import types.Transaction;


public class BigModel {
	private Map<String, Transaction> transactions;

	public BigModel() {
		transactions = new HashMap<String,Transaction>();
	}
	
	public List<Transaction> getTransactions() {
		return new ArrayList<Transaction>(transactions.values());
	}
}
