package control;

import modelo.Tipo;

public class Juego {
	private int cantidadJugadores = 2;
	private int cantidadFichas = 3;
	private int numeroJugada = 0;
	private boolean mover = false;

	public String getTurnoActualName() {
		// si es impar le toca a X
		return getTurnoActual().getNombre();
	}

	public Tipo getTurnoActual() {
		if (numeroJugada % 2 == 0) {
			return Tipo.O;
		}
		return Tipo.X;
	}

	public void incrementaJugada() {
		this.numeroJugada++;
		if (this.numeroJugada > 6) {
			this.setMover(true);
		}
	}

	public void setMover(boolean b) {
		this.mover = b;

	}

	public int getNumeroJugada() {
		return this.numeroJugada;
	}

}
