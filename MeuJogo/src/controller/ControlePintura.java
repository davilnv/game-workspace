package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;

import model.Camada;
import model.Inimigo;
import model.NumerosAleatorios;
import model.Personagem;
import view.Mapa;

public class ControlePintura implements Runnable{

	private Mapa mapa;
	private Personagem personagem;
	private Inimigo inimigo;
	private Graphics g;
	private Camada camadaFundo, camadaColisao, camadaTopo;
	public static List<Rectangle> colisao;
	private Thread thread;
	int num1 = NumerosAleatorios.gerarNumeroAleatorio();
	int num2 = NumerosAleatorios.gerarNumeroAleatorio();
	
	public ControlePintura(Mapa mapa, Personagem personagem, Inimigo inimigo, Camada camadaFundo, Camada camadaColisao, Camada camadaTopo) {
		super();
		this.mapa = mapa;
		
		this.personagem = personagem;
		this.inimigo = inimigo;
		
		this.camadaFundo = camadaFundo;
		this.camadaColisao = camadaColisao;
		this.camadaTopo = camadaTopo;

		colisao = camadaColisao.montarColisao();
		
		this.g = mapa.getGraphicsMapa();
		
		thread = new Thread(this);
		
		thread.start();
	}


	public void draw() {
		g.drawImage(camadaFundo.camada, 0, 0, null);
		g.drawImage(camadaColisao.camada, 0, 0, null);

		g.drawImage(inimigo.getSprites()[inimigo.getAparencia()], inimigo.getX(), inimigo.getY(), null);
		g.drawImage(personagem.getSprites()[personagem.getAparencia()], personagem.getX(), personagem.getY(), null);

		g.drawImage(camadaTopo.camada, 0, 0, null);
		
		// Mostra os retângulos da colisão
		
		((Graphics2D) g).draw(personagem.getBounds());
		((Graphics2D) g).draw(inimigo.getBounds());
		
		for (Rectangle rectangle : colisao) {
			
			((Graphics2D) g).draw(rectangle);
			
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(num1 + " + " + num2 + " = ", 160, 52);
		
	}
	
	public void update(){
		camadaFundo.montarMapa();
		camadaColisao.montarMapa();
		camadaTopo.montarMapa();
	}
	
	@Override
	public void run() {
		
		while(true) {

//			inimigo.mover("true");
			mapa.repaint();
			update();
			draw();
			
		}
		
	}
	
}
