package umJogo.model;

import java.util.Random;

import umJogo.view.Tela;

public class BaseJogo {
	private final int FPS = 1000 / 20; // 50
	private boolean jogando = true;
	private boolean fimDeJogo = false;
	
	private Elemento tiro;
	private Elemento jogador;
	private Elemento[] blocos;
	
	private int pontos;
	private int larg = 50; // Largura padrão
	private int linhaLimite = 350;
	private Random r = new Random();

	private boolean[] controleTecla = new boolean[4];
	
	public BaseJogo() {
		tiro = new Elemento(0, 0, 1, 0);
		jogador = new Elemento(0, 0, larg, larg);
		jogador.velocidade = 5;
		
		blocos = new Elemento[5];
		for (int i = 0; i < blocos.length; i++) {
			int espaco = i * larg + 10 * (i + 1);
			blocos[i] = new Elemento(espaco, 0, larg, larg);
			blocos[i].velocidade = 1;
		}
	}
	
	public void setarControleTecla(boolean pressionada, int index) {
		controleTecla[index] = pressionada;
	}
	
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
	
	//Parei Aqui
	
	public void atualizaJogo(Tela tela) {
		if (controleTecla[0])
			tela.setPy(tela.getPy() - 10);
		else if (controleTecla[1])
			tela.setPy(tela.getPy() + 10);
		if (controleTecla[2])
			tela.setPx(tela.getPx() - 10);
		else if (controleTecla[3])
			tela.setPx(tela.getPx() + 10);
	}

	public boolean isJogando() {
		return jogando;
	}


	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}


	public boolean isFimDeJogo() {
		return fimDeJogo;
	}


	public void setFimDeJogo(boolean fimDeJogo) {
		this.fimDeJogo = fimDeJogo;
	}


	public Elemento getTiro() {
		return tiro;
	}


	public void setTiro(Elemento tiro) {
		this.tiro = tiro;
	}


	public Elemento getJogador() {
		return jogador;
	}


	public void setJogador(Elemento jogador) {
		this.jogador = jogador;
	}


	public Elemento[] getBlocos() {
		return blocos;
	}


	public void setBlocos(Elemento[] blocos) {
		this.blocos = blocos;
	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}


	public int getLarg() {
		return larg;
	}


	public void setLarg(int larg) {
		this.larg = larg;
	}


	public int getLinhaLimite() {
		return linhaLimite;
	}


	public void setLinhaLimite(int linhaLimite) {
		this.linhaLimite = linhaLimite;
	}
	
	
}
