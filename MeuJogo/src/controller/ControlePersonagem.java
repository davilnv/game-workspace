package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Personagem;
import view.Mapa;

public class ControlePersonagem extends Thread implements KeyListener {

	private Personagem personagem;
	private Mapa mapa;
	private String direcao ="";
//	private boolean[] teclas = new boolean[4];

	public ControlePersonagem(Mapa mapa, Personagem personagem) {
		this.personagem = personagem;
		this.mapa = mapa;
		
		mapa.addKeyListener(this);
		
		start();
	}

	@Override
	public void run() {

		while(true) {
			try {
				personagem.mover(direcao);
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP:
			direcao = "cima";
			break;
		case KeyEvent.VK_DOWN:
			direcao = "baixo";
			break;
		case KeyEvent.VK_LEFT:
			direcao = "esquerda";
			break;
		case KeyEvent.VK_RIGHT:
			direcao = "direita";
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP:
			direcao = "";
			break;
		case KeyEvent.VK_DOWN:
			direcao = "";
			break;
		case KeyEvent.VK_LEFT:
			direcao = "";
			break;
		case KeyEvent.VK_RIGHT:
			direcao = "";
			break;

		default:
			break;
		}


	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
