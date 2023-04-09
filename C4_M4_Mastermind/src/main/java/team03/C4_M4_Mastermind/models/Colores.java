package team03.C4_M4_Mastermind.models;

import java.awt.Color;

public class Colores {
	protected static Color[] COLORES_BASE = { Color.RED, Color.pink, Color.yellow, Color.green, Color.black, Color.gray,
			Color.blue, Color.orange, Color.magenta, Color.cyan };
	protected static int PARTIDAS_INICIALES = 0;

	protected Color[] arrCol;
	protected int partidas;

	/**
	 * 
	 */
	public Colores() {
		this.arrCol = COLORES_BASE;
		this.partidas = PARTIDAS_INICIALES;
	}

	/**
	 * @return the arrCol
	 */
	public Color[] getArrCol() {
		return arrCol;
	}

	/**
	 * @param arrCol the arrCol to set
	 */
	public void setArrCol(Color[] arrCol) {
		this.arrCol = arrCol;
	}

	/**
	 * @return the partidas
	 */
	public int getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(int partidas) {
		this.partidas = partidas;
	}

}
