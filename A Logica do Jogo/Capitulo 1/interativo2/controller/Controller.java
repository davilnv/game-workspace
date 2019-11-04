package interativo2.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import interativo2.model.Interativo;
import interativo2.view.Tela;

public class Controller{
	private Tela tela;
	public Interativo interativo;
	
	public Controller(Tela tela, Interativo interativo) {
		this.tela = tela;
		this.interativo = interativo;
		tela.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				setaTecla(e.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				setaTecla(e.getKeyCode(), true);
			}
		});
	}

	private void setaTecla(int tecla, boolean pressionada) {
		switch (tecla) {
		case KeyEvent.VK_ESCAPE:
			interativo.setJogando(false);
			System.exit(0);
			break;
		
		case KeyEvent.VK_UP:
			interativo.setarControleTecla(pressionada, 0);
			break;
		
		case KeyEvent.VK_DOWN:
			interativo.setarControleTecla(pressionada, 1);
			break;
		
		case KeyEvent.VK_LEFT:
			interativo.setarControleTecla(pressionada, 2);
			break;
			
		case KeyEvent.VK_RIGHT:
			interativo.setarControleTecla(pressionada, 3);
			break;
		default:
			break;
		}
	}
}
