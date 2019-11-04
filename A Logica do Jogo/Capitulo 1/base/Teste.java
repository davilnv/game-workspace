package base;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Teste extends JFrame{
	private JPanel tela;
	
	public Teste() {
		tela = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(Color.BLACK);
				//g.drawLine(10, 0, 10, 500); // Linha Vertical
				for (int i = 10; i < 500; i+=10) {
					g.drawLine(i, 0, i, 500);
				}
				
				// g.drawLine(0, 10, 500, 10); // Linha Horizontal
				
				for (int i = 10; i < 500; i+=10) {
					g.drawLine(0, i, 500, i);
				}
				
				g.setColor(Color.RED);
				g.fillRect(50, 50, 50, 50);
			}
		};
		
		getContentPane().add(tela);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		tela.repaint();
	}
	
	public static void main(String[] args) {
		new Teste();
	}
}
