package base;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CorridaQuadrados extends JFrame{
	private JPanel telaJPanel;
	private int fps = 1000 / 20; // 50
	private int cont, cont2;
	private boolean anima = true;
	
	public CorridaQuadrados() {
		telaJPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, telaJPanel.getWidth(), telaJPanel.getHeight());
				
				g.setColor(Color.RED);
				g.fillRect(10 + cont, 10, 50, 50);
				
				g.setColor(Color.BLUE);
				g.fillRect(10 + cont2, 70, 50, 50);
			}
		};
		getContentPane().add(telaJPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
		telaJPanel.repaint();
	}
	
	public void iniciaAnimacao() {
		long prxAtualizacao = 0;
		SecureRandom numerosAletorios = new SecureRandom();
		int num = 1 + numerosAletorios.nextInt(2);
		int num2 = 1 + numerosAletorios.nextInt(2); 
		while (anima) {
			if (System.currentTimeMillis() >= prxAtualizacao) {
				cont+= num;
				cont2 += num2;
				telaJPanel.repaint();
				
				prxAtualizacao = System.currentTimeMillis() + fps;
				if (cont == telaJPanel.getWidth())
					anima = false;
			}
		}
	}
	
	public static void main(String[] args) {
		CorridaQuadrados animacaoTeste = new CorridaQuadrados();
		animacaoTeste.iniciaAnimacao();
	}
}
