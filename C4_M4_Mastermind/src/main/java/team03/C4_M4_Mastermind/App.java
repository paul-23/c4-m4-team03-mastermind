package team03.C4_M4_Mastermind;

import java.awt.EventQueue;

public class App 
{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new DificultdadUsuario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
