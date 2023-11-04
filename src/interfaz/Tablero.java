package interfaz;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tablero extends JPanel implements MouseMotionListener, MouseListener {
	
	private int tamanioTablero = 5;
    private VentanaLuces padre;

    public Tablero(VentanaLuces papa, int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
        this.padre = papa;
        setBackground(new Color(242, 242, 242));
        addMouseListener(new MyMouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cuadroSize = Math.min(getWidth(), getHeight()) / tamanioTablero;

        for (int i = 0; i < tamanioTablero; i++) {
            for (int j = 0; j < tamanioTablero; j++) {
                boolean encendida = padre.estaEncendida(i, j);
                Color color = encendida ? Color.YELLOW : Color.GRAY;
                g.setColor(color);
                g.fillRect(i * cuadroSize, j * cuadroSize, cuadroSize, cuadroSize);
            }
        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX() * tamanioTablero / getWidth();
            int y = e.getY() * tamanioTablero / getHeight();
            padre.iniciarJuego(new int[]{x, y});
            repaint();
        }
    }
}

