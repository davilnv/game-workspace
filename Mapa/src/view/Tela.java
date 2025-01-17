package view;

import javax.swing.JFrame;

public class Tela extends JFrame{

	public static final int LARGURA = 530;
	public static final int ALTURA = 530;
	
	private Mapa mapa;
	
	public Tela() {
		
		setTitle("Mapa");
		setSize(LARGURA, ALTURA);
		setLayout(null);
//		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mapa = new Mapa();		
		add(mapa);
		
		setVisible(true);
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
}
