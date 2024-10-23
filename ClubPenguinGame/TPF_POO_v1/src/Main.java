import javax.swing.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //Creo los valores necesarios para el mapa.

        Mapas mapa = new Mapas();
        Player player = new Player(0,0);
        Meta meta = new Meta(2,1);

        //Configuro la matriz

        mapa.setFilasColumnas(3,2);
        mapa.setMatriz();

        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        boolean flag = false;

        mapa.setEstadoXY(meta.getX(), meta.getY());
        mapa.setEstadoXY(player.getX(), player.getY());

        mapa.imprimirMatriz();

        while (!(meta.getX() == player.getX() && meta.getY() == player.getY())) {
            System.out.println("Ingrese las coordenadas X e Y para mover al jugador (o -1 para salir): ");
            x = sc.nextInt();
            y = sc.nextInt();
            player.setX(x);
            player.setY(y);
            mapa.setEstadoXY(player.getX(), player.getY());
            mapa.imprimirMatriz();
        }
    }
}
