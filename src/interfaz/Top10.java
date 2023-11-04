package interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class Top10 extends JDialog {
	
	public Top10(RegistroTop10[] listaTop10) {
        Color colorGris = new Color(242, 242, 242);

        // Crear una lista de cadenas para mostrar el top 10
        String[] top10Strings = new String[listaTop10.length];
        for (int i = 0; i < listaTop10.length; i++) {
            RegistroTop10 registro = listaTop10[i];
            top10Strings[i] = String.format("%3d) %5s ..... %4d", i + 1, registro.darNombre(), registro.darPuntos());
        }

        // Crear un modelo de lista y agregar los elementos al modelo
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(Arrays.asList(top10Strings));

        // Crear una lista con el modelo
        JList<String> lista10 = new JList<>(listModel);
        lista10.setBackground(colorGris);
        lista10.setFont(new Font("Arial", Font.PLAIN, 15));
        lista10.setForeground(Color.BLACK);
        lista10.setBackground(Color.WHITE);

        // Colocar la lista en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(lista10);
        scrollPane.setBorder(BorderFactory.createTitledBorder("# Nombre"));

        // Colocar el JScrollPane en el centro de la ventana
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Ajustar el tamaño de la ventana y configurar la ubicación
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
