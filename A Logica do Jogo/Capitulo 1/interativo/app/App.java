package interativo.app;

import interativo.controller.Controller;
import interativo.model.Interativo;
import interativo.view.Tela;

public class App {
	public static void main(String[] args) {
		Tela tela = new Tela();
		Interativo interativo = new Interativo();
		Controller controle = new Controller(tela, interativo);
		controle.interativo.inicia(tela);
	}
}
