import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MatrizConPuntero extends JPanel {
    private int cellSize = 50;
    Player jugador;
    Meta meta;
    Mapas mapa;

    public MatrizConPuntero(Player jugador, Mapas mapa,Meta meta) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.meta = meta;

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int newX = jugador.getX();
                int newY = jugador.getY();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (jugador.getY() > 0) newY--;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (jugador.getY() < mapa.filas - 1) newY++;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (jugador.getX() > 0) newX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (jugador.getX() < mapa.columnas - 1) newX++;
                        break;
                }

                // Si la nueva posición no ha sido visitada
                if (!mapa.matriz[newY][newX].getEstado()) {
                    // Marcar como visitada
                    mapa.matriz[newY][newX].setEstado(true);
                    jugador.SetX(newX);
                    jugador.SetY(newY);
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la matriz
        for (int i = 0; i < this.mapa.filas; i++) {
            for (int j = 0; j < this.mapa.columnas; j++) {
                if (this.mapa.matriz[i][j].getEstado()) {
                    g.setColor(Color.BLACK); // Casillas visitadas
                } else {
                    g.setColor(Color.WHITE); // Casillas no visitadas
            }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY); // Color del borde
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

        // Dibuja el puntero
        g.setColor(Color.RED);
        g.fillRect(jugador.getX() * cellSize, jugador.getY() * cellSize, cellSize, cellSize);
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Matriz con Puntero");
//        MatrizConPuntero matriz = new MatrizConPuntero();
//        frame.add(matriz);
//        frame.setSize(600, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        matriz.requestFocusInWindow();
//    }
}

