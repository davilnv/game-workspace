package interativo2.app;

import interativo2.controller.Controller;
import interativo2.model.Interativo;
import interativo2.view.Tela;

public class App {
	public static void main(String[] args) {
		Tela tela = new Tela();
		Interativo interativo = new Interativo();
		Controller controle = new Controller(tela, interativo);
		controle.interativo.inicia(tela);
	}
}
