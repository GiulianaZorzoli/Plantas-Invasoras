package juego;

public class NodeFuego {
	private BolaDeFuego bola;
	private int num;
	private NodeFuego siguiente;
	
	public NodeFuego(BolaDeFuego bola, int num) {
		this.bola=bola;
		this.siguiente=null;
		this.num=num;
	}
	//GETTERS
	public  BolaDeFuego getBola() {
		return this.bola;
	}
	public NodeFuego getSiguiente() {
		return this.siguiente;
	}
	public int getNum() {
		return this.num;
	}
	//SETTER
	public void setSiguiente(NodeFuego node) {
		this.siguiente=node;
	}
}