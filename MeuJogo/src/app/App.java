package app;

import controller.ControlePersonagem;
import controller.ControlePintura;
import model.Camada;
import model.Personagem;
import view.Tela;

public class App {
	public static void main(String[] args) {
		Tela tela = new Tela();
		Camada camadaFundo = new Camada(16, 16, 32, 32, "res/tiled.png", "fundo.txt");
		Camada camadaColisao = new Camada(16, 16, 32, 32, "res/tiled.png", "colisao.txt");
		Camada camadaTopo = new Camada(16, 16, 32, 32, "res/tiled.png", "topo.txt");
		Personagem personagem = new Personagem(0, 128, 96, 4, 3, 236, 236, "personagem.png");
		
		ControlePintura controlePintura = new ControlePintura(tela.getMapa(), personagem, camadaFundo, camadaColisao, camadaTopo);
		ControlePersonagem controlePersonagem = new ControlePersonagem(tela.getMapa(), personagem);
		tela.addKeyListener(controlePersonagem);
	}
}
