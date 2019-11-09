package umJogo.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import umJogo.model.BaseJogo;
import umJogo.view.Tela;

public class Controller {
	private Tela tela;
	public BaseJogo baseJogo;
	
	public Controller(Tela tela, BaseJogo baseJogo) {
		this.tela = tela;
		this.baseJogo = baseJogo;
		tela.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
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
			baseJogo.setJogando(false);
			System.exit(0);
			break;
		case KeyEvent.VK_UP:
			baseJogo.setarControleTecla(pressionada, 0);
			break;
		case KeyEvent.VK_DOWN:
			baseJogo.setarControleTecla(pressionada, 1);
			break;
		case KeyEvent.VK_LEFT:
			baseJogo.setarControleTecla(pressionada, 2);
			break;
		case KeyEvent.VK_RIGHT:
			baseJogo.setarControleTecla(pressionada, 3);
		}
	}
}
