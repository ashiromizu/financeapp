package types;

import java.util.Date;
import java.util.List;

import org.joda.time.Days;

import enums.Currency;
import enums.Type;

public class Calculations {

	public double getTotal(List<Transaction> trans, Type type) {
		double total = 0;
		for (int i = 0; i < trans.size(); i++) {
			double amountValue = trans.get(i).getAmount().getValueOfTheTransaction();
			Currency currency = trans.get(i).getAmount().getCurrency();
			double amountInNok = amountValue;
			if (trans.get(i).getType() == type)
				total = total + amountInNok;
		}
		System.out.println("Sum of all " + type + " expenses is " + total);
		return total;
	}

	public double getAverages(List<Transaction> trans, Type type) {
		long firstDay = trans.get(0).getDate().getTime();
		long lastDay = System.currentTimeMillis();
		int days = (int) ((lastDay-firstDay)/(24*60*60*1000));
		
		double dailyAvg = getTotal(trans, type)/days;
		return dailyAvg;
	}

}