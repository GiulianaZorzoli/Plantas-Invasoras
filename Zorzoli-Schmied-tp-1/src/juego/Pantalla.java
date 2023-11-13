package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Pantalla {
	private int x;
	private int y;
	private String tipo;
	private Image [] personajes;
	private int posP;
	
	private boolean avanzar;
	
	public Pantalla(int x, int y, String tipo,Image[]personajes) {
		this.x=x;
		this.y=y;
		this.tipo=tipo;
		this.avanzar=false;
		this.personajes=personajes;
		this.posP=0;
	}
	//DIBUJAR
	public void dibujar(Entorno entorno) {
		if ( this.tipo.equals("inicio")) {
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/p-inicio.png"), this.x, this.y,0);
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/btn-enter.png"), this.x-100, this.y+250, 0,0.6);
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/f-der.png"), this.x+350, this.y, 0,0.4);
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/f-izq.png"), this.x-350, this.y, 0,0.4);
			entorno.dibujarImagen(personajes[this.posP], this.x, this.y, 0,1);
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/btn-d.png"), this.x+100, this.y+250, 0,0.6);
		}
		if ( this.tipo.equals("ganador")) {
			
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/winner.png"), this.x, this.y,0);
	
		}
		if ( this.tipo.equals("perdedor")) {
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/gameOver.png"), this.x, this.y,0);
			
		}
	}
	//GETTERS
	public boolean getAvanzar() {
		return this.avanzar;
	}
	public int getPos() {
		return this.posP;
	}

	//SETTERS
	public void setAvanzar(boolean t){
			this.avanzar=t;
	}
	public void setPosDer() {
		if(this.posP<personajes.length-1) {
			posP++;
		}else {
			posP=0;
		}
	}
	public void setPosIzq() {
		if(this.posP>0) {
			posP--;
		}else {
			posP=this.personajes.length-1;
		}
	}
	
	
	
}
