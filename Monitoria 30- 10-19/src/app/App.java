package app;

import model.MinhaException;
import model.Conversor;

public class App {

	public static void main(String[] args) {

		Conversor c = new Conversor();
		
		try {//onde possivelmente ocorrer� a exce��o
			System.out.println(c.parseNegativo(-9));
		} catch (MinhaException e) {//onde ser� tratado a exce��o
			e.printStackTrace();
		}
		finally {//sempre ser� executado
			System.out.println("Final");
		}
		
	}

}
