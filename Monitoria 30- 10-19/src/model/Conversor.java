package model;

public class Conversor {

	public int parseNegativo(int i) throws MinhaException{
		
		if(i <= 0)
			throw new MinhaException("N�mero negativo ou igual a zero");
		return i * -1;
	}
	
}
