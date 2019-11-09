package model;

import java.util.Random;

public class NumerosAleatorios {
	private static Random aleatorios = new Random();
	
	public static int gerarNumeroAleatorio() {
		return aleatorios.nextInt(10);
	}
}
