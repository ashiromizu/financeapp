package gui;
import java.util.Scanner;

import javax.swing.JFrame;

import models.BigModel;

public class General {

	private double inputvalue;
	private Scanner input;

	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("Welcome to your expenses app Akira");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainPanel = new MainPanel(new BigModel());
		mainWindow.getContentPane().add(mainPanel);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

//	public void AddNewExpense(Amount value) {
//		input = new Scanner(System.in);
//		System.out.println("Please add the amount of the transaction:");
//		Long v = input.nextLong();
//		value.setValueOfTheTransaction(v);
//	}
//
//	public void AddNewMonthlyIncome() {
//		// TODO
//	}
//
//	public void CalculateValues() {
//		// TODO
//	}
}
