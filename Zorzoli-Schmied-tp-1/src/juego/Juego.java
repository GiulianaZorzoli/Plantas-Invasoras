 package juego;

import java.awt.Color;

import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import entorno.Herramientas;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;	
	
	// Variables y métodos propios de cada grupo
	private Laika laika;
	
	//Arrays de Imagenes de personajes, personajes dañados y personajes volteados.
	private Image[]personajes;
	private Image[] personajesD;
	private Image[] personajesV;

	private FuegoList bolas;
	private int fuegoNum;
	
	private Pantalla pantallaInicio;
	private Pantalla pantallaGanar;
	private Pantalla pantallaPerder;
	private Image [] pantallas;
	
	private Color colorBarra;
	private float[] cBarra;
	
	//vidas
	private Image []vidas;
	private Image vidaMas;
	private Image vidaMenos;
	private int vidasX;
 
	//boolean para perder y puntos
	private boolean perder;

	private int puntos;
	
	//Cuadras
	private Cuadras cuadraUno;
	private Cuadras cuadraDos;
	private Cuadras cuadraTres;
	private Cuadras cuadraCuatro;
	private Cuadras cuadraCinco;
	private Cuadras cuadraSeis;
	private Cuadras[] cuadras;

	
	//array de Plantas, array puntos Spawn de Plantas, Icono planta, plantas derrotadas, dir y p(serán usado para varias cosas)
	private Planta [] listaPlantas;
	private Point [] puntosSpawn;
	private Image plantaIcon;
	private int plantasDerr;
	private String dir;
	private int p;
	private int velocidadNivel;
	
	//puntos Spawn
	private Point punto1;
	private Point punto2;
	private Point punto3;
	private Point punto4;
	private Point punto5;
	private Point punto6;
	private Point punto7;
	private Point punto8;
	private Point punto9;
	private Point punto10;
	private Point punto11;
	private Point punto12;
	private Point punto13;
	private Point punto14;
	
	//autos
	private Autos auto1;
	private Autos auto2;
	private Autos auto3;
	private Autos auto4;
	private Autos auto5;
	private Autos auto6;
	private Autos auto7;
	
	private Autos autos[];
	private Point[]puntosAutos;
	private Image[]autosImg;
	
	//acumuladores como "cooldown"
	private int acTiemp;
	private int acBola;
	private int acVida;
	
	//extras
	private Potenciador potenciador;
	private Point [] listaPuntos;
	
	private int nivelTiempo;
	private String nivel;
	
	private Clip ladrido;
	private Clip musica;
	private Clip rayoSound;
	private Clip muerte;
	private Clip potenciadorSonido;
	
	
	//multijugador
	private Laika laika2;
	private boolean multijugador;
	private int seleccion;
	private int acTiemp2;
	private Image[] vidas2;
	private Image[] icons;
	private Image icon1;
	private Image icon2;
	private Image L1;
	private Image L2;
	private int P1;
	private int P2;

	
	//Rayo
	private Rayo rayo;
	private Rayo rayo2;

	
	
	
	Juego() {
		Random rand = new Random();
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, " Plantas Invasoras - Grupo ... - v1", 802, 619);

		// Inicializar lo que haga falta para el juego
		this.laika=new Laika(Herramientas.cargarImagen("imagenes/laika.png"),400,this.entorno.alto()-50,25,28,0.13);
		
		//array con las imagenes de los personajes
		this.personajes=new Image[] {Herramientas.cargarImagen("imagenes/perro1.png"),Herramientas.cargarImagen("imagenes/perro2.png"),Herramientas.cargarImagen("imagenes/perro3.png")};
		this.personajesD= new Image[] {Herramientas.cargarImagen("imagenes/perro1-d.png"),Herramientas.cargarImagen("imagenes/perro2-d.png"),Herramientas.cargarImagen("imagenes/perro3-d.png"),Herramientas.cargarImagen("imagenes/perro1-dv.png"),Herramientas.cargarImagen("imagenes/perro2-dv.png"),Herramientas.cargarImagen("imagenes/perro3-dv.png")};
		this.personajesV= new Image[] {Herramientas.cargarImagen("imagenes/perro1-v.png"),Herramientas.cargarImagen("imagenes/perro2-v.png"),Herramientas.cargarImagen("imagenes/perro3-v.png")};
		
		//lista enlazada de bolas de fuego
		this.bolas=new FuegoList();
		this.fuegoNum=0;
		
		//pantalla de inicio y interfaz
		this.pantallaInicio=new Pantalla(entorno.ancho()/2,entorno.alto()/2,"inicio",this.personajes);
		this.pantallaGanar=new Pantalla(entorno.ancho()/2,entorno.alto()/2,"ganador",this.pantallas);
		this.pantallaPerder=new Pantalla(entorno.ancho()/2,entorno.alto()/2,"perdedor",this.pantallas);
		this.cBarra=Color.RGBtoHSB(88,58,146,cBarra);
		this.colorBarra=Color.getHSBColor(cBarra[0],cBarra[1],cBarra[2]);
		
		Image vida=Herramientas.cargarImagen("imagenes/vida.png");
		this.vidasX=50;
		this.vidaMenos=Herramientas.cargarImagen("imagenes/vidaMenos.png");
		this.vidaMas=Herramientas.cargarImagen("imagenes/vida.png");
		vidas = new Image[this.laika.getVidas()];
		
		for(int i=0; i<vidas.length;i++) {
			vidas[i]=vida;
		}
		this.plantaIcon=Herramientas.cargarImagen("imagenes/plantIcon.png");
		this.plantasDerr=0;
		
		//inicializacion de perder como "false" y de puntos en 0
		this.perder = false;
		this.puntos = 0;
		
		//inicializacion de las cuadras
		this.cuadraUno = new Cuadras(158,203,170,180);
		this.cuadraDos = new Cuadras(401,203,170,180);
		this.cuadraTres = new Cuadras(644,203,170,180);
		this.cuadraCuatro = new Cuadras(158,456,170,180);
		this.cuadraCinco = new Cuadras(401,456,170,180);
		this.cuadraSeis = new Cuadras(644,456,170,180);
		
		this.cuadras= new Cuadras[] {cuadraUno,cuadraDos, cuadraTres, cuadraCuatro, cuadraCinco, cuadraSeis};
		
		//inicializacion de los puntos de Spawn
		this.punto1 = new Point(15,0);
		this.punto2 = new Point(70,99);
		this.punto3 = new Point(255,0);
		this.punto4 = new Point(506,120);
		this.punto5 = new Point(850,55);
		this.punto6 = new Point(745,95);
		this.punto7 = new Point(80,311);
		this.punto8 = new Point(850,350);
		this.punto9 = new Point(-50,600);
		this.punto10 = new Point(60,565);
		this.punto11 = new Point(303,535);
		this.punto12 = new Point(546,650);
		this.punto13 = new Point(789,595);
		this.punto14 = new Point(719,650);
		
		//separamos los puntos de los autos y de las plantas
		this.puntosAutos= new Point[] {punto1,punto3,punto5,punto8,punto9,punto12,punto13};	
		this.puntosSpawn=new Point[] {punto2,punto4,punto6,punto7,punto10,punto11,punto14};
		
		//carga de imagenes de autos en array autosImg
		this.autosImg=new Image[] {Herramientas.cargarImagen("imagenes/auto1.png"),Herramientas.cargarImagen("imagenes/auto2.png"),Herramientas.cargarImagen("imagenes/auto3.png"),Herramientas.cargarImagen("imagenes/auto4.png"),Herramientas.cargarImagen("imagenes/auto5.png"),Herramientas.cargarImagen("imagenes/auto6.png"),Herramientas.cargarImagen("imagenes/auto7.png")};
		
		//inicializacion de los autos
		auto1 = new Autos(punto1.x,punto1.y,1,autosImg[0],0.8,"abajo");
		auto2 = new Autos(punto3.x,punto3.y,1,autosImg[1],0.8,"abajo");
		auto3 = new Autos(punto5.x,punto5.y,1,autosImg[2],0.8,"izquierda");
		auto4 = new Autos(punto8.x,punto8.y,1,autosImg[3],0.8,"izquierda");
		auto5 = new Autos(punto9.x,punto9.y,1,autosImg[4],0.8,"derecha");
		auto6 = new Autos(punto12.x,punto12.y,1,autosImg[5],0.8,"arriba");
		auto7 = new Autos(punto13.x,punto13.y,1,autosImg[6],0.8,"arriba");
		
		this.autos=new Autos[] {auto1, auto2, auto3, auto4, auto5, auto6, auto7};
		
		//SONIDO
		this.ladrido=Herramientas.cargarSonido("sounds/laikaLadrido.wav");
		this.musica=Herramientas.cargarSonido("sounds/sonidoNivelado.wav");
		this.rayoSound = Herramientas.cargarSonido("sounds/sonidoRayo.wav");
		this.muerte = Herramientas.cargarSonido("sounds/plantaMuerte.wav");
		this.potenciadorSonido = Herramientas.cargarSonido("sounds/potenciador.wav");
		
		//acumuladores "cooldown" inicializado en 0
		this.acTiemp=0;
		this.acBola=0;
		this.acVida = 50;
		this.velocidadNivel=1;
			
		//creacion e inicializacion plantas
		this.listaPlantas = new Planta[5];
		this.dir="";
		this.p=0;
		for(int i= 0; i<=4; i++) {
			Planta planta;
			int pos = rand.nextInt(0,6);
			if(puntosSpawn[pos]!=null) {
				if(puntosSpawn[pos]==punto2 || puntosSpawn[pos]==punto7) {
					dir="derecha";
					if(puntosSpawn[pos]==punto2) {
						p=2;
					}else {
						p=7;
					}
				}
				else if(puntosSpawn[pos]==punto4 ||puntosSpawn[pos]==punto6) {
					dir="abajo";			
					if(puntosSpawn[pos]==punto4) {
						p=4;
					}else {
						p=6;
					}
				}
				else if(puntosSpawn[pos]==punto10 || puntosSpawn[pos]==punto11) {
					dir="arriba";
					if(puntosSpawn[pos]==punto10) {
						p=10;
					}else {
						p=11;
					}
				}
				else if(puntosSpawn[pos]==punto14) {
					dir="izquierda";
					p=14;
				}
				planta = new Planta(puntosSpawn[pos].x,puntosSpawn[pos].y,40,28,0.14,dir,this.velocidadNivel,p);
				listaPlantas[i]= planta;
				puntosSpawn[pos]=null;
			}else {
				pos = rand.nextInt(0,6);
			}
		}
		//extras
		this.potenciador = new Potenciador(0,0);
		this.listaPuntos= new Point [] {punto1,punto2,punto3,punto4,punto5,punto6,punto7,punto8,punto9,punto10,punto11,punto12,punto13,punto14};
		this.laika2=new Laika(Herramientas.cargarImagen("imagenes/laika.png"),450,this.entorno.alto()-50,25,28,0.13);
		this.nivelTiempo=0;
		this.nivel="nivel1";
		
		
		//multijugador
		this.multijugador=false;
		this.seleccion=0;
		this.acTiemp2=0;
		vidas2 = new Image[this.laika.getVidas()];
		for(int i=0; i<vidas2.length;i++) {
			vidas2[i]=vida;
		}
		this.icons=new Image[] {Herramientas.cargarImagen("imagenes/p1-icon.png"),Herramientas.cargarImagen("imagenes/p2-icon.png"),Herramientas.cargarImagen("imagenes/p3-icon.png")};

			
		

		
		// Inicia el juego!
		
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		Random rand = new Random();
		//Pantalla inicio
		if(!this.pantallaInicio.getAvanzar()) {
			pantallaInicio.dibujar(this.entorno);
			this.musica.loop(3);
			this.pantallaGanar.setAvanzar(false);
			//checkear si se va a jugar en modo multijugador o un solo jugador
			if (this.entorno.sePresiono('d')||this.entorno.sePresiono('D')) {
				multijugador=true;
				
			}
			if(!multijugador) {
				if(this.entorno.sePresiono(this.entorno.TECLA_ENTER)) {
					this.pantallaInicio.setAvanzar(true);
					this.puntos=0;
					this.L1= this.personajes[this.pantallaInicio.getPos()];
					this.laika.setImg(L1);
					this.P1=this.pantallaInicio.getPos();
				}	
			}else {
				//si se selecciono multijugador, esperar a que se elijan los dos personajes
				this.laika.setX(350);
				if(this.seleccion==0) {
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/inst1.png"),402,310,0,1);
				}
				if(this.seleccion>0){
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/inst2.png"),402,310,0,1);
				}
				if(this.seleccion==2) {
					this.pantallaInicio.setAvanzar(true);
					this.puntos=0;
				}
				if(this.entorno.sePresiono(this.entorno.TECLA_ENTER)) {
					seleccion++;
					
					if(seleccion==1) {
						this.L1= this.personajes[this.pantallaInicio.getPos()];
						this.laika.setImg(L1);
						this.P1=this.pantallaInicio.getPos();
						this.icon1=this.icons[this.pantallaInicio.getPos()];
					}
					if(seleccion==2) {
						this.L2= this.personajes[this.pantallaInicio.getPos()];
						this.laika2.setImg(L2);
						this.P2=this.pantallaInicio.getPos();
						this.icon2=this.icons[this.pantallaInicio.getPos()];
					}
				}
			}
			//flechas para elegir personaje
			if(this.entorno.sePresiono(this.entorno.TECLA_DERECHA)) {
				this.pantallaInicio.setPosDer();
			}
			if(this.entorno.sePresiono(this.entorno.TECLA_IZQUIERDA)) {
				this.pantallaInicio.setPosIzq();
			}
			
		//inicio de juego
		}else {
			if(this.nivelTiempo<200){
				if(this.nivel.equals("nivel1")) {
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/nivel-1.png"), this.entorno.ancho()/2,this.entorno.alto()/2,0);
				}else if(this.nivel.equals("nivel2")) {
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/nivel-2.png"), this.entorno.ancho()/2,this.entorno.alto()/2,0);
				}else if(this.nivel.equals("nivel3")) {
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/nivel-3.png"), this.entorno.ancho()/2,this.entorno.alto()/2,0);
				}
				this.nivelTiempo++;
				
			}else {
				//Condición de continuidad de la partida
				if(multijugador) {
					if(this.laika==null && this.laika2==null) {
						this.perder=true;
						this.pantallaPerder.setAvanzar(false);
					}
				}else {
					if(this.laika==null) {
						this.perder=true;
						this.pantallaPerder.setAvanzar(false);
					}
				}
				if(!this.perder && this.plantasDerr<40 ) {
					//imagen de fondo
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/fondo.png"),this.entorno.ancho()/2,this.entorno.alto()/2 ,0);
					if(this.nivel.equals("nivel1")&&this.plantasDerr<20) {
						for(int i=0; i<listaPlantas.length;i++) {
							if(this.listaPlantas[i]!=null) {
								this.listaPlantas[i].setVelocidad(1);
							}
						}
						this.velocidadNivel=1;
					}
					//condicion de nivel
					if(this.plantasDerr==20 && this.nivel.equals("nivel1")) {
						this.nivel="nivel2";
						this.nivelTiempo=0;
						this.plantasDerr=0;
						this.vidas[0]=this.vidaMas;
						this.vidas[1]=this.vidaMas;
						this.vidas[2]=this.vidaMas;
						this.acTiemp=0;
						this.acVida=50;
						this.laika=new Laika(L1,400,this.entorno.alto()-50,25,28,0.13);
						this.laika2=new Laika(L2,450,this.entorno.alto()-50,25,28,0.13);
						for(int i=0; i<listaPlantas.length;i++) {
							this.listaPlantas[i].setVelocidad(2);
						}
						this.velocidadNivel=2;
						
					}
					if(this.plantasDerr==30 && this.nivel.equals("nivel2")) {
						this.nivel="nivel3";
						this.nivelTiempo=0;
						this.plantasDerr=0;
						this.vidas[0]=this.vidaMas;
						this.vidas[1]=this.vidaMas;
						this.vidas[2]=this.vidaMas;
						this.acTiemp=0;
						this.acVida=50;
						this.laika=new Laika(L1,400,this.entorno.alto()-50,25,28,0.13);
						this.laika2=new Laika(L2,450,this.entorno.alto()-50,25,28,0.13);
						for(int i=0; i<listaPlantas.length;i++) {
							this.listaPlantas[i].setVelocidad(2);
						}
						this.velocidadNivel=2;
					}
					
					
					//RESPAWN AUTOS
					for(int i=0; i<autos.length;i++) {
						if(autos[i]==null) {
							String dir;
							if(i<2) {
								dir="abajo";
							}else {
								if(i<4) {
									dir="izquierda";
								}else {
									if(i>4) {
										dir="arriba";
									}else {
										dir="derecha";
									}
								}
							}
							Autos auto = new Autos(this.puntosAutos[i].x,this.puntosAutos[i].y,1,autosImg[i],0.8,dir);
							autos[i]=auto;
						}
					}
					
					//DIBUJO AUTOS
					for(int i=0; i<autos.length;i++) {
						if(autos[i]!=null && !autos[i].getChoque()) {
							autos[i].dibujar(this.entorno);
						}
					}
					
					//MOVIMIENTO AUTOS
					if(autos[0].getY()==autos[4].getY()-35 && (autos[4].getX()-10<autos[0].getX())) {
					}else {
						if(!plantaCerca(autos[0],autos[0].getDir())&& !autos[0].getChoque()) {
							autos[0].mover();
						}
						
					}
					if(autos[1].getY()==autos[4].getY()-35 && (autos[4].getX()-10<autos[1].getX()&&autos[4].getX()+10>autos[1].getX()-10)) {
					}else {
						if(!plantaCerca(autos[1],autos[1].getDir())&& !autos[1].getChoque()) {
							autos[1].mover();
						}
					}
					if((autos[2].getX()==autos[1].getX()+35 && (autos[1].getY()-10<=autos[2].getY()))||(autos[2].getX()==autos[0].getX()+35 && (autos[0].getY()-10<=autos[2].getY()))) {
					}else {
						if(!plantaCerca(autos[2],autos[2].getDir())&& !autos[2].getChoque()) {
							autos[2].mover();
						}
					}
					if((autos[3].getX()==autos[1].getX()+75 && (autos[1].getY()+10<=autos[3].getY()))||(autos[3].getX()==autos[0].getX()+70 && autos[0].getX()+autos[0].getAlto()/2>0 && (autos[0].getY()-10<=autos[3].getY()))) {
					}else {
						if(!plantaCerca(autos[3],autos[3].getDir())&& !autos[3].getChoque()) {
							this.autos[3].mover();
						}
						
					}
					if((autos[4].getX()==autos[5].getX()-35 && (autos[5].getY()+10>=autos[4].getY()))||(autos[4].getX()==autos[6].getX()-35 && (autos[6].getY()+10>=autos[4].getY()))) {
					}else {
						if(!autos[4].getChoque())
						this.autos[4].mover();
					}
					if((autos[5].getY()==autos[3].getY()+55 && (autos[3].getX()>=autos[5].getX()-10))||(autos[5].getY()==autos[2].getY()+65 && (autos[2].getX()>=autos[5].getX()-10))) {
					}else {
						if(!plantaCerca(autos[5],autos[5].getDir())&& !autos[5].getChoque()) {
							autos[5].mover();
						}
						
					}
					if((autos[6].getY()==autos[3].getY()+45 && (autos[3].getX()>=autos[6].getX()-10))||(autos[6].getY()==autos[2].getY()+55 && (autos[2].getX()>=autos[6].getX()-10))) {
					}else {
						if(!plantaCerca(autos[6],autos[6].getDir())&& !autos[6].getChoque()) {
							autos[6].mover();
						}
						
					}
					for(int i=0;i<cuadras.length;i++) {
						cuadras[i].dibujar(this.entorno,i);
					}
					
					//REAPARICION AUTOS
					for (int i=0; i<autos.length;i++) {
						if(autos[i]!=null) {
							if(autos[i].getDir().equals("arriba")) {
								
								if(autos[i].getY()<-150) {
									autos[i].setY(this.entorno.alto()+30);
								}
							}
							if(autos[i].getDir().equals("abajo")) {
								if(autos[i].getY()>this.entorno.alto()+100) {
									
									autos[i].setY(-120);
								}
							}
							if(autos[i].getDir().equals("derecha")) {
								if(autos[i].getX()>this.entorno.ancho()+75) {
									autos[i].setX(-20);
								}
							}
							if(autos[i].getDir().equals("izquierda")) {
								if(autos[i].getX()<-20) {
									autos[i].setX(this.entorno.ancho()+55);
								}
							}
						}
						
					}
					
					//DIBUJO LAIKA
					if(this.laika!=null) {
						this.laika.dibujar(this.entorno);
					}
					if(this.multijugador) {
						if(this.laika2!=null) {
							this.laika2.dibujar(this.entorno);
						}
					}
					
					//MOVIMIENTO LAIKA
					if(this.laika!=null) {
						if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)&& this.laika.getX()+ this.laika.getAncho()/2<this.entorno.ancho()&& !this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)&& !this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)&& !this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
							this.laika.moverDer();
							this.laika.setDireccion("derecha");
							this.laika.setImg(personajesV[this.P1]);
						}
						if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)&& this.laika.getX()- this.laika.getAncho()/2>0 && !this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)&& !this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)&& !this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
							this.laika.moverIzq();
							this.laika.setDireccion("izquierda");
							this.laika.setImg(personajes[this.P1]);
						}
						if(this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)&& this.laika.getY()- this.laika.getAlto()/2>20 && !this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)&& !this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)&& !this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
							this.laika.moverArr();
							this.laika.setDireccion("arriba");	
						}
						if(this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)&& this.laika.getY()+ this.laika.getAlto()/2<=this.entorno.alto()&& !this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)&& !this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)&& !this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
							this.laika.moverAbj();
							this.laika.setDireccion("abajo");
						}
					}
					//MOVIMIENTO LAIKA2
					if(multijugador) {
						if(this.laika2!=null) {
							if((this.entorno.estaPresionada('d')||this.entorno.estaPresionada('D'))&& this.laika2.getX()+ this.laika2.getAncho()<this.entorno.ancho()&& (!this.entorno.estaPresionada('s')&& !this.entorno.estaPresionada('S'))&& (!this.entorno.estaPresionada('w')&& !this.entorno.estaPresionada('W'))&& (!this.entorno.estaPresionada('a')&& !this.entorno.estaPresionada('A'))) {
								this.laika2.moverDer();
								this.laika2.setDireccion("derecha");
								this.laika2.setImg(personajesV[this.P2]);
							}
							if((this.entorno.estaPresionada('a')||this.entorno.estaPresionada('A'))&& this.laika2.getX()- this.laika2.getAncho()/2>0 &&(!this.entorno.estaPresionada('s')&& !this.entorno.estaPresionada('S'))&& (!this.entorno.estaPresionada('w')&& !this.entorno.estaPresionada('W'))&& (!this.entorno.estaPresionada('d')&& !this.entorno.estaPresionada('D'))) {
								this.laika2.moverIzq();
								this.laika2.setDireccion("izquierda");
								this.laika2.setImg(personajes[this.P2]);
							}
							if((this.entorno.estaPresionada('w')||this.entorno.estaPresionada('W'))&& this.laika2.getY()- this.laika2.getAlto()>0 && (!this.entorno.estaPresionada('s')&& !this.entorno.estaPresionada('S'))&& (!this.entorno.estaPresionada('d')&& !this.entorno.estaPresionada('D'))&& (!this.entorno.estaPresionada('a')&& !this.entorno.estaPresionada('A'))) {
								this.laika2.moverArr();
								this.laika2.setDireccion("arriba");	
							}
							if((this.entorno.estaPresionada('s')||this.entorno.estaPresionada('S'))&& this.laika2.getY()+ this.laika2.getAlto()/2<=this.entorno.alto()&& (!this.entorno.estaPresionada('d')&& !this.entorno.estaPresionada('D'))&& (!this.entorno.estaPresionada('w')&& !this.entorno.estaPresionada('W'))&& (!this.entorno.estaPresionada('a')&& !this.entorno.estaPresionada('A'))) {
								this.laika2.moverAbj();
								this.laika2.setDireccion("abajo");
							}
						}
					}
					
					//LANZAR RAYOS
					if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)&&this.laika!=null && this.rayo==null) {
						this.rayo=this.laika.lanzarRayo();
						this.rayoSound.loop(1);
					}
					if(this.rayo!=null) {
						this.rayo.dibujar(this.entorno);
						this.rayo.mover();
						if(this.rayo.getX()>=this.entorno.ancho()||this.rayo.getX()<=0||this.rayo.getY()>=this.entorno.alto()||this.rayo.getY()<=0) {
							this.rayo=null;
						}
					}
					 
					if(multijugador) {
						if((this.entorno.sePresiono('f')|| this.entorno.sePresiono('F'))&&this.laika2!=null && this.rayo2==null) {
							this.rayo2=this.laika2.lanzarRayo();
							this.rayoSound.loop(1);
						}
						if(this.rayo2!=null) {
							this.rayo2.dibujar(this.entorno);
							this.rayo2.mover();
							if(this.rayo2.getX()>=this.entorno.ancho()||this.rayo2.getX()<=0||this.rayo2.getY()>=this.entorno.alto()||this.rayo2.getY()<=0) {
								this.rayo2=null;
							}
						}
					}	
//					
					
					//COLISION LAIKA CUADRAS
					for(int i=0; i<cuadras.length;i++) {
						if(this.laika!=null) {
							if (colisionCuadra(cuadras[i],this.laika) && this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) {
								this.laika.moverAbj();
								this.laika.setDireccion("abajo");
							}
							
							if (colisionCuadra(cuadras[i],this.laika) && this.entorno.estaPresionada(this.entorno.TECLA_ABAJO)) {
								this.laika.moverArr();
								this.laika.setDireccion("arriba");
							}
							
							if (colisionCuadra(cuadras[i],this.laika) && this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
								this.laika.moverIzq();
								this.laika.setDireccion("izquierda");
							}
							if (colisionCuadra(cuadras[i],this.laika) && this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
								this.laika.moverDer();	
								this.laika.setDireccion("derecha");
							}
						}
						if(multijugador) {
							if(this.laika2!=null) {
								if (colisionCuadra(cuadras[i],this.laika2)){
										if(this.entorno.estaPresionada('w')||this.entorno.estaPresionada('W')){
											this.laika2.moverAbj();
											this.laika2.setDireccion("abajo");
										}
										if(this.entorno.estaPresionada('s')||this.entorno.estaPresionada('S')) {
											this.laika2.moverArr();
											this.laika2.setDireccion("arriba");
										}
										if(this.entorno.estaPresionada('d')||this.entorno.estaPresionada('D')) {
											this.laika2.moverIzq();
											this.laika2.setDireccion("izquierda");
										}
										if(this.entorno.estaPresionada('a')||this.entorno.estaPresionada('A')) {
											this.laika2.moverDer();	
											this.laika2.setDireccion("derecha");
										}
								}
							}
						
						}
					}
					
					//COLISION LAIKA CON PLANTAS
					for (int i=0; i<this.listaPlantas.length;i++) {
						if(listaPlantas[i]!=null&&this.laika!=null && listaPlantas[i].getFlorecio()) {
							if(this.laika.getVidas()==3 || this.acTiemp>=500) {
								if(colisionPlanta(listaPlantas[i],this.laika)) {
									this.ladrido.loop(1);
									if(this.laika.getDireccion().equals("derecha")) {
										this.laika.setImg(personajesD[this.P1+3]);
										this.laika.dibujar(this.entorno);
									}else {
										this.laika.setImg(personajesD[this.P1]);
										this.laika.dibujar(this.entorno);
									}
									this.vidas[this.laika.getVidas()-1]=this.vidaMenos;
									this.ladrido.loop(1);
									this.laika.perderVida();
									if(this.laika.getVidas()==0) {
										this.ladrido.loop(1);
										this.laika=null;
									}
									acTiemp=0;
								}
							}else {
								acTiemp++;
							}
						}
						if(multijugador) {
							if(listaPlantas[i]!=null&&this.laika2!=null) {
								if(this.laika2.getVidas()==3 || this.acTiemp2>=500) {
									if(colisionPlanta(listaPlantas[i],this.laika2)) {
										this.ladrido.loop(1);
										if(this.laika2.getDireccion().equals("derecha")) {
											this.laika2.setImg(personajesD[this.P2+3]);
											this.laika2.dibujar(this.entorno);
										}else {
											this.laika2.setImg(personajesD[this.P2]);
											this.laika2.dibujar(this.entorno);
										}
										this.vidas2[this.laika2.getVidas()-1]=this.vidaMenos;
										this.ladrido.loop(1);
										this.laika2.perderVida();
										if(this.laika2.getVidas()==0) {
											this.ladrido.loop(1);
											this.laika2=null;
	
										}
										acTiemp2=0;
									}
								}else {
									acTiemp2++;
								}
							}
						}
					}
					
					//COLISION LAIKA CON AUTOS
					for (int i=0; i<this.autos.length;i++) {
						if(autos[i]!=null&&this.laika!=null) {
							if(this.laika.getVidas()==3 || this.acTiemp>=500) {
								if(colisionLaikaAuto(autos[i],this.laika)) {
									this.ladrido.loop(1);
									if(this.laika.getDireccion().equals("derecha")) {
										this.laika.setImg(personajesD[this.P1+3]);
										this.laika.dibujar(this.entorno);
									}else {
										this.laika.setImg(personajesD[this.P1]);
										this.laika.dibujar(this.entorno);
									}
									this.vidas[this.laika.getVidas()-1]=this.vidaMenos;
									this.ladrido.loop(1);
									this.laika.perderVida();
									if(this.laika.getVidas()==0) {
										this.ladrido.loop(1);
										this.laika=null;
									}
									acTiemp=0;
								}
							}else {
								acTiemp++;
							}
						}	
						if(multijugador) {
							if(autos[i]!=null&&this.laika2!=null) {
								if(this.laika2.getVidas()==3 || this.acTiemp2>=500) {
									if(colisionLaikaAuto(autos[i],this.laika2)) {
										this.ladrido.loop(1);
										if(this.laika2.getDireccion().equals("derecha")) {
											this.laika2.setImg(personajesD[this.P2+3]);
											this.laika2.dibujar(this.entorno);
										}else {
											this.laika2.setImg(personajesD[this.P2]);
											this.laika2.dibujar(this.entorno);
										}
										this.vidas2[this.laika2.getVidas()-1]=this.vidaMenos;
										this.ladrido.loop(1);
										this.laika2.perderVida();
										if(this.laika2.getVidas()==0) {
											this.ladrido.loop(1);
											this.laika2=null;
										}
										acTiemp2=0;
									}
								}else {
									acTiemp2++;
								}
							}	
						}
					}
					
					//COLISION PLANTAS CON RAYO
					for(int i=0; i<this.listaPlantas.length;i++) {
						if(listaPlantas[i]!=null && this.rayo!=null && listaPlantas[i].getFlorecio()) {
							if(colisionRayo(listaPlantas[i],this.rayo)) {
								this.muerte.loop(1);
								this.rayo=null;
								this.plantasDerr++;
								this.puntos+=5;
								switch(listaPlantas[i].getP()) {
								case 2:
									this.puntosSpawn[0]=this.punto2;
									break;
								case 4:
									this.puntosSpawn[1]=this.punto4;
									break;
								case 6:
									this.puntosSpawn[2]=this.punto6;
									break;
								case 7:
									this.puntosSpawn[3]=this.punto7;
									break;
								case 10:
									this.puntosSpawn[4]=this.punto10;
									break;
								case 11:
									this.puntosSpawn[5]=this.punto11;
									break;
								case 14:
									this.puntosSpawn[6]=this.punto14;
									break;
									
								}
								listaPlantas[i]=null;
							}
						}
					}
					if(multijugador) {
						for(int i=0; i<this.listaPlantas.length;i++) {
							if(listaPlantas[i]!=null && this.rayo2!=null) {
								if(colisionRayo(listaPlantas[i],this.rayo2)) {
									this.rayo2=null;
									this.plantasDerr++;
									this.puntos+=5;
									switch(listaPlantas[i].getP()) {
									case 2:
										this.puntosSpawn[0]=this.punto2;
										break;
									case 4:
										this.puntosSpawn[1]=this.punto4;
										break;
									case 6:
										this.puntosSpawn[2]=this.punto6;
										break;
									case 7:
										this.puntosSpawn[3]=this.punto7;
										break;
									case 10:
										this.puntosSpawn[4]=this.punto10;
										break;
									case 11:
										this.puntosSpawn[5]=this.punto11;
										break;
									case 14:
										this.puntosSpawn[6]=this.punto14;
										break;
										
									}
									listaPlantas[i]=null;
								}
							}
						}
					}
					
					 //COLISION AUTOS CON RAYO
					for (int i=0; i<autos.length;i++) {
						if(this.rayo!=null) {
							if(colisionRayoAuto(autos[i],this.rayo)) {
								this.rayo=null;
							}
						}
					}
					for (int i=0; i<autos.length;i++) {
						if(this.rayo2!=null) {
							if(colisionRayoAuto(autos[i],this.rayo2)) {
								this.rayo2=null;
							}
						}
					}
					
					//COLISION RAYOS CON CUADRAS
					for (int i=0; i<cuadras.length;i++) {
						if(this.rayo!=null) {
							if(colisionRayoCuadra(cuadras[i],this.rayo)) {
								this.rayo=null;
							}
						}
					}
					for (int i=0; i<cuadras.length;i++) {
						if(this.rayo2!=null) {
							if(colisionRayoCuadra(cuadras[i],this.rayo2)) {
								this.rayo2=null;
							}
						}
					}
					
					//MOVIMIENTO PLANTAS Y DIBUJO SI FLORECIO
					for(int i=0; i< listaPlantas.length; i++) {
						if(listaPlantas[i]!=null && listaPlantas[i].getFlorecio()) {
							listaPlantas[i].dibujar(this.entorno);
							if(listaPlantas[i]!=null) {
								this.listaPlantas[i].mover();
								if (listaPlantas[i].getX()>=this.entorno.ancho()-50) {
									this.listaPlantas[i].setDireccion("izquierda");
									
								}
								if(this.listaPlantas[i].getX()<60) {
									this.listaPlantas[i].setDireccion("derecha");
								}
								
								if(!(this.listaPlantas[i].getY()+this.listaPlantas[i].getAlto()/2<550)) {
									this.listaPlantas[i].setDireccion("arriba");
								}
								
								if(this.listaPlantas[i].getY()<=95) {
									this.listaPlantas[i].setDireccion("abajo");
								}
							}
						}
						else {
							if(listaPlantas[i]!=null) {
								listaPlantas[i].dibujarFlorecer(this.entorno);
								listaPlantas[i].setFlorecerInt(listaPlantas[i].getFlorecerInt()+1);
							}
							
						}
						
					}
					
					// REVISAR SI HAY PLANTAS, SI ALGUNA ESTA EN NULL CREAR UNA NUEVA
					String dir ="";
					int p=0;
					for(int i=0; i<this.listaPlantas.length;i++) {
						if(listaPlantas[i]==null) {
							Planta planta;
							int pos = rand.nextInt(0, 6);
							while (this.puntosSpawn[pos]==null) {
								 pos = rand.nextInt(0, 6);
								 
							}
							if(puntosSpawn[pos]!=null) {
								if(pos==0 || pos==3) {
									dir="derecha";
									if(pos==0) {
										p=2;
									}else {
										p=7;
									}
								}
								if(pos==1 ||pos==2) {
									dir="abajo";			
									if(pos==1) {
										p=4;
									}else {
										p=6;
									}
								}
								if(pos==4 || pos==5) {
									dir="arriba";
									if(pos==4) {
										p=10;
									}else {
										p=11;
									}
								}
								if(pos==6) {
									dir="izquierda";
									p=14;
								}
								planta = new Planta(this.puntosSpawn[pos].x,this.puntosSpawn[pos].y,40,28,0.14,dir,this.velocidadNivel,p);
								listaPlantas[i]= planta;
								this.puntosSpawn[pos]=null;
							}
							
							
						}
					}
		
					
					
					
					//LANZAR BOLAS DE FUEGO
					NodeFuego actualBolas;
					for(int i=0;i<listaPlantas.length;i++) {
						if(listaPlantas[i].getFlorecio()) {
							if(this.acBola>=200) {
								if(listaPlantas[i]!=null) {
									BolaDeFuego bola=this.listaPlantas[i].lanzarBola();
									NodeFuego node= new NodeFuego(bola,this.fuegoNum);
									if(bolas.getPrimero()==null) {
										bolas.setPrimero(node);
									}else {
										actualBolas=bolas.getPrimero();
										while(actualBolas.getSiguiente()!=null) {
											actualBolas=actualBolas.getSiguiente();
										}
										actualBolas.setSiguiente(node);	
									}
									fuegoNum++;
									acBola=0;
								}
							}else {
								acBola++;
							}
						}
						
					}
					
					//DIBUJO BOLAS DE FUEGO
					actualBolas=bolas.getPrimero();
					while(actualBolas!=null) {
						actualBolas.getBola().dibujar(this.entorno);
						actualBolas.getBola().mover();
						if(actualBolas.getSiguiente()!=null && (actualBolas.getSiguiente().getBola().getX()>=this.entorno.ancho()||actualBolas.getSiguiente().getBola().getX()<=0||actualBolas.getSiguiente().getBola().getY()>=this.entorno.alto()||actualBolas.getSiguiente().getBola().getY()<=0)) {
							bolas.quitarBola(actualBolas.getSiguiente().getNum());
						}
						
						actualBolas=actualBolas.getSiguiente();
					}
						
//					
					//COLISION BOLAS DE FUEGO CON AUTOS Y CON LAIKA
					NodeFuego actualBola=bolas.getPrimero();
					while(actualBola!=null) {
						for(int i=0; i<this.autos.length;i++) {
							if(autos[i]!=null&& actualBola!=null) {
								if(colisionBolaAuto(autos[i],actualBola.getBola())) {
									autos[i].setChoque(true);
									bolas.quitarBola(actualBola.getNum());
									
								}
							}
							
						}
						if(this.laika!=null) {
							if(this.laika.getVidas()==3 || this.acTiemp>=500) {
								if(colisionBolaLaika(actualBola.getBola(),this.laika) ) {
									this.ladrido.loop(1);
									bolas.quitarBola(actualBola.getNum());
									if(this.laika.getDireccion().equals("derecha")) {
										this.laika.setImg(personajesD[this.P1+3]);
										this.laika.dibujar(this.entorno);
									}else {
										this.laika.setImg(personajesD[this.P1]);
										this.laika.dibujar(this.entorno);
									}
									this.vidas[this.laika.getVidas()-1]=this.vidaMenos;
									this.ladrido.loop(1);
									this.laika.perderVida();
									if(this.laika.getVidas()==0) {
										this.ladrido.loop(1);
										this.laika=null;
									}
									acTiemp=0;
								}else {
									acTiemp++;
								}
							}
						}
						if(multijugador) {
							if(this.laika2!=null) {
								if(this.laika2.getVidas()==3 || this.acTiemp2>=500) {
									if(colisionBolaLaika(actualBola.getBola(),this.laika2) ) {
										this.ladrido.loop(1);
										bolas.quitarBola(actualBola.getNum());
										if(this.laika2.getDireccion().equals("derecha")) {
											this.laika2.setImg(personajesD[this.P2+3]);
											this.laika2.dibujar(this.entorno);
										}else {
											this.laika2.setImg(personajesD[this.P2]);
											this.laika2.dibujar(this.entorno);
										}
										this.vidas2[this.laika2.getVidas()-1]=this.vidaMenos;
										this.ladrido.loop(1);
										this.laika2.perderVida();
										if(this.laika2.getVidas()==0) {
											this.ladrido.loop(1);
											this.laika2=null;
										}
										acTiemp=0;
									}else {
										acTiemp++;
									}
								}
							}
						}
						
						actualBola=actualBola.getSiguiente();
					}
					
					for (int i=0;i<autos.length;i++) {
						if(autos[i]!=null && autos[i].getChoque()) {
							autos[i].dibujarChoque(entorno);
							autos[i].setChoqueInt();
							if(autos[i].getChoqueInt()>=40) {
								autos[i]=null;
							}
						}
						
					}

					//COLISION BOLAS DE FUEGO CON RAYO
					
					actualBolas=bolas.getPrimero();
					while(actualBolas!=null && this.rayo!=null) {
							if(colisionRayoBola(actualBolas.getBola(),this.rayo)) {
								bolas.quitarBola(actualBolas.getNum());
								this.rayo=null;
								
						}
						actualBolas=actualBolas.getSiguiente();
					}
					
					if(multijugador) {
						actualBolas=bolas.getPrimero();
						while(actualBolas!=null && this.rayo2!=null) {
								if(colisionRayoBola(actualBolas.getBola(),this.rayo2)) {
									bolas.quitarBola(actualBolas.getNum());
									this.rayo2=null;
									
							}
							actualBolas=actualBolas.getSiguiente();
						}
					}
					
					
					//EXTRAS
					
					//POTENCIADOR, SUBE UNA VIDA
					if(this.potenciador.getCooldown()<0) {
						if  (this.potenciador.getDuracion()>0) {
							this.potenciador.dibujar(this.entorno);
							this.potenciador.setDuracion(this.potenciador.getDuracion()-1);
						} else {
							int posPot = rand.nextInt(0, 13);
							this.potenciador.setX(this.listaPuntos[posPot].x);
							this.potenciador.setY(this.listaPuntos[posPot].y);
							this.potenciador.setUsado(false);
							this.potenciador.setDuracion(1000);
							this.potenciador.setCooldown(1000);
						}
		
					} else  {
						this.potenciador.setCooldown(this.potenciador.getCooldown()-1);
					}
					
					if(colisionLaikaPot(this.laika)) {
						if(this.laika.getVidas()<3 && this.laika.getVidas()>0) {
							if(acVida>=50) {
								this.laika.ganarVida();
								this.potenciadorSonido.loop(1);
								this.vidas[this.laika.getVidas()-1]=this.vidaMas;
								this.acVida=0;
								this.potenciador.setUsado(true);
							}
							
						}
					}
					this.acVida++;
					if(multijugador) {
						if(colisionLaikaPot(this.laika2)) {
							if(this.laika2.getVidas()<3 && this.laika2.getVidas()>0) {
								if(acVida>=50) {
									this.laika2.ganarVida();
									this.potenciadorSonido.loop(0);
									this.vidas2[this.laika2.getVidas()-1]=this.vidaMas;
									this.acVida=0;
									this.potenciador.setUsado(true);
								}
							}
						}
					}
					
					//BARRA DE PUNTOS, VIDAS Y PLANTAS DERROTADAS
					
					this.entorno.dibujarRectangulo(entorno.ancho()/2,20,this.entorno.ancho(),40,0,this.colorBarra);
					if(!multijugador) {
						for(int i=0; i<vidas.length;i++) {
							this.entorno.dibujarImagen(vidas[i],this.vidasX,20,0,0.5);
							vidasX+=40;
						}
						vidasX=50;
					}else {
							this.entorno.dibujarImagen(this.icon1,this.vidasX, 20,0,0.15);
							vidasX+=40;
							for(int i=0;i<vidas.length;i++) {
								this.entorno.dibujarImagen(vidas[i],this.vidasX,20,0,0.4);
								vidasX+=30;
							}
							vidasX+=10;
							this.entorno.dibujarImagen(this.icon2,this.vidasX,20,0,0.15);
							vidasX+=40;
							for(int i=0;i<vidas2.length;i++) {
								this.entorno.dibujarImagen(vidas2[i],this.vidasX,20,0,0.4);
								vidasX+=30;
							}
							vidasX=50;
						
					}
		
					
					this.entorno.dibujarImagen(this.plantaIcon,660, 20,0,0.5);
					this.entorno.cambiarFont("Comic Sans MS",29,Color.green);
					if(this.nivel.equals("nivel1")) {
						this.entorno.escribirTexto(String.valueOf(this.plantasDerr)+"/20", 700, 30);
					}else if(this.nivel.equals("nivel2")) {
						this.entorno.escribirTexto(String.valueOf(this.plantasDerr)+"/30", 700, 30);
					}else if( this.nivel.equals("nivel3")) {
						this.entorno.escribirTexto(String.valueOf(this.plantasDerr)+"/40", 700, 30);
					}
					
					this.entorno.cambiarFont("Comic Sans MS",20,Color.white);
					this.entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/puntos.png"),401,20,0,0.5);
					this.entorno.escribirTexto(String.valueOf(this.puntos),425, 27);
				
			}else {
				//TERMINAR PARTIDA
				
				//PERDER
				if(this.perder) {
					if(!this.pantallaPerder.getAvanzar()) {
						this.pantallaPerder.dibujar(this.entorno);
						if(this.entorno.sePresiono(this.entorno.TECLA_ENTER)) {
							//REINICIO DE VALORES
							this.perder=false;
							this.puntos=0;
							this.plantasDerr=0;
							this.laika=new Laika(Herramientas.cargarImagen("imagenes/laika.png"),400,this.entorno.alto()-50,25,28,0.13);
							this.laika2=new Laika(Herramientas.cargarImagen("imagenes/laika.png"),450,this.entorno.alto()-50,25,28,0.13);
							this.pantallaInicio.setAvanzar(false);
							this.vidas[0]=this.vidaMas;
							this.vidas[1]=this.vidaMas;
							this.vidas[2]=this.vidaMas;
							this.vidas2[0]=this.vidaMas;
							this.vidas2[1]=this.vidaMas;
							this.vidas2[2]=this.vidaMas;
							this.acTiemp=0;
							this.acVida=50;
							this.nivel="nivel1";
							this.nivelTiempo=0;
							
							this.pantallaPerder.setAvanzar(true);
							this.pantallaInicio.setAvanzar(false);
							this.pantallaInicio.dibujar(this.entorno);
							this.multijugador=false;
							this.seleccion=0;
							
							}
						if (this.entorno.sePresiono('s')||this.entorno.sePresiono('s' )) {
						       this.entorno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						       this.entorno.setLocationRelativeTo(null);
						       this.entorno.setVisible(false);
						       this.musica.stop();
						
						}
					}
					
					
				}
				//GANAR PARTIDA
				else if (!this.perder && plantasDerr>=40) {
					if(!this.pantallaGanar.getAvanzar()) {
						this.pantallaGanar.dibujar(this.entorno);
						if(this.entorno.sePresiono(this.entorno.TECLA_ENTER)) {
							//REINICIO DE VALORES
							this.puntos=0;
							this.plantasDerr=0;
							this.laika=new Laika(Herramientas.cargarImagen("imagenes/laika.png"),400,this.entorno.alto()-50,25,28,0.13);
							this.laika2=new Laika(Herramientas.cargarImagen("imagenes/laika.png"),450,this.entorno.alto()-50,25,28,0.13);
							this.pantallaInicio.setAvanzar(false);
							this.vidas[0]=this.vidaMas;
							this.vidas[1]=this.vidaMas;
							this.vidas[2]=this.vidaMas;
							this.vidas2[0]=this.vidaMas;
							this.vidas2[1]=this.vidaMas;
							this.vidas2[2]=this.vidaMas;
							this.acTiemp=0;
							this.acVida=50;
							this.nivel="nivel1";
							this.nivelTiempo=0;
							this.pantallaInicio.setAvanzar(false);
							this.pantallaGanar.setAvanzar(true);
							this.perder=false;
							this.multijugador=false;
							this.seleccion=0;
							
	
			
							
							}
						if (this.entorno.sePresiono('s')||this.entorno.sePresiono('S')) {
						       this.entorno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						       this.entorno.setLocationRelativeTo(null);
						       this.entorno.setVisible(false);
						       this.musica.stop();
						}
					}
						
				}
				
			}
					
		}
					
		}
	}


	
	
	//Funcion colision Laika con cuadra
	public boolean colisionCuadra(Cuadras c, Laika l) {
		boolean colisionX=(l.getX()+l.getAncho()/2)>= c.getPoint(3).x && (l.getX()-l.getAncho()/2)<=c.getPoint(4).x;
		
		boolean colisionY=(l.getY()-l.getAlto()/2)<= c.getPoint(3).y && (l.getY()+l.getAlto()/2)>=c.getPoint(1).y;
		
		return colisionX && colisionY;
	}
	//Funcion colision Planta con Laika
	public boolean colisionPlanta(Planta p,Laika l) {
		boolean colisionX=(l.getX()+l.getAncho()/2)>= p.getX()-p.getAncho()/2 && (l.getX()-l.getAncho()/2)<=p.getX()+p.getAncho()/2;
		
		boolean colisionY=(l.getY()-l.getAlto()/2)<= p.getY()+p.getAlto()/2 && (l.getY()+l.getAlto()/2)>= p.getY()-p.getAlto()/2;
		
		return colisionX && colisionY;
	}
	//Funcion colision bola de fuego con Laika
	public boolean colisionBolaLaika(BolaDeFuego b, Laika l) {
		boolean colisionX=(l.getX()+l.getAncho()/2)>= b.getX()-b.getAncho()/2 && (l.getX()-l.getAncho()/2)<=b.getX()+b.getAncho()/2;
		
		boolean colisionY=(l.getY()-l.getAlto()/2)<= b.getY()+b.getAlto()/2 && (l.getY()+l.getAlto()/2)>= b.getY()-b.getAlto()/2;
		
		return colisionX && colisionY;
	}
	//Funcion colision Laika con auto
	public boolean colisionLaikaAuto(Autos a,Laika l) {
		boolean colisionX=(l.getX()+l.getAncho()/2)>= a.getX()-a.getAncho()/2 && (l.getX()-l.getAncho()/2)<=a.getX()+a.getAncho()/2;
		
		boolean colisionY=(l.getY()-l.getAlto()/2)<= a.getY()+a.getAlto()/2 && (l.getY()+l.getAlto()/2)>= a.getY()-a.getAlto()/2;
		
		return colisionX && colisionY;
	}
	//Funcion colision Planta con Rayo
	public boolean colisionRayo(Planta p, Rayo r) {
		boolean colisionX=(r.getX()>=p.getX()-p.getAncho()/2)&&(r.getX()<=p.getX()+p.getAncho()/2);
		
		boolean colisionY=(r.getY()<=p.getY()+p.getAlto()/2)&&(r.getY()>=p.getY()-p.getAlto()/2);
		
		return colisionX && colisionY;
	}
	//Funcion colision Bola de Fuego con Rayo
	public boolean colisionRayoBola(BolaDeFuego b, Rayo r) {
		boolean colisionX=(r.getX()>=b.getX()-b.getAncho()/2)&&(r.getX()<=b.getX()+b.getAncho()/2);
		
		boolean colisionY=(r.getY()<=b.getY()+b.getAlto()/2)&&(r.getY()>=b.getY()-b.getAlto()/2);
		
		return colisionX && colisionY;
	}
	//Funcion colision Auto con Rayo
	public boolean colisionRayoAuto(Autos a, Rayo r) {
		boolean colisionX=(r.getX()>=a.getX()-a.getAncho()/2) && (r.getX()<=a.getX()+a.getAncho()/2);
		
		boolean colisionY=(r.getY()<=a.getY()+a.getAlto()/2)&&(r.getY()>=a.getY()-a.getAlto()/2);
		
		return colisionX && colisionY;
	}
	//Funcion colision Rayo con cuadra
	public boolean colisionRayoCuadra(Cuadras c, Rayo r) {
		boolean colisionX=(r.getX()>=c.getPoint(3).x) && (r.getX()<=c.getPoint(4).x);
		
		boolean colisionY=(r.getY()<=c.getPoint(3).y)&&(r.getY()>=c.getPoint(1).y);
		
		return colisionX && colisionY;
	}
	//Funcion colision Bola de Fuego con Auto
	public boolean colisionBolaAuto(Autos a, BolaDeFuego b) {
		boolean colisionX=(b.getX()>=a.getX()-a.getAncho()/2) && (b.getX()<=a.getX()+a.getAncho()/2);
		
		boolean colisionY=(b.getY()<=a.getY()+a.getAlto()/2)&&(b.getY()>=a.getY()-a.getAlto()/2);
		
		return colisionX && colisionY;
	}
	//Funcion colision Laika con potenciador
	public boolean colisionLaikaPot(Laika l) {
		boolean colisionX = false;
		boolean colisionY = false;
		if(l!=null && this.potenciador!=null) {
			colisionX=(l.getX()+l.getAncho()/2)>= this.potenciador.getX() && (l.getX()-l.getAncho()/2)<=this.potenciador.getX();
			
			colisionY=(l.getY()-l.getAlto()/2)<= this.potenciador.getY() && (l.getY()+l.getAlto()/2)>= this.potenciador.getY();
		}
		return colisionX && colisionY;
	}
	
	//Funcion Planta cerca de auto
	public boolean plantaCerca(Autos a, String dir) {
		boolean cerca=false;
		for(int i=0; i<this.listaPlantas.length;i++) {
			if(this.listaPlantas[i]!=null) {
				if(dir.equals("abajo")) {
					if(a.getY()+35==this.listaPlantas[i].getY()) {
						if(this.listaPlantas[i].getP()==2||this.listaPlantas[i].getP()==7 ||this.listaPlantas[i].getP()==14 ) {
							if(this.listaPlantas[i].getDir().equals("derecha")) {
								if(this.listaPlantas[i].getX()+10>a.getX()-20 && this.listaPlantas[i].getX()-10<a.getX()+20) {
									cerca=true;
								}
								else {
									cerca=false;
								}
							}
							if(this.listaPlantas[i].getDir().equals("izquierda")) {
								if(this.listaPlantas[i].getX()-10<a.getX()+20 && this.listaPlantas[i].getX()+10>a.getX()-20) {
										cerca=true;
								}
								else {
									cerca=false;
								}
							}
						}
					}
				}
				if(dir.equals("arriba")) {
						if(a.getY()-35==this.listaPlantas[i].getY()) {
							if(this.listaPlantas[i].getP()==7||this.listaPlantas[i].getP()==14 ||this.listaPlantas[i].getP()==2) {
								if(this.listaPlantas[i].getDir().equals("derecha")) {
									if(this.listaPlantas[i].getX()+10>a.getX()-20 && this.listaPlantas[i].getX()-10<a.getX()+20) {
										cerca=true;
									}
									else {
										cerca=false;
									}
								}
								if(this.listaPlantas[i].getDir().equals("izquierda")) {
									if(this.listaPlantas[i].getX()-10<a.getX()+20 && this.listaPlantas[i].getX()+10>a.getX()-20) {
										cerca=true;
									}
									else {
										cerca=false;
									}
								}
							}
						}
				}
				if (dir.equals("izquierda")) {
					if(this.listaPlantas[i].getP()==4||this.listaPlantas[i].getP()==6 ||this.listaPlantas[i].getP()==10 ||this.listaPlantas[i].getP()==11) {
						if(a.getX()-35==this.listaPlantas[i].getX()) {
							if(this.listaPlantas[i].getDir().equals("abajo")) {
								if(this.listaPlantas[i].getY()+10>a.getY()-20 && this.listaPlantas[i].getY()-10<a.getY()+20) {
									cerca=true;
								}
								else {
									cerca=false;
								}
							}
							if(this.listaPlantas[i].getDir().equals("arriba")) {
								if(this.listaPlantas[i].getY()-10<a.getY()+20 && this.listaPlantas[i].getY()+10>a.getY()-20) {
									cerca=true;
								}
								else {
									cerca=false;
								}
							}
						}
					}
				}
			}
			}
		return cerca;
	}
	


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}

