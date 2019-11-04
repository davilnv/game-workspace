package interativo.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import interativo.model.Interativo;
import interativo.view.Tela;

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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int tecla = e.getKeyCode();
				switch (tecla) {
				case KeyEvent.VK_ESCAPE	:
					// Tecla ESC
					interativo.setJogando(false);
					System.exit(0);
					break;
				case KeyEvent.VK_UP:
					tela.setPy(tela.getPy() - 10);
					break;
				case KeyEvent.VK_DOWN:
					tela.setPy(tela.getPy() + 10);
					break;
				case KeyEvent.VK_LEFT:
					tela.setPx(tela.getPx() - 10);
					break;
				case KeyEvent.VK_RIGHT:
					tela.setPx(tela.getPx() + 10);
					break;
				}
			}
		});
	}
	
}
