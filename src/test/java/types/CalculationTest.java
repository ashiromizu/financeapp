package types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import enums.Currency;
import enums.Type;
import enums.User;

public class CalculationTest {

	@Test
	public void testCalculation() {
		List<Transaction> transactions = new ArrayList<Transaction>();
// two input with different dates, different currencies and different users
		transactions.add(new Transaction(new Amount(200, Currency.NOK), Type.Supermarket, new Date(System.currentTimeMillis()-648000), User.Akira));
		transactions.add(new Transaction(new Amount(400, Currency.SEK), Type.Groceries, new Date(System.currentTimeMillis()-548000), User.Sara));
		
		for (int i = 0; i < 10; i++) // ten input of 10 NOK each = 100 NOK as total
			transactions.add(new Transaction(new Amount(10, Currency.NOK), Type.Supermarket, new Date(System.currentTimeMillis()), User.Akira));
		
		
		Calculations impl = new Calculations();
		double actualsuper = impl.getTotal(transactions, Type.Supermarket);
		int expectedsuper = (10 * 10) + 200; // test for 
		
		for (int i = 10; i < 20; i++)
			transactions.add(new Transaction(new Amount(25, Currency.NOK), Type.Food, new Date(System.currentTimeMillis()), User.Akira));
		
		double actualfood = impl.getTotal(transactions, Type.Food);
		int expectedfood = 10 * 25;
		
//		Calculations impl3 = new Calculations();
//		double actualavg = impl
		
		Assert.assertEquals(expectedsuper, actualsuper, 1e-10);
		Assert.assertEquals(expectedfood, actualfood, 1e-10);
	}
}
