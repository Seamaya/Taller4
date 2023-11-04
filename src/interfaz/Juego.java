package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Juego extends JPanel {
	 private String nombreJugador;
	    private int movimientos;
	    private Map<String, JLabel> valueLabels;

	    public Juego(String nombreJugador) {
	        this.nombreJugador = nombreJugador;
	        this.movimientos = 0;

	        setLayout(new GridLayout(1, 2, 5, 5));
	        setBackground(new Color(242, 242, 242));

	        String[] etiquetas = {"Jugadas: ", "Jugador: "};
	        valueLabels = new HashMap<>();

	        for (String etiqueta : etiquetas) {
	            JLabel label = createLabel(etiqueta);
	            add(label);
	            valueLabels.put(etiqueta, createValueLabel(""));
	            add(valueLabels.get(etiqueta));
	        }
	        
	        setJugador(nombreJugador);
	    }

	    private JLabel createLabel(String texto) {
	        JLabel label = new JLabel(texto);
	        label.setForeground(Color.BLACK);
	        label.setFont(new Font("Arial", Font.PLAIN, 15));
	        return label;
	    }

	    private JLabel createValueLabel(String texto) {
	        JLabel label = new JLabel(texto);
	        label.setForeground(Color.BLACK);
	        label.setFont(new Font("Arial", Font.PLAIN, 15));
	        return label;
	    }

	    public void setJugadas(int i) {
	        movimientos = i;
	        valueLabels.get("Jugadas: ").setText(Integer.toString(i));
	    }

	    public void setJugador(String nombreJug) {
	        valueLabels.get("Jugador: ").setText(nombreJug);
	    }

	    public int getJugadas() {
	        return movimientos;
	    }
}
