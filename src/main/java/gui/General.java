package gui;
import javax.swing.JFrame;

import models.BigModel;

public class General {

	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("Welcome to your expenses app Akira");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel mainPanel = new MainPanel(new BigModel());
		mainWindow.getContentPane().add(mainPanel);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}