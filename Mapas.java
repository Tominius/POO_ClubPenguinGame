public class Mapas {

    Casillas[][] matriz;
    int filas;
    int columnas;
    int nivel;

     public Mapas(int nivel) {
         this.nivel = nivel;
     }

    public void setMatriz() {
        this.matriz = new Casillas[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.matriz[i][j] = new Casillas();
                this.matriz[i][j].setEstado(false);
            }
        }
    }

    public void setFilasColumnas(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public void setEstadoXY(int fila, int columna) {
        matriz[fila][columna].setEstado(true);
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Casillas[][] getMatriz() {
        return matriz;
    }

    public int getNivel() {
        return nivel;
    }

    public void imprimirMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (this.matriz[i][j].getEstado()) {
                    System.out.print("1 "); // Casilla visitada (o cualquier otro valor que represente)
                } else {
                    System.out.print("0 "); // Casilla no visitada
                }
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

    public boolean win() {
        boolean flag = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!this.matriz[i][j].getEstado()){
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }
}