package controle;

import java.awt.Graphics;

import model.Camada;
import model.Personagem;
import view.Mapa;

public class ControlePintura implements Runnable{

	private Mapa mapa;
	private Personagem personagem;
	private Graphics g;
	private Camada camadaFundo, camadaColisao, camadaTopo;
	private Thread thread;
	
	public ControlePintura(Mapa mapa, Personagem personagem, Camada camadaFundo, Camada camadaColisao, Camada camadaTopo) {
		super();
		this.mapa = mapa;
		this.personagem = personagem;
		this.camadaFundo = camadaFundo;
		this.camadaColisao = camadaColisao;
		this.camadaTopo = camadaTopo;
		
		this.g = mapa.getGraphicsMapa();
		
		thread = new Thread(this);
		
		thread.start();
	}


	public void draw() {
//		g.drawImage(camadaFundo.camada, 0, 0, null);
		g.drawImage(camadaColisao.camada, 0, 0, null);
		
		g.fillRect(personagem.getX(), personagem.getY(), personagem.getLargura(), personagem.getAltura());
		
		g.drawImage(camadaTopo.camada, 0, 0, null);
		
	}
	
	public void update(){	
		camadaFundo.montarMapa();
		camadaColisao.montarMapa();
		camadaTopo.montarMapa();
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			mapa.repaint();
			update();
			draw();
			
		}
		
	}
	
	
	
	
}
