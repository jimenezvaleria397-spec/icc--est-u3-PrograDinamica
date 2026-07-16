/**
 * Celda
 */
public class Celda {
    private int  fila;
    private int columna ;
    
    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fila;
        result = prime * result + columna;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Celda other = (Celda) obj;
        if (fila != other.fila)
            return false;
        if (columna != other.columna)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Celda [fila=" + fila + ", columna=" + columna + "]";
    }
    
    
    
    

}
