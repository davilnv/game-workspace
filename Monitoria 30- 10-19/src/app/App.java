package app;

import model.MinhaException;
import model.Conversor;

public class App {

	public static void main(String[] args) {

		Conversor c = new Conversor();
		
		try {//onde possivelmente ocorrerá a exceção
			System.out.println(c.parseNegativo(-9));
		} catch (MinhaException e) {//onde será tratado a exceção
			e.printStackTrace();
		}
		finally {//sempre será executado
			System.out.println("Final");
		}
		
	}

}
