package interativo2.model;

import interativo2.view.Tela;

public class Interativo {
	
	private boolean jogando = true;
	private final int FPS = 1000 / 20; // 50
	private boolean[] controleTecla = new boolean[4];
	
	public void inicia(Tela tela) {
		long prxAtualizacao = 0;
		while (jogando) {
			if (System.currentTimeMillis() >= prxAtualizacao) {
				atualizaJogo(tela);
				tela.repaint();
				prxAtualizacao = System.currentTimeMillis() + FPS;
			}
		}
	}
	
	private void atualizaJogo(Tela tela) {
		if (controleTecla[0])
			tela.setPy(tela.getPy() - 10);
		else if (controleTecla[1])
			tela.setPy(tela.getPy() + 10);
		if (controleTecla[2])
			tela.setPx(tela.getPx() - 10);
		else if (controleTecla[3])
			tela.setPx(tela.getPx() + 10);
	}

	public void setarControleTecla(boolean pressionada, int index) {
		controleTecla[index] = pressionada;
	}

	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	
}
