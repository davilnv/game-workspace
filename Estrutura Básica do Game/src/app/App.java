package app;

import controller.Run;
import game.Game;

public class App {
	public static void main(String[] args) {
		Game game = new Game();
		Run rodar = new Run();
		rodar.run(game);
	}
}
