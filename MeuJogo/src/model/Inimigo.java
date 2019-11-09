package model;

import java.awt.Rectangle;
import java.util.List;

import controller.ControlePintura;

public class Inimigo {
	int px, py;
	int largura, altura;
	String teste;
	
	public Inimigo(int px, int py, String teste) {
		super();
		this.px = px;
		this.py = py;
		this.teste = teste;
	}
	
	public boolean collision(List<Rectangle> tmp, int x,int y) {

		Rectangle personagem = new Rectangle(px+x+5, py+y+5, 
				largura-10, altura-10);
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
				return true;
			}
		}
		return false;
	}

	//metodos para tratar colis�o Y
	@Override
	public void setX(int x) {
		if(!collision(ControlePintura.colisao, x-px, 0))
			px = x;

	}

	//metodos para tratar colis�o X	
	@Override
	public void setY(int y) {
		if(!collision(ControlePintura.colisao, 0, y-getY()))
			super.setY(y);
	}


}
