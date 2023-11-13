package juego;
import java.awt.Image;
import java.util.Random;
import java.awt.*;
import entorno.Entorno;
import entorno.Herramientas;

public class Cuadras {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Point punto1;
	private Point punto2;
	private Point punto3;
	private Point punto4;
	private Image[] imagenes;
	private Random rand;
	private Image casa1;
	private Image casa2;
	private Image casa3;
	private Image casa4;
	
	public Cuadras(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.punto1=new Point((this.x-(this.ancho/2)),(this.y-(this.alto/2)));
		this.punto2=new Point((this.x+(this.ancho/2)),(this.y-(this.alto/2)));
		this.punto3=new Point((this.x-(this.ancho/2)),(this.y+(this.alto/2)));
		this.punto4=new Point((this.x+(this.ancho/2)),(this.y+(this.alto/2)));
		this.imagenes=new Image[] {Herramientas.cargarImagen("imagenes/casa1.png"),Herramientas.cargarImagen("imagenes/casa2.png"),Herramientas.cargarImagen("imagenes/casa3.png"),Herramientas.cargarImagen("imagenes/casa4.png"),Herramientas.cargarImagen("imagenes/casa5.png"),Herramientas.cargarImagen("imagenes/casa6.png"),Herramientas.cargarImagen("imagenes/casa7.png"),Herramientas.cargarImagen("imagenes/casa8.png"),Herramientas.cargarImagen("imagenes/casa9.png")};
		this.rand=new Random();
		this.casa1=imagenes[rand.nextInt(0,4)];
		this.casa2=imagenes[rand.nextInt(4,8)];
		this.casa3=imagenes[rand.nextInt(0,4)];
		this.casa4=imagenes[rand.nextInt(4,8)];

	}
//DIBUJAR
	public void dibujar(Entorno entorno, int pos) {
		entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/manzana.png"),this.x,this.y,0);
		entorno.dibujarImagen(this.casa1,punto1.x+50,punto1.y+50,0,0.75);
		entorno.dibujarImagen(this.casa2,punto2.x-50,punto2.y+50,0,0.75);
		entorno.dibujarImagen(this.casa3,punto3.x+50,punto3.y-50,0,0.75);
		entorno.dibujarImagen(this.casa4,punto4.x-50,punto4.y-50,0,0.75);
	}
//GETTERS
	public int getX() {
		return x;
		}

	public int getY() {
		return y;
		}
	
	public int getAncho() {
		return x;
		}

	public int getAlto() {
		return y;
		}
	
	public Point getPoint(int n) {
		if(n==1) {
			return this.punto1;
		}else if(n==2) {
			return this.punto2;
		}else if(n==3) {
			return this.punto3;
		}else {
			return this.punto4;
		}
	}
}

