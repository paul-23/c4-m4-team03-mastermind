package team03.C4_M4_Mastermind;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import team03.C4_M4_Mastermind.models.Colores;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class CambioColores extends JFrame {

	private Colores coloresDefault;

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Color[] arrayColores;
	private JButton btnColor, btnAceptar, btnCancelar;
	private JButton[] btnColoresBlancos;
	boolean comprobacion = false;
	int numIntentos, numColores;

	public CambioColores(int intentos, int colores, Colores datosCompartidos) {
		coloresDefault = datosCompartidos;
		numIntentos = intentos;
		numColores = colores;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CambioColores.class.getResource("/team03/C4_M4_Mastermind/assets/iconoG.png")));
		setTitle("Cambio colores");
		setBounds(100, 100, 486, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 242, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelColores = new JPanel();
		panelColores.setLayout(null);
		panelColores.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Colores disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelColores.setBackground(new Color(215, 242, 255));
		panelColores.setBounds(48, 99, 375, 82);
		contentPane.add(panelColores);

		JLabel lblNewLabel = new JLabel("COLORES DISPONIBLES");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel.setBounds(61, 32, 349, 50);
		contentPane.add(lblNewLabel);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 102, 153));
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAceptar.setBounds(50, 221, 180, 43);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(al);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setForeground(new Color(0, 102, 153));
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(242, 221, 180, 43);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(al);

		setVisible(true);
		arrayColores = new Color[colores];

		btnColoresBlancos = new JButton[colores];
		int distanciaBotonesColor = 15;
		for (int i = 0; i < colores; i++) {
			btnColor = new JButton("");
			btnColor.setBounds(distanciaBotonesColor, 23, 45, 45);
			panelColores.add(btnColor);
			btnColor.setBackground(Color.WHITE);
			btnColor.addActionListener(changeColor);
			btnColoresBlancos[i] = btnColor;
			distanciaBotonesColor = distanciaBotonesColor + 60;
		}
	}

	ActionListener changeColor = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btnAux = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(btnAux, "Escoge un color", btnAux.getBackground());
			btnAux.setBackground(newColor);
			for (int i = 0; i < btnColoresBlancos.length; i++) {
				arrayColores[i] = btnColoresBlancos[i].getBackground();
			}
		}
	};

	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAceptar) {
				comprobar();
			} else if (e.getSource() == btnCancelar) {
				setVisible(false);
				new vista(coloresDefault.getPartidas(), numColores, coloresDefault);
			}
		}
	};

	public void comprobar() {
		if (comprobarColorBlanco()) {
			JLabel label = new JLabel("<html><h1>Selecciona todos los colores</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane, label, "Faltan colores", JOptionPane.INFORMATION_MESSAGE);
		} else if (comprobarDuplicados()) {
			JLabel label = new JLabel(
					"<html><h1>Selecciona colores diferentes. Has indicado dos colores iguales.</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane, label, "Colores duplicados", JOptionPane.INFORMATION_MESSAGE);
		} else {
			coloresDefault.setArrCol(arrayColores);
			comprobacion = true;
			setVisible(false);
			new vista(coloresDefault.getPartidas(), numColores, coloresDefault);
		}
	}

	public boolean comprobarColorBlanco() {
		boolean blanco = false;
		for (int i = 0; i < btnColoresBlancos.length; i++) {
			if (btnColoresBlancos[i].getBackground() == Color.WHITE) {
				blanco = true;
				break;
			}
		}
		return blanco;
	}

	public boolean comprobarDuplicados() {
		ArrayList<Color> colorList = new ArrayList<Color>();
		for (Color color : arrayColores) {
			if (colorList.contains(color)) {
				return true;
			}
			colorList.add(color);
		}
		return false;
	}
}
