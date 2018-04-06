package com.mygdx.namopanda;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.IntFloatMap;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {

	private int alturaDoFundo;
	private int alturaDaTela;
	private int alturanuvem;
	private Texture[] barra;
	private Texture[] estrela;
	private float[] barraMovimentacao;
	private Rectangle[] barraRetangulo;
	private SpriteBatch batch;
	private Texture chao;
	private int[] estadoDaBarra;
	private int estadoDoJogo;
	private int estadoDoPersonagem;
	private Texture fundo;
	private int larguraDaTela;
	private float movimentoNuvem;
	private int n;
	private int[] numeroDaBarra;
	private Random numeroRondamico;
	private Texture nuvem;
	private Texture panda;
	private Circle pandaCirculo;
	private float posicaoHorizontalPanda;
	private int[] posicaoVerticalBarra;
	private int posicaoVerticalPanda;
	private ShapeRenderer shapeRenderer;
	private int velocidadeDeQueda;
	//private int velocidadeDeQuedaBarra;
	private boolean estadoDaRestauraçao ;
	private int x ;
	private int contadorDeRestauracaoBarra;
	private int faseDoJogo ;
	private float velocidadeMovimentoHorizontal;
	private int[] posicaoHorizontalEstrela;
	private int[] posicaoVerticalEstrela;
	private int grupoEstrela;
	private int estadoDetroca;
	private int contador = 0;
	private int ajuda;
	private int offon = 0;
	private Texture carta;
	private Texture casal;
	private BitmapFont mensagem;
	private BitmapFont fonte;
	private float larguraEstrela;
	private float alturaEstrela;
	private int estadoTamanhoEstrela;
	private Texture reiniciar;



	@Override
	public void create () {
		if (contador > 0){
			estadoDoJogo =1;
		}else {
			estadoDoJogo = 0;
		}



		alturaDoFundo = 0;

		x = 0;

		batch = new SpriteBatch();

		shapeRenderer = new ShapeRenderer();

		carta =  new Texture("carta.png");
		casal = new Texture("casal.png");

		fundo = new Texture("fundo.png");

		reiniciar = new Texture("reiniciar.png");

        nuvem = new Texture("nuvem.png");
		panda = new Texture("panda.png");

		barra = new Texture[6];

		barra[0] = new Texture("bom.png");
		barra[1] = new Texture("bom.png");
		barra[2] = new Texture("bom.png");
		barra[3] = new Texture("bom.png");
		barra[4] = new Texture("bom.png");
		barra[5] = new Texture("bom.png");

		estrela = new Texture[5];

		estrela[0] = new Texture("estrela.png");
		estrela[1] = new Texture("estrela.png");
		estrela[2] = new Texture("estrela.png");
		estrela[3] = new Texture("estrela.png");
		estrela[4] = new Texture("estrela.png");


	//	chao = new Texture("chao.png");

		pandaCirculo = new Circle();

		barraRetangulo = new Rectangle[6];

		barraRetangulo[0] = new Rectangle();
		barraRetangulo[1] = new Rectangle();
		barraRetangulo[2] = new Rectangle();
		barraRetangulo[3] = new Rectangle();
		barraRetangulo[4] = new Rectangle();
		barraRetangulo[5] = new Rectangle();



		larguraDaTela = Gdx.graphics.getWidth();
		alturaDaTela = Gdx.graphics.getHeight();

		posicaoVerticalBarra = new int[6];

		posicaoVerticalBarra[0] = 100;
		posicaoVerticalBarra[1] = 400;
		posicaoVerticalBarra[2] = 700;
		posicaoVerticalBarra[3] = 1000;
		posicaoVerticalBarra[4] = 1300;
		posicaoVerticalBarra[5] = 1600;


		barraMovimentacao = new float[6];

		barraMovimentacao[0] = 0;
		barraMovimentacao[1] = larguraDaTela - 300;
		barraMovimentacao[2] = larguraDaTela / 2;
		barraMovimentacao[3] = larguraDaTela - 200;
		barraMovimentacao[4] = 0;
		barraMovimentacao[5] = larguraDaTela/2;

		estadoDoPersonagem = 0; // 0 - parado / 1 - pulando

		numeroRondamico = new Random();

		estadoDaBarra = new int[6];

		estadoDaBarra[0] = numeroRondamico.nextInt(1);
		estadoDaBarra[1] = numeroRondamico.nextInt(1);
		estadoDaBarra[2] = numeroRondamico.nextInt(1);
		estadoDaBarra[3] = numeroRondamico.nextInt(1);
		estadoDaBarra[4] = numeroRondamico.nextInt(1);
		estadoDaBarra[5] = numeroRondamico.nextInt(1);

		velocidadeDeQueda = 0;

		n = 0;

		estadoDaRestauraçao = false;

        movimentoNuvem = larguraDaTela;

        alturanuvem = alturaDaTela - 400;


        posicaoHorizontalPanda = Gdx.graphics.getWidth() / 2;
        posicaoVerticalPanda = 0;

		contadorDeRestauracaoBarra = 0;

		faseDoJogo = 1;

		posicaoHorizontalEstrela = new int[5];

		posicaoHorizontalEstrela[0] = numeroRondamico.nextInt(larguraDaTela) ;
		posicaoHorizontalEstrela[1] = numeroRondamico.nextInt(larguraDaTela) ;
		posicaoHorizontalEstrela[2] = numeroRondamico.nextInt(larguraDaTela) ;
		posicaoHorizontalEstrela[3] = numeroRondamico.nextInt(larguraDaTela) ;
		posicaoHorizontalEstrela[4] = numeroRondamico.nextInt(larguraDaTela) ;

		posicaoVerticalEstrela = new int[5];

		posicaoVerticalEstrela[0] =  alturaDaTela - numeroRondamico.nextInt(200);
		posicaoVerticalEstrela[1] =  alturaDaTela - numeroRondamico.nextInt(200);
		posicaoVerticalEstrela[2] =  alturaDaTela - numeroRondamico.nextInt(200);
		posicaoVerticalEstrela[3] =  alturaDaTela - numeroRondamico.nextInt(400);
		posicaoVerticalEstrela[4] =  alturaDaTela - numeroRondamico.nextInt(400);

		estadoDetroca = 0 ;
		contador = 0;
		ajuda = 500;


		mensagem = new BitmapFont();
		mensagem.setColor(Color.WHITE);
		mensagem.getData().setScale(4);


		fonte = new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().setScale(6);

		larguraEstrela = 0;
		alturaEstrela = 0;

		estadoTamanhoEstrela = 1 ;



	}

	@Override
	public void render () {



		//estado game over
		if (estadoDoJogo == 5 ){
			for (int i = 0 ; i < 6 ; i ++){
				barraMovimentacao[i] = alturaDaTela;
			}
			if (Gdx.input.justTouched()){
				create();
			}
		}else {



			//configurando queda
			if (estadoDoPersonagem == 1) {
				velocidadeDeQueda++;
			}

			//configurando estrel
			if (larguraEstrela >= estrela[0].getWidth()) {
				estadoTamanhoEstrela = 0;
			}
			if (larguraEstrela <= 0) {
				estadoTamanhoEstrela = 1;
			}
			if (estadoTamanhoEstrela == 1) {
				larguraEstrela += 0.148 ;
				alturaEstrela +=0.148;
			} else {
				larguraEstrela -= 0.148 ;
				alturaEstrela -= 0.148;
			}
			//Gdx.app.log("teste","tam :"+estrela[0].getWidth());

			//configurando troca de grupo das estrelas
			contador ++;
			if(contador  == ajuda ){
				ajuda = ajuda + 500;
				estadoDetroca = 1;
			// Gdx.app.log("queda = ", ":" + contador + " AJ = " + ajuda);

			}else{
				estadoDetroca = 0;
			}
			if (estadoDetroca == 1){

				if (grupoEstrela == 0){
					grupoEstrela = 1;
				}else {
					grupoEstrela =0;
				}

				posicaoHorizontalEstrela[0] = numeroRondamico.nextInt(larguraDaTela) ;
				posicaoHorizontalEstrela[1] = numeroRondamico.nextInt(larguraDaTela) ;
				posicaoHorizontalEstrela[2] = numeroRondamico.nextInt(larguraDaTela) ;
				posicaoHorizontalEstrela[3] = numeroRondamico.nextInt(larguraDaTela) ;
				posicaoHorizontalEstrela[4] = numeroRondamico.nextInt(larguraDaTela) ;



				posicaoVerticalEstrela[0] =  alturaDaTela - numeroRondamico.nextInt(200);
				posicaoVerticalEstrela[1] =  alturaDaTela - numeroRondamico.nextInt(200);
				posicaoVerticalEstrela[2] =  alturaDaTela - numeroRondamico.nextInt(200);
				posicaoVerticalEstrela[3] =  alturaDaTela - numeroRondamico.nextInt(400);
				posicaoVerticalEstrela[4] =  alturaDaTela - numeroRondamico.nextInt(400);

				estadoDetroca =0;

			}


			//configurando nuvem
			if (movimentoNuvem < -nuvem.getWidth()) {
				alturanuvem = numeroRondamico.nextInt(alturaDaTela / 2) + alturaDaTela / 2;
				movimentoNuvem = larguraDaTela;
			}
			movimentoNuvem -= Gdx.graphics.getDeltaTime() * 50;



			//configurando barra 1
			Gdx.app.log("fase = ", ":" + faseDoJogo * 70);
			velocidadeMovimentoHorizontal = (Gdx.graphics.getDeltaTime() * 400) + ((Gdx.graphics.getDeltaTime() *  70 ) * faseDoJogo) ;
			if (barraMovimentacao[0] >= larguraDaTela - barra[0].getWidth()) {
				estadoDaBarra[0] = 0;
			}
			if (barraMovimentacao[0] <= 0) {
				estadoDaBarra[0] = 1;
			}
			if (estadoDaBarra[0] == 1) {
				barraMovimentacao[0] += velocidadeMovimentoHorizontal;
			} else {
				barraMovimentacao[0] -= velocidadeMovimentoHorizontal;
			}
			//configurando barra 2
			if (barraMovimentacao[1] >= larguraDaTela - barra[0].getWidth()) {
				estadoDaBarra[1] = 0;
			}
			if (barraMovimentacao[1] <= 0) {
				estadoDaBarra[1] = 1;
			}
			if (estadoDaBarra[1] == 1) {
				barraMovimentacao[1] += velocidadeMovimentoHorizontal;
			} else {
				barraMovimentacao[1] -= velocidadeMovimentoHorizontal;
			}
			//configurando barra 3
			if (barraMovimentacao[2] >= larguraDaTela - barra[0].getWidth()) {
				estadoDaBarra[2] = 0;
			}
			if (barraMovimentacao[2] <= 0) {
				estadoDaBarra[2] = 1;
			}
			if (estadoDaBarra[2] == 1) {
				barraMovimentacao[2] += velocidadeMovimentoHorizontal;
			} else {
				barraMovimentacao[2] -= velocidadeMovimentoHorizontal;
			}

			//configurando barra 4
			if (barraMovimentacao[3] >= larguraDaTela - barra[0].getWidth()) {
				estadoDaBarra[3] = 0;
			}
			if (barraMovimentacao[3] <= 0) {
				estadoDaBarra[3] = 1;
			}
			if (estadoDaBarra[3] == 1) {
				barraMovimentacao[3] += velocidadeMovimentoHorizontal;
			} else {
				barraMovimentacao[3] -= velocidadeMovimentoHorizontal;
			}
			//configurando barra 5
			if (barraMovimentacao[4] >= larguraDaTela - barra[0].getWidth()) {
				estadoDaBarra[4] = 0;
			}
			if (barraMovimentacao[4] <= 0) {
				estadoDaBarra[4] = 1;
			}
			if (estadoDaBarra[4] == 1) {
				barraMovimentacao[4] += velocidadeMovimentoHorizontal;
			} else {
				barraMovimentacao[4] -= velocidadeMovimentoHorizontal;
			}
			//configurando barra 6
			if (barraMovimentacao[5] >= larguraDaTela - barra[0].getWidth()) {
				estadoDaBarra[5] = 0;
			}
			if (barraMovimentacao[5] <= 0) {
				estadoDaBarra[5] = 1;
			}
			if (estadoDaBarra[5] == 1) {
				barraMovimentacao[5] += velocidadeMovimentoHorizontal;
			} else {
				barraMovimentacao[5] -= velocidadeMovimentoHorizontal;
			}


			// Verificaçao de colisao
			if (estadoDoJogo == 2) {
				if (posicaoVerticalPanda >= posicaoVerticalBarra[n] + barra[0].getHeight() - 30) {
					estadoDoPersonagem = 0;
					estadoDoJogo = 3;
				} else {
					if (velocidadeDeQueda <= 0) {
						velocidadeDeQueda += 10;
						estadoDoJogo = 1;
					} else {
						estadoDoJogo = 1;
					}
				}

				//Gdx.app.log("teste", "n =" + n + "estado do jogo" + estadoDoJogo);
			}


			//em cima de uma  barra
			if (estadoDoJogo == 3) {
				velocidadeDeQueda = 0;
				posicaoVerticalPanda = posicaoVerticalBarra[n]+ barra[0].getHeight() - 10;
				if (posicaoVerticalPanda >= 1600 || estadoDaRestauraçao) {
					estadoDaRestauraçao = true;
					estadoDoJogo = 4;
					if (faseDoJogo == 5){
						estadoDoJogo = 5;
					}
				}
				if (estadoDaBarra[n] == 1) {
					if (posicaoHorizontalPanda >= larguraDaTela - panda.getWidth()){
						 posicaoHorizontalPanda -= velocidadeMovimentoHorizontal ;
					}
					posicaoHorizontalPanda += velocidadeMovimentoHorizontal;
				} else {
					if ( posicaoHorizontalPanda  <= 0){
						 posicaoHorizontalPanda += velocidadeMovimentoHorizontal ;
					}
					posicaoHorizontalPanda -= velocidadeMovimentoHorizontal;
				}
				//toque subir
				if (Gdx.input.justTouched() && estadoDoJogo != 4) {
					estadoDoJogo = 1;
					velocidadeDeQueda = -30;
					estadoDoPersonagem = 1;
				}
			}

			//restaurando
			if (estadoDoJogo == 4) {
				// decremento das barras e fundo e nuvem
				if (x < 900) {
					for (int i = 0; i < 6; i++) {
						posicaoVerticalBarra[i] -= 4;
					}
					for (int i = 0 ; i < 5 ; i++ ){
						posicaoHorizontalEstrela[i] -= 4;
					}
					alturanuvem -= 4;
					alturaDoFundo -= 4;
					posicaoVerticalPanda -= 4;
					x += 4;
				} else {
					estadoDaRestauraçao = false;
					x = 0;
				}
				//retaurando barras
				if (estadoDaRestauraçao == false) {
					faseDoJogo++;

					posicaoVerticalBarra[contadorDeRestauracaoBarra] = 1000;
					posicaoVerticalBarra[contadorDeRestauracaoBarra + 1] = 1300;
					posicaoVerticalBarra[contadorDeRestauracaoBarra + 2] = 1600;


					contadorDeRestauracaoBarra += 3;
					if (contadorDeRestauracaoBarra == 6) {
						contadorDeRestauracaoBarra = 0;
					}
				}
			}



			//panda no chao
			if (estadoDoJogo == 1) {
				//configurando game over
				if (velocidadeDeQueda >= 48) {
					//Gdx.app.log("teste", "entrou");
					estadoDoJogo = 5 ;
				}

				//toque subir
				if (Gdx.input.justTouched() && estadoDoPersonagem == 0) {
					velocidadeDeQueda = -30;
					estadoDoPersonagem = 1;
				}


				if (posicaoVerticalPanda <= 0 && faseDoJogo > 1 ){
					estadoDoJogo = 5;
				}

				//caindo
				if (posicaoVerticalPanda > 0 || velocidadeDeQueda < 0) {
					posicaoVerticalPanda -= velocidadeDeQueda;
				} else {
					velocidadeDeQueda = 0;
					estadoDoPersonagem = 0;
				}

			}

			//Gdx.app.log("queda = ", ":" + velocidadeDeQueda);

			if (estadoDoJogo ==0){
				if (Gdx.input.justTouched()){
					estadoDoJogo = 1 ;
				}
			}



			//reiniciando
			if (offon == 1){
				offon = 0;
				create();
			}
			if (estadoDoJogo == 1 || estadoDoJogo == 2 || estadoDoJogo == 3 ) {
				if (Gdx.input.justTouched()) {
					int firstX = Gdx.input.getX();
					int firstY = Gdx.input.getY();
					//Gdx.app.log("teste"," x " + firstX + " y " + firstY);
					if (firstX >= larguraDaTela - 100 && firstY <=  100) {
						offon = 1 ;
					}
				}
			}


		}
		//desenhando jogo

		batch.begin();


		batch.draw(fundo, 0, alturaDoFundo, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() + 3600);
		if (grupoEstrela == 0){

			batch.draw(estrela[1],posicaoHorizontalEstrela[1],posicaoVerticalEstrela[1],larguraEstrela,alturaEstrela);
			batch.draw(estrela[2],posicaoHorizontalEstrela[2],posicaoVerticalEstrela[2],larguraEstrela,alturaEstrela);
			batch.draw(estrela[3],posicaoHorizontalEstrela[3],posicaoVerticalEstrela[3],larguraEstrela,alturaEstrela);


		}else {
			batch.draw(estrela[0],posicaoHorizontalEstrela[0],posicaoVerticalEstrela[0],larguraEstrela,alturaEstrela);
			batch.draw(estrela[2],posicaoHorizontalEstrela[2],posicaoVerticalEstrela[2],larguraEstrela,alturaEstrela);
			batch.draw(estrela[4],posicaoHorizontalEstrela[4],posicaoVerticalEstrela[4],larguraEstrela,alturaEstrela);
		}
		batch.draw(nuvem, movimentoNuvem, alturanuvem);
		if ( estadoDoJogo == 0){
			batch.draw(carta,0,alturaDaTela/2,larguraDaTela,carta.getHeight() + 200);
			batch.draw(casal,larguraDaTela/2,0);
			mensagem.draw(batch,"Toque Para Iniciar",larguraDaTela/2 - 50 , alturaDaTela /2);

		}else {
			batch.draw(panda, posicaoHorizontalPanda, posicaoVerticalPanda);
			batch.draw(reiniciar,larguraDaTela - 100 , alturaDaTela - 100 , 100 , 100);
			batch.draw(barra[0], barraMovimentacao[0], posicaoVerticalBarra[0],barra[0].getWidth() - 20 , barra[0].getHeight() );
			batch.draw(barra[1], barraMovimentacao[1], posicaoVerticalBarra[1],barra[0].getWidth() - 20 , barra[0].getHeight());
			batch.draw(barra[2], barraMovimentacao[2], posicaoVerticalBarra[2],barra[0].getWidth() - 20 , barra[0].getHeight());
			batch.draw(barra[3], barraMovimentacao[3], posicaoVerticalBarra[3],barra[0].getWidth() - 20 , barra[0].getHeight());
			batch.draw(barra[4], barraMovimentacao[4], posicaoVerticalBarra[4],barra[0].getWidth() - 20 , barra[0].getHeight());
			batch.draw(barra[5], barraMovimentacao[5], posicaoVerticalBarra[5],barra[0].getWidth() - 20 , barra[0].getHeight());
		}
		if (estadoDoJogo == 5){
			mensagem.draw(batch,"Toque Para Reiniciar",larguraDaTela/2 - 150 , alturaDaTela /2);
		}

		fonte.draw(batch,""+faseDoJogo,larguraDaTela/2 - 50 , alturaDaTela - 100);

		batch.end();




		pandaCirculo.set(posicaoHorizontalPanda + panda.getWidth() / 2, posicaoVerticalPanda + panda.getHeight() / 2, 40);

		barraRetangulo[0].set(barraMovimentacao[0], posicaoVerticalBarra[0], barra[0].getWidth()- 20, barra[0].getHeight());
		barraRetangulo[1].set(barraMovimentacao[1], posicaoVerticalBarra[1], barra[0].getWidth()- 20, barra[0].getHeight());
		barraRetangulo[2].set(barraMovimentacao[2], posicaoVerticalBarra[2], barra[0].getWidth()- 20, barra[0].getHeight());
		barraRetangulo[3].set(barraMovimentacao[3], posicaoVerticalBarra[3], barra[0].getWidth()- 20, barra[0].getHeight());
		barraRetangulo[4].set(barraMovimentacao[4], posicaoVerticalBarra[4], barra[0].getWidth()- 20, barra[0].getHeight());
		barraRetangulo[5].set(barraMovimentacao[5], posicaoVerticalBarra[5], barra[0].getWidth()- 20, barra[0].getHeight());


/*

		this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		this.shapeRenderer.circle(this.pandaCirculo.x, this.pandaCirculo.y, this.pandaCirculo.radius);
		this.shapeRenderer.setColor(Color.BLUE);
		this.shapeRenderer.rect(this.barraRetangulo[3].x, this.barraRetangulo[3].y, this.barraRetangulo[3].width, this.barraRetangulo[3].height);
		this.shapeRenderer.setColor(Color.BLACK);
		this.shapeRenderer.rect(this.barraRetangulo[0].x, this.barraRetangulo[0].y, this.barraRetangulo[0].width, this.barraRetangulo[0].height);
		this.shapeRenderer.rect(this.barraRetangulo[1].x, this.barraRetangulo[1].y, this.barraRetangulo[1].width, this.barraRetangulo[1].height);
		this.shapeRenderer.rect(this.barraRetangulo[2].x, this.barraRetangulo[2].y, this.barraRetangulo[2].width, this.barraRetangulo[2].height);

		this.shapeRenderer.end();
*/
		//

		if (Intersector.overlaps(pandaCirculo, barraRetangulo[0]))
		{
			estadoDoJogo = 2;
			n = 0;
		}
		if (Intersector.overlaps(pandaCirculo, barraRetangulo[1]))
		{
			estadoDoJogo = 2;
			n = 1;
		}
		if (Intersector.overlaps(pandaCirculo, barraRetangulo[2]))
		{
			estadoDoJogo = 2;
			n = 2;
		}
		if (Intersector.overlaps(pandaCirculo, barraRetangulo[3]))
		{
			estadoDoJogo = 2;
			n = 3;
		}
		if (Intersector.overlaps(pandaCirculo, barraRetangulo[4]))
		{
			estadoDoJogo = 2;
			n = 4;
		}
		if (Intersector.overlaps(pandaCirculo, barraRetangulo[5]))
		{
			estadoDoJogo = 2;
			n = 5;
		}

		//Gdx.app.log("teste", "n = " + n );


	}
}
