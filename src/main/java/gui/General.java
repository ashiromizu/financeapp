package gui;

import javax.swing.JFrame;

import models.BigModel;
import models.ExpensesDatabase;

public class General {

	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("The Expenses App");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainPanel = new MainPanel(new BigModel(new ExpensesDatabase()));
		mainWindow.getContentPane().add(mainPanel);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}