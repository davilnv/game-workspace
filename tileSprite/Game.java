package tileSprite;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;

	Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();

	Camada camada1, camada2, camada3;
	public BufferedImage tela;
	static Sprite personagem;
	int FPS=5;
	ImageIcon background;
	int up, down, left, right;

	public Game(){
		setSize(320,320);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new TAdapter());	

		camada1 = new Camada(10,10, 32, 32, "aulaJogos/tileSprite/Camada1.png", "camada1.txt");
		//Camada: Ler a matriz e uma imagem que será associada a essa matriz
		camada2 = new Camada(10,10, 32, 32, "aulaJogos/tileSprite/Camada2.png", "camada2.txt");

		try{
			personagem = new Sprite(new File("aulaJogos/tileSprite/personagem.png"), 7, 6, 4, this.getWidth()/2, this.getHeight()/2);
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("NÃ£o foi possÃ­vel carregar a Sprite");
		}
		camada1.montarMapa(320,320);
		camada2.montarMapa(320,320);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		tela.getGraphics().drawImage(camada1.camada, 0, 0, this);//camada grama/blocos

		//deveria tratar colisão
		tela.getGraphics().drawImage(personagem.sprites[personagem.aparencia], personagem.posX, personagem.posY, null);
		tela.getGraphics().drawImage(camada2.camada, 0, 0, this);//camada Ã¡rvore
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.drawImage(tela, 0, 0, null);
	}

	public void run(){//SUBSTITUIR PELO CONCEITO DE tHREAD
//		camada1.montarMapa(320,320); //linha47 e 48
//		camada2.montarMapa(320,320);
		tela = new BufferedImage(640, 640, BufferedImage.TYPE_4BYTE_ABGR);
		while (true) {
			try {
				repaint();
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public class TAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_UP){
				personagem.posY--;
				switch (up) {
				case 0:
					personagem.aparencia=0;
					break;
				case 1:
					personagem.aparencia=4;
					break;
				case 2:
					personagem.aparencia=8;
					break;
				case 3:
					personagem.aparencia=12;
					break;
				}
				if (up==3) up=0;
				else up++;
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN){
				personagem.posY++;
				switch (down) {
				case 0:
					personagem.aparencia=2;
					break;
				case 1:
					personagem.aparencia=6;
					break;
				case 2:
					personagem.aparencia=10;
					break;
				case 3:
					personagem.aparencia=14;
					break;
				}
				if (down==3) down=0;
				else down++;
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT){
				personagem.posX--;
				switch (left) {
				case 0:
					personagem.aparencia=3;
					break;
				case 1:
					personagem.aparencia=7;
					break;
				case 2:
					personagem.aparencia=11;
					break;
				case 3:
					personagem.aparencia=15;
					break;
				}
				if (left==3) left=0;
				else left++;
				//outro if para verificar a osição i e j do personagem
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT){
				personagem.posX++;
				switch (right) {
				case 0:
					personagem.aparencia=1;
					break;
				case 1:
					personagem.aparencia=5;
					break;
				case 2:
					personagem.aparencia=9;
					break;
				case 3:
					personagem.aparencia=13;
					break;
				}
				if (right==3) right=0;
				else right++;			
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
//		new Thread(game).start();
		game.run();
	}
}