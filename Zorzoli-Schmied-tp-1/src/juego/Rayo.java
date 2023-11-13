package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Rayo {
	private int x;
	private int y;
	private int angulo;
	private String direccion;

	public Rayo(int x, int y, int angulo,String direccion) {
		this.x=x;
		this.y=y;
		this.angulo=angulo;
		this.direccion=direccion;
	}
	//DIBUJAR
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/rayo.png"), this.x, this.y,this.angulo ,0.05);
	}
	//MOVER
	public void mover() {
		if(this.direccion.equals("derecha")) {
			this.x=this.x+4;
		}
		if(this.direccion.equals("izquierda")) {
			this.x=this.x-4;
		}
		if(this.direccion.equals("arriba")) {
			this.y=this.y-4;
		}
		if(this.direccion.equals("abajo")) {
			this.y=this.y+4;
		}	
	}
	//GETTERS
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
