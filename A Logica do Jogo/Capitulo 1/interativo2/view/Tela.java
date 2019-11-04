package interativo2.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame{
	JPanel tela;
	private int px, py;
	
	public Tela() {
		tela = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, getWidth(), getHeight());
				
				int x = getWidth() / 2 - 20 + px;
				int y = getHeight() / 2 - 20 + py;
				
				g.setColor(Color.BLUE);
				g.fillRect(x, y, 40, 40);
				g.drawString("Agora eu estou em " + x + "x" + y, 5, 10);
			}
		};
		getContentPane().add(tela);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
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
