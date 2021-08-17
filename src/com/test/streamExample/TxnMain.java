package com.test.streamExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TxnMain {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		// 1 Find all transactions in the year 2011 and sort them by value (small to
		// high).

		System.out.println(transactions.stream().filter(txn -> txn.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));

		// What are all the unique cities where the traders work?
		transactions.stream().map(txn -> txn.getTrader().getCity()).distinct().forEach(System.out::println);
		// transactions.stream().map(Transaction:: getTrader).map(Trader ::
		// getCity).distinct().forEach(System.out :: println);
		// 3 Find all traders from Cambridge and sort them by name.
		transactions.stream().map(txn -> txn.getTrader()).filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList())
				.forEach(System.out::println);
		// 4 Return a string of all traders’ names sorted alphabetically.
		System.out.println(transactions.stream().map(txn -> txn.getTrader().getName()).distinct().sorted()
				.reduce((n1, n2) -> n1 + " " + " " + n2));
		// Query 5: Are there any trader based in Milan?

		boolean milanBased = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(milanBased);

		// 6 Print the values of all transactions from the traders living in Cambridge

		transactions.stream().filter(t -> "Cambridge".equalsIgnoreCase(t.getTrader().getCity()))
				.map(Transaction::getValue).forEach(System.out::println);
		/*
		 * // Query 6: Update all transactions so that the traders from Milan are set to
		 * Cambridge. transactions.stream() .map(Transaction::getTrader) .filter(trader
		 * -> trader.getCity().equals("Milan")) .forEach(trader ->
		 * trader.setCity("Cambridge")); System.out.println(transactions);
		 */

		// Query 7: What's the highest value in all the transactions?
		int highestValue = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
		System.out.println(highestValue);
		
		//8 Find the transaction with the smallest value.
		Optional<Transaction> smallestTxn = transactions.stream().reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1:t2);
		System.out.println(smallestTxn);
	}
}

/*
 * 1 Find all transactions in the year 2011 and sort them by value (small to high). 
 * 2 What are all the unique cities where the traders work? 
 * 3 Find all traders from Cambridge and sort them by name.
 * 4 Return a string of all traders’ names sorted alphabetically. 
 * 5 Are any traders based in Milan? 
 * 6 Print the values of all transactions from the traders living in Cambridge. 
 * 7 What’s the highest value of all the transactions? 
 * 8 Find the transaction with the smallest value.
 */