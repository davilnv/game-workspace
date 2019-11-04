package interativoMouse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterativoMouse extends JFrame{
	private JPanel tela;
	private int px, py;
	private Point mouseClick = new Point();
	private boolean jogando = true;
	private final int FPS = 1000 / 20; // 50
	
	public InterativoMouse() {
		tela = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, getWidth(), getHeight());
				
				int x = getWidth() / 2 - 20 + px;
				int y = getHeight() / 2 - 20 + py;
				
				g.setColor(Color.BLUE);
				g.fillRect(x, y, 40, 40);
				g.drawString("Agora estou em " + x +"x" + y, 5, 10);
				
			}
		};
		
		tela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClick = e.getPoint();
			}
		});
		
		getContentPane().add(tela);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setVisible(true);
	}
	
	public void inicia() {
		long prxAtualizacao = 0;
		while (true) {
			if (System.currentTimeMillis() >= prxAtualizacao) {
				repaint();
				prxAtualizacao = System.currentTimeMillis() + FPS;
			}
		}
	}
	
	private void atualizaJogo() {
		px = mouseClick.x;
		py = mouseClick.y;
	}
	
	public static void main(String[] args) {
		InterativoMouse jogo = new InterativoMouse();
		jogo.inicia();
	}
	
}
