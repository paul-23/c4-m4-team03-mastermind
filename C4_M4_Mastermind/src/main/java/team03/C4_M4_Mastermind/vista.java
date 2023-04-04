package team03.C4_M4_Mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public vista(int intentos, int colores) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(27, 25, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(126, 25, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(225, 25, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setBounds(335, 25, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		colores = 4;
	    Color array[] = new Color[colores];
	    Color[] arrCol = {Color.RED,Color.pink,Color.yellow,Color.green,Color.black,Color.gray,Color.blue,Color.orange,Color.magenta,Color.DARK_GRAY};
	  
	    setVisible(true);
	    
		int i = 0;
		if( i <= 1) {
		int randomNumber = (int) Math.round(Math.random()*colores);
			Color colorselecc = arrCol[randomNumber];
			btnNewButton.setBackground(colorselecc);
	        array[i] = colorselecc;

			i++;
		}
		 i = 0;
		if( i <= 1) {
			int randomNumber = (int) Math.round(Math.random()*colores);
				Color colorselecc = arrCol[randomNumber];
				btnNewButton_1.setBackground(colorselecc);
		        array[i] = colorselecc;

				i++;
			}
		 i = 0;
		if( i <= 1) {
			int randomNumber = (int) Math.round(Math.random()*colores);
				Color colorselecc = arrCol[randomNumber];
				btnNewButton_2.setBackground(colorselecc);
		        array[i] = colorselecc;

				i++;
			}
		 i = 0;
		if( i <= 1) {
			int randomNumber = (int) Math.round(Math.random()*colores);
				Color colorselecc = arrCol[randomNumber];
				btnNewButton_2_1.setBackground(colorselecc);
		        array[i] = colorselecc;

				i++;
			}
}	
	}

	


