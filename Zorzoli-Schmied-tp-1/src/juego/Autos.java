package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Autos {
	private int x;
	private int y;
	private int velocidad;
	private String direccion;
	private double escala;
	private int ancho;
	private int alto;
	private Image imagen;
	private boolean choque;
	private int choqueInt;
	private Image[] choqueImg;
	
	
	public Autos(int x, int y, int velocidad, Image img, double escala,String direccion) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.imagen =img;
		this.escala = escala;
		this.direccion=direccion;
		this.alto=20;
		this.ancho=40;
		this.choqueImg= new Image[] {Herramientas.cargarImagen("imagenes/choque1.png"),Herramientas.cargarImagen("imagenes/choque2.png"),Herramientas.cargarImagen("imagenes/choque3.png"),Herramientas.cargarImagen("imagenes/choque4.png"),Herramientas.cargarImagen("imagenes/choque5.png")};
		this.choque=false;
		this.choqueInt=0;
	}
	
	//DIBUJAR
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen,this.x, this.y,0, this.escala);
	
	}
	
	public void dibujarChoque(Entorno entorno) {
		if(this.choqueInt<5) {
			entorno.dibujarImagen(this.imagen,this.x, this.y,0, this.escala);
			entorno.dibujarImagen(choqueImg[0], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<10) {	
			entorno.dibujarImagen(this.imagen,this.x, this.y,0, this.escala);
			entorno.dibujarImagen(choqueImg[1], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<15) {
			entorno.dibujarImagen(this.imagen,this.x, this.y,0, this.escala);
			entorno.dibujarImagen(choqueImg[2], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<20) {
			entorno.dibujarImagen(this.imagen,this.x, this.y,0, this.escala);
			entorno.dibujarImagen(choqueImg[3], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<25) {	
			entorno.dibujarImagen(choqueImg[2], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<30) {	
			entorno.dibujarImagen(choqueImg[1], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<35) {	
			entorno.dibujarImagen(choqueImg[0], this.x, this.y, 0, this.escala);
		}
		else if(this.choqueInt<40) {	
			entorno.dibujarImagen(choqueImg[4], this.x, this.y, 0, this.escala);
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
		return x;
	}
	public int getY() {
		return y;
	}
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	public String getDir() {
		return this.direccion;
	}
	public boolean getChoque() {
		return this.choque;
	}
	public int getChoqueInt() {
		return this.choqueInt;
	}


	//SETTERS
	public void setX(int nuevoX) {
		 this.x = nuevoX;
		
	}
	public void setY(int nuevoY) {
		 this.y = nuevoY;
		
	}
	public void setChoque(boolean a) {
		this.choque=a;
	}
	public void setChoqueInt () {
		this.choqueInt++;
	}

}



