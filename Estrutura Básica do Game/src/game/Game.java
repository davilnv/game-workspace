package game;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Game extends JFrame {

	BufferedImage backBuffer; // ESSE É O NOSSO BUFFER
	public int FPS = 30; // ESSA É A TAXA DE ATUALIZAÇÃO DA TELA
	int janelaW = 500; // LARGURA DA TELA
	int janelaH = 500; // ALTURA DA TELA

	// NO NOSSO METODO ATUALIZAR VAMOS CHAMAR OS METODOS
	// QUE SERÃO EXECUTADOS O TEMPO INTEIRO...
	public void atualizar() {

	}

	// NESSE MÉTODO VAMOS DESENHAR
	// FORMAS GEOMETRICAS, IMAGENS E TEXTOS NA TELA E ETC...
	public void desenharGraficos() {
		Graphics g = getGraphics(); //ISSO JÁ ESTAVA AQUI
		Graphics bbg = backBuffer.getGraphics();//ISSO TAMBÉM JÁ ESTAVA AQUI...
		//AQUI VAMOS MANDAR DESENHAR ALGUNS TEXTOS NA TELA
		bbg.setColor(new Color(100,200,100)); //muda a cor!
		bbg.setFont(new Font("Comic Sans MS",Font.BOLD,20));// definimos a fonte, o estilo negrito(bold) e o tamanho
		bbg.drawString("JAVA GAMES 2D", 100, 200); // aqui desenhamos o texto "JAVA GAMES 2D" nas coordenadas X=100 e Y=200
		//OUTROS TESTES...
		bbg.setColor(Color.RED);
		bbg.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
		bbg.drawString("JAVA GAMES 2D", 150, 225);
		   
		bbg.setColor(Color.YELLOW);
		bbg.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		bbg.drawString("JAVA GAMES 2D", 100, 250);
		   
		//==================================================================================
		g.drawImage(backBuffer, 0, 0, this);//OBS: ISSO DEVE FICAR SEMPRE NO FINAL!
	}

	// ESSE É O NOSSO MÉTODO INICIALIZAR
	// AQUI VAMOS INICIALIZAR ALGUMAS CONFIGURAÇÃO DO frame E OUTRAS CONFIGURAÇÕES
	public void inicializar() {
		setTitle("Titulo do Jogo!");// SETANDO O TITULO DA JANELA
		setSize(janelaW, janelaH);// DEFINIDO AS DIMENSÕES DA JANELA
		setResizable(false);// TIRANDO A PERMISSÃO DO USUÁRIO REDIMENSIONAR A JANELA
		setDefaultCloseOperation(EXIT_ON_CLOSE);// QUANDO FECHARMOS O frame A APLICAÇÃO PARA DE EXECUTAR
		setLayout(null);// COM ISSO PODEREMOS DEFINIAR COORDENADA E DIMESÕES DE ELMENTOS DE FORMULARIO
						// NO NOSSO FRAME
		setVisible(true);// MUDANDO A VISIBILIDADE DO frame PARA TRUE, ASSIM ELE APARECERÁ
		backBuffer = new BufferedImage(janelaW, janelaH, BufferedImage.TYPE_INT_RGB);// CRIANDO O NOSSO BUFFER DE IMAGEM
	}

}
