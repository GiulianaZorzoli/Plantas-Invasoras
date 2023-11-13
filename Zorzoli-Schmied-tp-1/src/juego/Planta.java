package juego;
import java.awt.Image;
import java.awt.Point;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	private Image img;
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private double escala;
	private String direccion;
	private int velocidad;
	private int punto;
	private int anguloBola;
	private Image[]florecer;
	private int florecerInt;
	private boolean florecio;
	
	public Planta(int x, int y, int alto, int ancho, double escala, String direccion, int velocidad, int p) {
		this.img=Herramientas.cargarImagen("imagenes/plantita.png");
		this.ancho=ancho;
		this.alto=alto;
		this.escala=escala;
		this.direccion=direccion;
		this.velocidad=velocidad;
		this.x=x;
		this.y=y;
		this.punto=p;
		this.anguloBola=0;
		this.florecer=new Image[] {Herramientas.cargarImagen("imagenes/planta1.png"),Herramientas.cargarImagen("imagenes/planta2.png"),Herramientas.cargarImagen("imagenes/planta3.png"),Herramientas.cargarImagen("imagenes/planta4.png"),Herramientas.cargarImagen("imagenes/planta5.png"),Herramientas.cargarImagen("imagenes/planta6.png"),Herramientas.cargarImagen("imagenes/planta7.png"),Herramientas.cargarImagen("imagenes/planta8.png"),Herramientas.cargarImagen("imagenes/planta9.png")};
		this.florecerInt=0;
		this.florecio=false;
	}
//DIBUJAR
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.img, this.x, this.y,0, escala);
	}
	//Florecer
	public void dibujarFlorecer(Entorno entorno) {
		if(this.florecerInt<=20) {
			entorno.dibujarImagen(florecer[0], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=40) {
			entorno.dibujarImagen(florecer[1], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=60) {
			entorno.dibujarImagen(florecer[2], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=80) {
			entorno.dibujarImagen(florecer[3], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=100) {
			entorno.dibujarImagen(florecer[4], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=120) {
			entorno.dibujarImagen(florecer[5], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=140) {
			entorno.dibujarImagen(florecer[6], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=160) {
			entorno.dibujarImagen(florecer[7], this.x, this.y,0, escala);
		}
		else if(this.florecerInt<=180) {
			entorno.dibujarImagen(florecer[8], this.x, this.y,0, escala);
			if(this.florecerInt==180) {
				this.florecio=true;
			}
			
		}
		
	}
//MOVER
	public void mover() {
		if(this.direccion.equals("derecha")) {
			this.x=this.x+this.velocidad;
		}
		if(this.direccion.equals("izquierda")) {
			this.x=this.x-this.velocidad;
		}
		if(this.direccion.equals("arriba")) {
			this.y=this.y-this.velocidad;
		}
		if(this.direccion.equals("abajo")) {
			this.y=this.y+this.velocidad;
		}	
		
	}
//GETTERS
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getAlto(){
		return  this.alto;
	}
	public int getAncho(){
		return  this.ancho;
	}
	public String getDir() {
		return this.direccion;
	}
	public int getP() {
		return this.punto;
	}
	public int getFlorecerInt() {
		return this.florecerInt;
	}
	public boolean getFlorecio() {
		return this.florecio;
	}
//SETTERS
	public void setDireccion(String dir) {
		this.direccion=dir;
	}
	public void setXY(Point p) {
		this.x=p.x;
		this.y=p.y;
	}

	public void setImg(String url) {
		Image img=Herramientas.cargarImagen(url);
		this.img=img;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}
	public void setFlorecerInt(int n) {
		this.florecerInt=n;
	}
//CREACION BOLA DE FUEGO
	public BolaDeFuego lanzarBola() {

		if(this.direccion.equals("derecha")) {
			this.anguloBola=0;
		}else if(this.direccion.equals("izquierda")) {
			this.anguloBola=185;
		}else if(this.direccion.equals("arriba")) {
			this.anguloBola=200;
		}else {
			this.anguloBola=90;
		}
		BolaDeFuego bola= new BolaDeFuego(this.x, this.y,this.velocidad+1,this.anguloBola,this.direccion);
		return bola;
	}
	                                                                             
}
