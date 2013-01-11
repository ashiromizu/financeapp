package types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import enums.Currency;
import enums.Type;
import enums.User;

public class ExpensesDatabase {
	private List<Transaction> transactions;

	public ExpensesDatabase() {
		transactions = new ArrayList<Transaction>();
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void add(double amount, Currency selectedCurrency, Type selectedType, Date timestamp, User selectedUser) {
		Transaction transaction = new Transaction(new Amount(amount, selectedCurrency), selectedType, timestamp, selectedUser);
		transaction.setUuid(UUID.randomUUID().toString());
		transactions.add(0, transaction);
	}

}
