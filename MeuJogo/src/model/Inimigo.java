package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import controller.ControlePintura;

public class Inimigo extends Sprite{

	public Inimigo(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco) {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);
	}

	@Override
	public void animar(String direcao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);
	}

	@Override
	public void mover(String direcao) {
//		if (direcao.equalsIgnoreCase("true")) {
//			
//			if (getY() > 100)
//				setY(getY() + 1); 
//			else
//				setY(getY() - 1);
//		}
	}
	
//	public boolean colisao(Rectangle tmp) {
//		System.out.println(tmp);
//		Rectangle inimigo = new Rectangle(getX(), getY(), 
//				getLarguraPersonagem(), getAlturaPersonagem());
//		if(tmp.intersects(inimigo)){
//			return true;
//		}
//		return false;
//	}



}
