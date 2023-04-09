package team03.C4_M4_Mastermind.App;

import java.awt.EventQueue;

import team03.C4_M4_Mastermind.DificultdadUsuario;
import team03.C4_M4_Mastermind.models.Colores;

public class App 
{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Colores datosCompartidos = new Colores();
					new DificultdadUsuario(datosCompartidos);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
