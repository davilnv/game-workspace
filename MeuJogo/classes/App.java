package app;

import controle.ControlePersonagem;
import controle.ControlePintura;
import model.TileMap;
import model.Personagem;
import view.Tela;

public class App {

	
	public static void main(String[] args) {
		
		Tela tela = new Tela();
		TileMap camadaFundo = new TileMap(32, 32, 16, 16, "atlas.png", "fundo.txt");
		TileMap camadaColisao = new TileMap(32, 32, 16, 16, "atlas.png", "colisao.txt");
		TileMap camadaTopo = new TileMap(32, 32, 16, 16, "atlas.png", "topo.txt");
		Personagem personagem = new Personagem(0, 168, 24, 7, 1, 400, 100, "player.png");
		
		ControlePintura controlePintura = new ControlePintura(tela.getMapa(), personagem, camadaFundo, camadaColisao, camadaTopo);
		ControlePersonagem controlePersonagem = new ControlePersonagem(tela.getMapa(), personagem);
		tela.addKeyListener(controlePersonagem);
	}
	
	
}
