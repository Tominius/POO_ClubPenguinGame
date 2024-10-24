import javax.swing.*;
import java.util.random.RandomGenerator;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        Player jugador1 = new Player(0,0);
        Meta meta = new Meta(1,1, true);
        Mapas mapa = new Mapas(1);
        mapa.setFilasColumnas(2,2);
        mapa.setMatriz();
        JFrame frame = new JFrame("Matriz con Puntero");
        MatrizConPuntero juego = new MatrizConPuntero(jugador1,mapa,meta);
        frame.add(juego);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        juego.requestFocusInWindow();

    }
}



