package app;

import controle.ControlePersonagem;
import controle.ControlePintura;
import model.Camada;
import model.Personagem;
import view.Tela;

public class App {

	
	public static void main(String[] args) {
		
		Tela tela = new Tela();
		Camada camadaFundo = new Camada(32, 32, 32, 32, "res/tiled.png", "fundo.txt");
		Camada camadaColisao = new Camada(32, 32, 32, 32, "res/tiled.png", "colisao.txt");
		Camada camadaTopo = new Camada(32, 32, 32, 32, "res/tiled.png", "topo.txt");
		Personagem personagem = new Personagem(250, 400, 30, 30);
		
		ControlePintura controlePintura = new ControlePintura(tela.getMapa(), personagem, camadaFundo, camadaColisao, camadaTopo);
		ControlePersonagem controlePersonagem = new ControlePersonagem(tela.getMapa(), personagem);
		tela.addKeyListener(controlePersonagem);
	}
	
	
}
