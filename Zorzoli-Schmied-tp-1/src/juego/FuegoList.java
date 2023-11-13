package juego;

public class FuegoList {
	private NodeFuego primero;
	
	public FuegoList() {
		this.primero=null;
	}
	//GETTER
	public NodeFuego getPrimero() {
		return this.primero;
	}
	//SETTER
	public void setPrimero(NodeFuego bola) {
		this.primero=bola;
	}
	//ELIMINAR BOLA DE FUEGO
	public void quitarBola(int n) {
		if(this.primero!=null && this.primero.getNum()==n) {
			this.primero=this.primero.getSiguiente();
		}else {
			NodeFuego actual=this.primero;
			while(actual.getSiguiente()!=null && actual.getSiguiente().getNum()!=n) {
				actual=actual.getSiguiente();
			}
			if(actual.getSiguiente()!=null) {
				actual.setSiguiente(actual.getSiguiente().getSiguiente());
			}
		}
	}
}