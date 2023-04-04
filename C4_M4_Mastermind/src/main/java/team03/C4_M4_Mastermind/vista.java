package team03.C4_M4_Mastermind;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Toolkit;

public class vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6;
	private JButton btn1, btn2, btn3, btn4;
	private JCheckBoxMenuItem chckbxmntmMostrarSolucion;
	private JPanel panelColores, panelSolucion;
	private JMenuItem mntmAyuda, mntmInformacion;

	public vista(int intentos, int colores) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(vista.class.getResource("/imagenes/icono.png")));
		setTitle("MasterMind"); // Ponemos el título de la ventana de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelSolucion = new JPanel();
		panelSolucion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Combinaci\u00F3n secreta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSolucion.setBounds(717, 176, 252, 68);
		contentPane.add(panelSolucion);
		panelSolucion.setLayout(null);

		btn1 = new JButton("");
		btn1.setBounds(10, 23, 30, 30);
		panelSolucion.add(btn1);

		btn2 = new JButton("");
		btn2.setBounds(50, 23, 30, 30);
		panelSolucion.add(btn2);

		btn3 = new JButton("");
		btn3.setBounds(90, 23, 30, 30);
		panelSolucion.add(btn3);

		btn4 = new JButton("");
		btn4.setBounds(130, 23, 30, 30);
		panelSolucion.add(btn4);

		panelColores = new JPanel();
		panelColores.setLayout(null);
		panelColores.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Colores disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelColores.setBounds(717, 86, 252, 68);
		contentPane.add(panelColores);

		btnColor1 = new JButton("");
		btnColor1.setBounds(10, 23, 30, 30);
		panelColores.add(btnColor1);
		btnColor1.setVisible(false);

		btnColor2 = new JButton("");
		btnColor2.setBounds(50, 23, 30, 30);
		panelColores.add(btnColor2);
		btnColor2.setVisible(false);

		btnColor3 = new JButton("");
		btnColor3.setBounds(90, 23, 30, 30);
		panelColores.add(btnColor3);
		btnColor3.setVisible(false);

		btnColor4 = new JButton("");
		btnColor4.setBounds(130, 23, 30, 30);
		panelColores.add(btnColor4);
		btnColor4.setVisible(false);

		btnColor5 = new JButton("");
		btnColor5.setBounds(170, 23, 30, 30);
		panelColores.add(btnColor5);
		btnColor5.setVisible(false);

		btnColor6 = new JButton("");
		btnColor6.setBounds(210, 23, 30, 30);
		panelColores.add(btnColor6);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1026, 31);
		contentPane.add(menuBar);

		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);

		chckbxmntmMostrarSolucion = new JCheckBoxMenuItem("Mostrar Solución");
		chckbxmntmMostrarSolucion.setSelected(true);
		mnOpciones.add(chckbxmntmMostrarSolucion);
		chckbxmntmMostrarSolucion.addActionListener(mostrarSolucion);

		JMenu mnAbout = new JMenu("Ayuda");
		menuBar.add(mnAbout);

		mntmAyuda = new JMenuItem("Ayuda");
		mnAbout.add(mntmAyuda);

		mntmAyuda.addActionListener(mostrarAyuda);

		mntmInformacion = new JMenuItem("Información");
		mnAbout.add(mntmInformacion);
		btnColor6.setVisible(false);

		mntmInformacion.addActionListener(mostrarInformacion);

		setVisible(true);

		Color arrayDificultad[] = new Color[colores];
		Color arraySolucion[] = new Color[4];
		Color[] arrCol = { Color.RED, Color.pink, Color.yellow, Color.green, Color.black, Color.gray, Color.blue,
				Color.orange, Color.magenta, Color.cyan };
		JButton[] btnColoresDisponibles = { btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6 };
		JButton[] btnSelecionados = { btn1, btn2, btn3, btn4 };
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Generamos los colores según la dificultad escojida, con colores unicos del array
		int num = 0;
		while (numbers.size() < colores) {
			int randomNumber = (int) Math.round(Math.random() * 9);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
				arrayDificultad[num] = arrCol[randomNumber];
				btnColoresDisponibles[num].setBackground(arrayDificultad[num]);
				btnColoresDisponibles[num].setVisible(true);
				num++;
			}
		}

		// Generaamos los colores escojidos por le ordenador como solucion, puede contener dos valores iguales
		for (int i = 0; i < arraySolucion.length; i++) {
			int randomNumber = (int) Math.round(Math.random() * (arraySolucion.length - 1));
			Color colorSelec = arrayDificultad[randomNumber];
			arraySolucion[i] = colorSelec;

			// Asignamos los colores a los botones
			btnSelecionados[i].setBackground(arraySolucion[i]);
		}

	}

	ActionListener mostrarSolucion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (chckbxmntmMostrarSolucion.isSelected()) {
				panelSolucion.setVisible(true);
			} else {
				panelSolucion.setVisible(false);
			}
		}
	};

	// Cremos un metodo que no muestra un mensaje dentro de una alerta al pulsar el botón
	ActionListener mostrarInformacion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JLabel label = new JLabel("<html><h1>MASTER MIND</h1>"
					+ "<p>Aplicaión desarrollada por el team 03 (Alejandro, Arnau y Paul)</p>"
					+ "<p>Más información en el repositorio de git</p>"
					+ "<p style=\"color:blue\">https://github.com/paul-23/c4-m4-team03-mastermind</p>" + "</html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane, label);
		}
	};

	ActionListener mostrarAyuda = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Mastermind_(board_game)"));

			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	};
}
