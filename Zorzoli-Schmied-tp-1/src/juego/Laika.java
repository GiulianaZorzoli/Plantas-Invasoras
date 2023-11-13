package juego;

import java.awt.Image;
import entorno.Entorno;

public class Laika {
	private Image img;
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private double escala;
	private String direccion;
	private int vidas;
	private int anguloRayo;
	
	public Laika(Image img , int x, int y, int alto, int ancho, double escala) {
		this.img=img;
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.escala=escala;
		this.direccion="derecha";
		this.vidas=3;
		this.anguloRayo=0;


	}
	
	//DIBUJAR
	public void dibujar(Entorno entorno){
		entorno.dibujarImagen(this.img, this.x, this.y,0, this.escala);
	}
	//MOVIMIENTO
	public void moverDer() {
		this.x=this.x+2;
	}
	public void moverIzq() {
		this.x=this.x-2;
	}
	public void moverArr() {
		this.y=this.y-2;
	}
	public void moverAbj() {
		this.y=this.y+2;
	}
	//GETTERS
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public int getVidas() {
		return this.vidas;
	}
	//SETTERS
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	public void setImg(Image img) {
		this.img=img;
	}
	public void perderVida() {
		this.vidas--;
	}
	public void ganarVida() {
		this.vidas++;
	}
	public void setVidas(int n) {
		this.vidas=n;
	}
	//RAYO
	public Rayo lanzarRayo() {
		if(this.direccion.equals("derecha")) {
			this.anguloRayo=0;
		}else if(this.direccion.equals("izquierda")) {
			this.anguloRayo=180;
		}else if(this.direccion.equals("arriba")) {
			this.anguloRayo=90;
		}else {
			this.anguloRayo=270;
		}
		Rayo rayo= new Rayo(this.x,this.y,this.anguloRayo,this.direccion);
		return rayo;
	}
	
}

