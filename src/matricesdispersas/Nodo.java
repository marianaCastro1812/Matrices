
package matricesdispersas;

/**
 *
 * @author Mariana Castro  y Miguel Angel Mejia Gallo
 */
public class Nodo {
    private int fila, columna, dato;
    private Nodo Liga;
    private Nodo LigaFila;
    private Nodo LigaColumna;


    public Nodo(int fila, int columna, int dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
        this.Liga = null;
        this.LigaFila = null;
        this.LigaColumna = null;
        
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public Nodo getLigaFila() {
        return LigaFila;
    }

    public void setLigaFila(Nodo LigaFila) {
        this.LigaFila = LigaFila;
    }

    public Nodo getLigaColumna() {
        return LigaColumna;
    }

    public void setLigaColumna(Nodo LigaColumna) {
        this.LigaColumna = LigaColumna;
    }

   
    
}

