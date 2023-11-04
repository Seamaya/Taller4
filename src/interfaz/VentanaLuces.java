package interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaLuces extends JFrame {
	private JPanel todoPanel;
    private Tablero tableroLogica;
    private JPanel contenedorPanel;
    private Top10 top10;
    private String nombreJugador;
    private Tablero panelTablero;
    private Juego panelDuranteJuego;
    private Menu panelMenu;
    private Previo panelPreparacion;

    private static final File data = new File("data/top10.csv");

    public VentanaLuces() {
        setTitle("LightsOut");
        this.top10 = new Top10();
        top10.cargarRecords(data);

        todoPanel = new JPanel();
        todoPanel.setBackground(Color.WHITE);
        todoPanel.setLayout(new BorderLayout());
        todoPanel.setBorder(new EmptyBorder(12, 12, 12, 12));

        setContentPane(todoPanel);

        panelPreparacion = new Previo();
        todoPanel.add(panelPreparacion, BorderLayout.NORTH);

        contenedorPanel = new JPanel();
        contenedorPanel.setBackground(Color.WHITE);
        todoPanel.add(contenedorPanel, BorderLayout.EAST);
        contenedorPanel.setLayout(new BorderLayout());

        panelMenu = new Menu(this);
        contenedorPanel.add(panelMenu, BorderLayout.CENTER);

        if (nombreJugador == null || nombreJugador.isBlank()) {
            this.nombreJugador = "Tay";
        } else {
            this.nombreJugador = nombreJugador;
        }

        panelDuranteJuego = new Juego(nombreJugador);
        todoPanel.add(panelDuranteJuego, BorderLayout.SOUTH);

        panelTablero = new Tablero(this, 1);
        todoPanel.add(panelTablero, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                try {
                    top10.salvarRecords(data);
                } catch (Exception e) {
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private String getNombreUsuario() {
        nombreJugador = JOptionPane.showInputDialog(null, "Por favor escriba su nombre", "LightsOut", JOptionPane.PLAIN_MESSAGE);
        if (nombreJugador == null || nombreJugador.isBlank()) {
            this.nombreJugador = "Tay";
        } else {
            this.nombreJugador = nombreJugador;
        }
        return nombreJugador;
    }

    public boolean estaEncendida(int i, int j) {
        if (panelTablero.getCantidadCuadrados() == 1)
            return true;
        return tableroLogica.darTablero()[i][j];
    }

    public void juegoNuevo() {
        int cell = panelPreparacion.getTamanioTablero();
        int diff = panelPreparacion.getDificultad();
        tableroLogica = new Tablero(cell);
        panelTablero.setCantidadCuadrados(cell);
        tableroLogica.desordenar(diff);
        panelTablero.repaint();
    }

    public void reiniciar() {
        tableroLogica.reiniciar();
        panelTablero.repaint();
    }

    public void top10() {
        new MostrarTop10(top10.darRegistros().stream().toArray(RegistroTop10[]::new));
    }

    public void cambiarDeJugador() {
        panelDuranteJuego.setJugadas(0);
        panelDuranteJuego.setJugador(getNombreUsuario());
        juegoNuevo();
    }

    public void iniciarJuego(int[] celdas) {
        if (tableroLogica != null) {
            tableroLogica.jugar(celdas[0], celdas[1]);
            panelDuranteJuego.setJugadas(tableroLogica.darJugadas());
            if (tableroLogica.tableroIluminado()) {
                int score = tableroLogica.calcularPuntaje();
                String label = "Coronaste! yey - Tu puntaje: " + score;
                if (top10.esTop10(score)) {
                    label += "\n Llegaste al top 10, crack!";
                    top10.agregarRegistro(nombreJugador, score);
                }
                JOptionPane.showMessageDialog(null, label);
            }
        }
    }

    public static void main(String[] arg) {
        VentanaLuces ventanaLights = new VentanaLuces();
    }

}
