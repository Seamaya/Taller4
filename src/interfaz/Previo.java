package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Previo {
	
	private JComboBox<String> tamanoComboBox;
    private JRadioButton facilRadioButton;
    private JRadioButton medioRadioButton;
    private JRadioButton dificilRadioButton;

    public Previo() {
        setBackground(new Color(72, 132, 220));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Configuración"));

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel tamanoLabel = createLabel("Tamaño del tablero:");
        tamanoComboBox = createComboBox(new String[]{"5x5", "6x6", "7x7", "8x8", "9x9"}, 0);
        panelIzquierdo.add(tamanoLabel);
        panelIzquierdo.add(tamanoComboBox);

        JLabel dificultadLabel = createLabel("Dificultad:");
        facilRadioButton = createRadioButton("Fácil", true);
        medioRadioButton = createRadioButton("Medio", false);
        dificilRadioButton = createRadioButton("Difícil", false);
        panelIzquierdo.add(dificultadLabel);
        panelIzquierdo.add(facilRadioButton);
        panelIzquierdo.add(medioRadioButton);
        panelIzquierdo.add(dificilRadioButton);

        add(panelIzquierdo, BorderLayout.WEST);
    }

    private JLabel createLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        return label;
    }

    private JComboBox<String> createComboBox(String[] opciones, int selectedIndex) {
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setSelectedIndex(selectedIndex);
        return comboBox;
    }

    private JRadioButton createRadioButton(String texto, boolean selected) {
        JRadioButton radioButton = new JRadioButton(texto, selected);
        radioButton.setForeground(Color.WHITE);
        radioButton.setFont(new Font("Arial", Font.BOLD, 15));
        return radioButton;
    }

    public int getTamanioTablero() {
        int selectedIndex = tamanoComboBox.getSelectedIndex();
        return selectedIndex + 5;
    }

    public int getDificultad() {
        if (facilRadioButton.isSelected()) {
            return 30;
        } else if (medioRadioButton.isSelected()) {
            return 15;
        } else {
            return 8;
        }
    }

}
