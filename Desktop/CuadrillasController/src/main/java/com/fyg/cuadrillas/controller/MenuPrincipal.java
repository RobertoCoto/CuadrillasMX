package com.fyg.cuadrillas.controller;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MenuPrincipal extends JFrame {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 3272081412173424764L;
	public static void menuPrincipal() {
		JFrame frame = new JFrame("Menú Principal - TATEI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(700, 550));
        frame.pack();
        frame.setVisible(true);
	}
	//metodo principal
		public static void main(String[] args) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	menuPrincipal();
	            }
	        });
		}
}
