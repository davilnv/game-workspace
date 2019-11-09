package umJogo.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import umJogo.model.BaseJogo;
import umJogo.model.Elemento;

public class Tela extends JFrame{
	private int px, py;
	
	private JPanel tela;
	private BaseJogo baseJogo;
	
	public Tela() {
		tela = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, tela.getWidth(), tela.getHeight());
				
				g.setColor(Color.RED);
				g.fillRect(baseJogo.getTiro().x, baseJogo.getTiro().y, 
						baseJogo.getTiro().largura, tela.getHeight());
				
				g.setColor(Color.GREEN);
				g.fillRect(baseJogo.getJogador().x, baseJogo.getJogador().y,
						baseJogo.getJogador().largura, baseJogo.getJogador().altura);
				
				g.setColor(Color.BLUE);
				for (Elemento bloco : baseJogo.getBlocos()) {
					g.fillRect(bloco.x, bloco.y, bloco.largura, bloco.altura);
				}
				
				g.setColor(Color.GRAY);
				g.drawLine(0, baseJogo.getLinhaLimite(), tela.getWidth(), tela.getHeight());
				
				g.drawString("Pontos: " + baseJogo.getPontos(), 0, 10);
			}
		};
		
		getContentPane().add(tela);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		setVisible(true);
		
		baseJogo.getJogador().x = tela.getWidth() / 2 - baseJogo.getJogador().x / 2;
		baseJogo.getJogador().y = tela.getHeight() - baseJogo.getJogador().altura;
		baseJogo.getTiro().altura = tela.getHeight() - baseJogo.getJogador().altura;
	}

	public int getPx() {
		return px;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}
	
	
}
