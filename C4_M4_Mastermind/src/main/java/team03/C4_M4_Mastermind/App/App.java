package team03.C4_M4_Mastermind.App;

import java.awt.EventQueue;

import team03.C4_M4_Mastermind.DificultdadUsuario;

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
