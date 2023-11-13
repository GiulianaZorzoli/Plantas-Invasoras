package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Potenciador {
	private int x;
	private int y;
	private int duracion;
	private int cooldown;
	private boolean usado;
	
	public Potenciador(int x, int y) {
		this.x = x;
		this.y = y;
		this.duracion = 1000;
		this.cooldown = 500;
		this.usado = false;
	}
//DIBUJAR
	public void dibujar(Entorno entorno) {
		if(!usado) {
			entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/vida.png"), this.x, this.y,0,0.5);
		}
		
	}
//GETTERS
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getDuracion() {
		return this.duracion;
	}
	public int getCooldown() {
		return this.cooldown;
	}
	public boolean getUsado() {
		return this.usado;
	}
//SETTERS
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setDuracion(int d) {
		this.duracion=d;
	}
	public void setCooldown(int c) {
		this.cooldown=c;
	}
	public void setUsado(boolean s) {
		this.usado=s;
	}
}
