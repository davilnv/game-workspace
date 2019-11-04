package interativo.model;

import interativo.view.Tela;

public class Interativo {
	
	private boolean jogando = true;
	private final int FPS = 1000 / 20; // 50
	
	public void inicia(Tela tela) {
		long prxAtualizacao = 0;
		while (jogando) {
			if (System.currentTimeMillis() >= prxAtualizacao) {
				tela.repaint();
				prxAtualizacao = System.currentTimeMillis() + FPS;
			}
		}
	}

	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}
	
}
