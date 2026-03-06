package control;

import modelo.Tipo;

public class Juego {
	private int cantidadJugadores = 2;
	private int cantidadFichas = 3;
	private int numeroJugada = 0;
	private boolean mover = false;

//	public boolean isJugadaMovimiento() {
//		return numeroJugada > 6;
//	}

	public String getTurnoActualName() {
		// si es impar le toca a X
		return getTurnoActual().getNombre();
	}
	// Debes declarar esta variable como atributo para que no se pierda el valor
    private char variableControl = ' '; 

    public Tipo getTurnoActual() {
        // 1. Decidir aleatoriamente solo en la primera jugada
        if (numeroJugada == 0 && variableControl == ' ') {
            if (new java.util.Random().nextBoolean()) {
                variableControl = '1';
            } else {
                variableControl = '2';
            }
        }

        // 2. Lógica para jugadas PARES (0, 2, 4...)
        if (numeroJugada % 2 == 0) {
            if (variableControl == '1') {
                return Tipo.O;
            } else {
                return Tipo.X;
            }
        }

        // 3. Lógica para jugadas IMPARES (1, 3, 5...)
        if (variableControl == '1') {
            return Tipo.X;
        } else {
            return Tipo.O;
        }
    }

	public void incrementaJugada() {
		this.numeroJugada++;
		if (this.numeroJugada > 6) {
			this.setMover(true);
		}
	}

//	public Tipo getTurnoAnterior() {
//		if (getTurnoActual() == Tipo.X) {
//			return Tipo.O;
//		}
//		return Tipo.X;
//	}
//
//	public String getTurnoAnteriorName() {
//		return getTurnoAnterior().getNombre();
//	}
//
//	public boolean isMover() {
//		return this.mover;
//	}

	public void setMover(boolean b) {
		this.mover = b;

	}

	public int getNumeroJugada() {
		return this.numeroJugada;
	}

}
