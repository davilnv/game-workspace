package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import controller.ControlePintura;

public class Personagem extends Sprite {
	Rectangle personagemRectangle;
	Inimigo inimigo;

	public Personagem(Inimigo inimigo, int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco) {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);
		this.inimigo = inimigo;
	}

	@Override
	public void animar(String direcao) {
		setAparencia(getAparencia() + 1);
		
		if (direcao.equalsIgnoreCase("cima")) {
			if(getAparencia() < 9 || getAparencia() > 11)
				setAparencia(9);
		} else if (direcao.equalsIgnoreCase("baixo")) {
			if(getAparencia() < 0 || getAparencia() > 2)
				setAparencia(0);
		} else if (direcao.equalsIgnoreCase("esquerda")) {
			if(getAparencia() < 3 || getAparencia() > 5)
				setAparencia(3);
		} else if (direcao.equalsIgnoreCase("direita")) {
			if(getAparencia() < 6 || getAparencia() > 8)
				setAparencia(6);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), null);
	}

	@Override
	public void mover(String direcao) {
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

		if (!direcao.equals(""))
			animar(direcao);
	}
	
	public boolean colisao(Rectangle tmp) {
		Rectangle devil = new Rectangle(inimigo.getX(), inimigo.getY(), 
				inimigo.getLarguraPersonagem(), inimigo.getAlturaPersonagem());
		if(tmp.intersects(devil)){
			return true;
		}
		return false;
	}
	
	public boolean colisao(List<Rectangle> tmp, int x,int y) {

		personagemRectangle = new Rectangle(getX()+x+10, getY()+y+10, 
				getLarguraPersonagem()-10, getAlturaPersonagem()-10);
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagemRectangle)){
				return true;
			}
		}
		return false;
	}

	//metodos para tratar colis�o Y
	@Override
	public void setX(int x) {
		if(!colisao(ControlePintura.colisao, x-getX(), 0) || !colisao(personagemRectangle))
			super.setX(x);

	}

	//metodos para tratar colis�o X	
	@Override
	public void setY(int y) {
		if(!colisao(ControlePintura.colisao, 0, y-getY()) || !colisao(personagemRectangle))
			super.setY(y);
	}


}
