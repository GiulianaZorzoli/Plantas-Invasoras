package juego;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.*;

public class BolaDeFuego {
	private int x;
	private int y;
	private int velocidad;
	private Image img;
	private String direccion;
	private int ancho;
	private int alto;
	private double angulo;
	
	
	public BolaDeFuego(int x, int y, int velocidad,double angulo,String direccion) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;	
		this.img=Herramientas.cargarImagen("imagenes/bolaFuego.png");
		this.direccion=direccion;
		this.ancho=20;
		this.alto=20;
		this.angulo=angulo;
	}
	//DIBUJAR
	public void dibujar(Entorno entorno){
		entorno.dibujarImagen(this.img, this.x, this.y,this.angulo,0.5);
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
	public int getAncho() {
		return this.ancho;
		}
	public int getAlto() {
		return this.alto;
		}

	public int getVelocidad() {
		return this.velocidad;
		}	
	
}



