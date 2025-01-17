package controller;

import game.Game;

public class Run {
	
	public void run(Game game) {
		game.inicializar();// AQUI CHAMAMOS O METODO INICIALIZAR SOMENTE UMA VEZ, POIS ELE ESTÁ FORA DO
						// NOSSO LOOP
		while (true) {// AQUI É O NOSSO LOOP INFINITO
			game.atualizar();// CHAMAMOS O METODO ATUALIZAR O TEMPO INTEIRO
			game.desenharGraficos();// ATUALIZAREMOS O GRÁFICO QUE APARECE NA TELA O TEMPO INTEIRO
			try {
				Thread.sleep(1000 / game.FPS); // TAXA DE ATUALIZAÇÃO NA TELA, FUNCIONA COMO UM DELAY
			} catch (Exception e) {
				System.out.println("Thread interrompida!");
			}
		}
	}
}
