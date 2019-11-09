package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import controle.ControlePintura;

public class Personagem extends Sprite {

	public Personagem(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco) {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void animar(String direcao) {
		setAparencia(getAparencia() + 1);
		
		if(getAparencia() > 6)
			setAparencia(0);

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);

	}

	@Override
	public void mover(String direcao) {
		System.out.println(direcao);
		switch (direcao) {
		case "cima":
			setY(getY() - 5);
			break;
		case "baixo":
			setY(getY() + 5);
			break;
		case "esquerda":
			setX(getX() - 5);
			break;
		case "direita":
			setX(getX() + 5);
			break;
		}
		
		if(!direcao.equals(""))
			animar(direcao);
	}

	//metodos para tratar colisão
	public boolean collision(List<Rectangle> tmp, int x,int y) {
		
		Rectangle personagem = new Rectangle(getX()+x, getY()+y, 
				getLarguraPersonagem(), getAlturaPersonagem());
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
				return true;
			}
		}
		return false;
	}
	
	//metodos para tratar colisão Y
	@Override
	public void setX(int x) {
	if(!collision(ControlePintura.colisao, x-getX(), 0))
		super.setX(x);//this.x = x;
	
	}

	//metodos para tratar colisão X	
	@Override
	public void setY(int y) {
		if(!collision(ControlePintura.colisao, 0, y-getY()))
			super.setY(y);//this.y = y;
	}
	
}
