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

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormSpecs;

public class vista extends JFrame {
//Variables globales (las usamos en todas las partes del proyecto)
	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JButton btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6;
	private JButton btn1e, btn2e, btn3e, btn4e;
	private JCheckBoxMenuItem chckbxmntmMostrarSolucion;
	private JPanel panelColores, panelSolucion;
	private JMenuItem mntmAyuda, mntmInformacion;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_2;
	private JButton comp;
	private JPanel panel = new JPanel();

	JButton[] btnSelecionados = new JButton[4];

	private Color[] arrayDificultad;
	private Color[] arraySolucion;
	private Color[] arrCol = { Color.RED, Color.pink, Color.yellow, Color.green, Color.black, Color.gray, Color.blue,
			Color.orange, Color.magenta, Color.cyan };

	final ArrayList<JButton> botones = new ArrayList<>();

	private int numIntentos = 0;

	final ActionListener cambiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton) e.getSource();

			int con = 0;
			for (int i = 0; i < arrayDificultad.length - 1; i++) {
				if (jb.getBackground().equals(arrayDificultad[i])) {
					con = i + 1;
				}
			}
			jb.setBackground(arrayDificultad[(con)]);

		}
	};

	public vista(int intentos, int colores) {
		//Creación de la parte visual (Paneles, Botones y menus)
		arrayDificultad = new Color[colores];
		arraySolucion = new Color[4];
		setIconImage(Toolkit.getDefaultToolkit().getImage(vista.class.getResource("/imagenes/icono.png")));
		setTitle("MasterMind"); // Ponemos el título de la ventana de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);


		// ------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------
		panelSolucion = new JPanel();
		panelSolucion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Combinaci\u00F3n secreta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSolucion.setBounds(717, 176, 252, 68);
		contentPane1.add(panelSolucion);
		panelSolucion.setLayout(null);

		btn1e = new JButton("");
		btn1e.setBounds(10, 23, 30, 30);
		panelSolucion.add(btn1e);
		btn1e.setEnabled(false);

		btn2e = new JButton("");
		btn2e.setBounds(50, 23, 30, 30);
		panelSolucion.add(btn2e);
		btn2e.setEnabled(false);

		btn3e = new JButton("");
		btn3e.setBounds(90, 23, 30, 30);
		panelSolucion.add(btn3e);
		btn3e.setEnabled(false);

		btn4e = new JButton("");
		btn4e.setBounds(130, 23, 30, 30);
		panelSolucion.add(btn4e);
		btn4e.setEnabled(false);

		panelColores = new JPanel();
		panelColores.setLayout(null);
		panelColores.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Colores disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelColores.setBounds(717, 86, 252, 68);
		contentPane1.add(panelColores);

		btnColor1 = new JButton("");
		btnColor1.setBounds(10, 23, 30, 30);
		panelColores.add(btnColor1);
		btnColor1.setVisible(false);
		btnColor1.setEnabled(false);

		btnColor2 = new JButton("");
		btnColor2.setBounds(50, 23, 30, 30);
		panelColores.add(btnColor2);
		btnColor2.setVisible(false);
		btnColor2.setEnabled(false);

		btnColor3 = new JButton("");
		btnColor3.setBounds(90, 23, 30, 30);
		panelColores.add(btnColor3);
		btnColor3.setVisible(false);
		btnColor3.setEnabled(false);

		btnColor4 = new JButton("");
		btnColor4.setBounds(130, 23, 30, 30);
		panelColores.add(btnColor4);
		btnColor4.setVisible(false);
		btnColor4.setEnabled(false);

		btnColor5 = new JButton("");
		btnColor5.setBounds(170, 23, 30, 30);
		panelColores.add(btnColor5);
		btnColor5.setVisible(false);
		btnColor5.setEnabled(false);

		btnColor6 = new JButton("");
		btnColor6.setBounds(210, 23, 30, 30);
		panelColores.add(btnColor6);
		btnColor6.setEnabled(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1026, 31);
		contentPane1.add(menuBar);

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

		btnSelecionados[0] = btn1e;
		btnSelecionados[1] = btn2e;
		btnSelecionados[2] = btn3e;
		btnSelecionados[3] = btn4e;

		panel.setBounds(30, 58, 662, 603);
		contentPane1.add(panel);
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("25dlu"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("25dlu"), FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("25dlu"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("25dlu"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, ColumnSpec.decode("50dlu"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("25dlu"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("25dlu"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("25dlu"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("25dlu"), FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		btnNewButton = new JButton();
		panel.add(btnNewButton, "1, 4, 2, 2");
		btnNewButton.setBackground(Color.white);

		btnNewButton_1 = new JButton();
		panel.add(btnNewButton_1, "3, 4, 2, 2");
		btnNewButton_1.setBackground(Color.white);

		btnNewButton_2 = new JButton();
		panel.add(btnNewButton_2, "5, 4, 2, 2");
		btnNewButton_2.setBackground(Color.white);
		botones.add(btnNewButton);

		btnNewButton_2.addActionListener(cambiar);
		btnColor6.setVisible(false);

		botones.add(btnNewButton_1);
		botones.add(btnNewButton_2);

		btnNewButton_3 = new JButton();
		panel.add(btnNewButton_3, "7, 4, 2, 2");
		btnNewButton_3.setBackground(Color.white);
		botones.add(btnNewButton_3);

		comp = new JButton("Comprovar");
		comp.setBounds(717, 273, 252, 43);
		contentPane1.add(comp);

		comp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(botones.get(botones.size()-4).getBackground());
				if (intentos > numIntentos) {
					numIntentos++;

					if (botones.get(botones.size() - 4).getBackground().equals(arraySolucion[0])
							&& botones.get(botones.size() - 3).getBackground().equals(arraySolucion[1])
							&& botones.get(botones.size() - 2).getBackground().equals(arraySolucion[2])
							&& botones.get(botones.size() - 1).getBackground().equals(arraySolucion[3])) {
						JLabel label = new JLabel("<html><h1>¡Felicidades, has ganado!</h1></html>");
						label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
						JOptionPane.showMessageDialog(contentPane1, label);
					} else {

						int blanco = 0;

						int negro = 0;

						for (int i = 0; i < botones.size(); i++) {
							boolean neg = true;
							for (int j = 0; j < btnSelecionados.length; j++) {
								if (neg && botones.get(i).getBackground().equals(btnSelecionados[i].getBackground())) {
									negro++;
									neg = false;

								} else if (botones.get(i).getBackground().equals(btnSelecionados[j].getBackground())) {

									blanco++;

								}
							}

						}
						int[] negras = new int[4]; // Array para almacenar los colores correctos y en su posición
						int[] blancas = new int[4]; // Array para almacenar los colores correctos pero en una posición
													// incorrecta
						int numNegras = 0; // Contador para el número de colores correctos y en su posición
						int numBlancas = 0; // Contador para el número de colores correctos pero en una posición
											// incorrecta

						// Comprobando las negras
						for (int i = 0; i < 4; i++) {
							if (botones.get(i).getBackground().equals(btnSelecionados[i].getBackground())) {
								negras[numNegras] = 1; // Añadimos un "1" al array de negras
								numNegras++; // Incrementamos el contador de negras
							}
						}

						// Comprobando las blancas
						for (int i = 0; i < 4; i++) {
							if (!botones.get(i).getBackground().equals(btnSelecionados[i].getBackground())) { // Si el color no está en su posición correcta
								for (int j = 0; j < 4; j++) { // Buscamos si está en otra posición
									if (botones.get(i).getBackground().equals(btnSelecionados[j].getBackground()) && negras[j] != 1 && blancas[j] != 1) {
										blancas[numBlancas] = 1; // Añadimos un "1" al array de blancas
										numBlancas++; // Incrementamos el contador de blancas
										break; // Salimos del bucle interior para no contar dos veces un mismo color
									}
								}
							}
						}

						// Creando los PictureBox con color negro para las negras

						System.out.println(blanco + "" + negro);

						crear(botones, arrayDificultad);
					}
				} else {
					System.out.println("Intentos maximos usados");
				}
			}
		});
		btnNewButton_3.addActionListener(cambiar);

		btnNewButton.addActionListener(cambiar);
		btnNewButton_1.addActionListener(cambiar);

		mntmInformacion.addActionListener(mostrarInformacion);

		setVisible(true);
//Creamos arrays de colores y botones (para despues correlacionarlos unos con otros)
		Color arrayDificultad[] = new Color[colores];
		Color arraySolucion[] = new Color[4];
		Color[] arrCol = { Color.RED, Color.pink, Color.yellow, Color.green, Color.black, Color.gray, Color.blue,
				Color.orange, Color.magenta, Color.cyan };

		JButton[] btnColoresDisponibles = { btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6 };
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Generamos los colores según la dificultad escojida, con colores unicos del
		// array
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

		// Generamos los colores escojidos por le ordenador como solucion, puede
		// contener dos valores iguales
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

	// Mostrar informacion sobre el proyecto y sobre el juego 
	
	ActionListener mostrarInformacion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JLabel label = new JLabel("<html><h1>MASTER MIND</h1>"
					+ "<p>Aplicaión desarrollada por el team 03 (Alejandro, Arnau y Paul)</p>"
					+ "<p>Más información en el repositorio de git</p>"
					+ "<p style=\"color:blue\">https://github.com/paul-23/c4-m4-team03-mastermind</p>" + "</html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane1, label);
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

	@SuppressWarnings("deprecation")
	private void crear(ArrayList<JButton> botones, Color[] arrCol) {
		// TODO Auto-generated method stub
		if (!botones.isEmpty()) {
			botones.get(botones.size() - 4).setEnabled(false);
			botones.get(botones.size() - 3).setEnabled(false);
			botones.get(botones.size() - 2).setEnabled(false);
			botones.get(botones.size() - 1).setEnabled(false);
		}

		JButton bot1 = new JButton();
		panel.add(bot1, "1, " + (4 + (botones.size() / 2)) + ", center, center");
		bot1.addActionListener(cambiar);

		JButton bot2 = new JButton();
		panel.add(bot2, "3, " + (4 + (botones.size() / 2)) + ", center, center");
		bot2.addActionListener(cambiar);

		JButton bot3 = new JButton();
		panel.add(bot3, "5," + (4 + (botones.size() / 2)) + ", center, center");
		bot3.addActionListener(cambiar);

		JButton bot4 = new JButton();
		panel.add(bot4, "7," + (4 + (botones.size() / 2)) + ", center, center");
		bot4.addActionListener(cambiar);
//		setContentPane(bot4);

		bot1.setBackground(Color.white);
		bot2.setBackground(Color.white);
		bot3.setBackground(Color.white);
		bot4.setBackground(Color.white);
		botones.add(bot1);
		botones.add(bot2);
		botones.add(bot3);
		botones.add(bot4);
		// bot1.setBounds(intx, inty, width, height);
		bot1.setBounds(10, 50 + (botones.size() * 10), 30, 30);
		bot2.setBounds(40, 50 + (botones.size() * 10), 30, 30);
		bot3.setBounds(70, 50 + (botones.size() * 10), 30, 30);
		bot4.setBounds(100, 50 + (botones.size() * 10), 30, 30);
//		System.out.println(botones.size());

	}

}
