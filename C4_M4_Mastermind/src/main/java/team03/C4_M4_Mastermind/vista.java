package team03.C4_M4_Mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6;

	public vista(int intentos, int colores) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Combinaci\u00F3n secreta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(713, 130, 252, 68);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btn1 = new JButton("");
		btn1.setBounds(10, 23, 30, 30);
		panel.add(btn1);

		JButton btn2 = new JButton("");
		btn2.setBounds(50, 23, 30, 30);
		panel.add(btn2);

		JButton btn3 = new JButton("");
		btn3.setBounds(90, 23, 30, 30);
		panel.add(btn3);

		JButton btn4 = new JButton("");
		btn4.setBounds(130, 23, 30, 30);
		panel.add(btn4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Colores disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(713, 51, 252, 68);
		contentPane.add(panel_1);
		
		btnColor1 = new JButton("");
		btnColor1.setBounds(10, 23, 30, 30);
		panel_1.add(btnColor1);
		btnColor1.setVisible( false );
		
		btnColor2 = new JButton("");
		btnColor2.setBounds(50, 23, 30, 30);
		panel_1.add(btnColor2);
		btnColor2.setVisible( false );
		
		btnColor3 = new JButton("");
		btnColor3.setBounds(90, 23, 30, 30);
		panel_1.add(btnColor3);
		btnColor3.setVisible( false );
		
		btnColor4 = new JButton("");
		btnColor4.setBounds(130, 23, 30, 30);
		panel_1.add(btnColor4);
		btnColor4.setVisible( false );
		
		btnColor5 = new JButton("");
		btnColor5.setBounds(170, 23, 30, 30);
		panel_1.add(btnColor5);
		btnColor5.setVisible( false );
		
		btnColor6 = new JButton("");
		btnColor6.setBounds(210, 23, 30, 30);
		panel_1.add(btnColor6);
		btnColor6.setVisible( false );

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
				btnColoresDisponibles[num].setVisible( true );
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
}
