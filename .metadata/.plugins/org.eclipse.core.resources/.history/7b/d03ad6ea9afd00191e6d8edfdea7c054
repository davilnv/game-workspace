package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Personagem;
import view.Mapa;

public class ControlePersonagem extends Thread implements KeyListener {

	private Personagem personagem;
	private Mapa mapa;

	public ControlePersonagem(Mapa mapa, Personagem personagem) {
		this.personagem = personagem;
		this.mapa = mapa;
		
		mapa.addKeyListener(this);
	}

	@Override
	public void run() {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP:
			personagem.setY(personagem.getY() - 5);
			break;
		case KeyEvent.VK_DOWN:
			personagem.setY(personagem.getY() + 5);
			break;
		case KeyEvent.VK_LEFT:
			personagem.setX(personagem.getX() - 5);
			break;
		case KeyEvent.VK_RIGHT:
			personagem.setX(personagem.getX() + 5);
			break;

		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
