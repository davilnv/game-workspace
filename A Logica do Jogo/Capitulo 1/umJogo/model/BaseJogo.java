package umJogo.model;

import java.util.Random;

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
}
