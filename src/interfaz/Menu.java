package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Menu extends JPanel implements ActionListener {
	
	 private VentanaLuces padre;
	    private Color colorPanel;
	    private Color colorGris;

	    public Menu(VentanaLuces papa) {
	        colorPanel = new Color(72, 132, 220);
	        setBackground(colorPanel);
	        colorGris = new Color(242, 242, 242);

	        this.padre = papa;

	        setLayout(new GridLayout(4, 1, 30, 30));

	        String[] menuNombres = {"NUEVO", "REINICIAR", "TOP-10", "CAMBIAR JUGADOR"};

	        for (String nombre : menuNombres) {
	            JButton boton = createMenuButton(nombre);
	            add(boton);
	        }
	    }

	    private JButton createMenuButton(String nombre) {
	        JButton boton = new JButton(nombre);
	        boton.setForeground(Color.white);
	        boton.setFont(new Font("Arial", Font.BOLD, 15));
	        boton.setBackground(colorPanel);
	        boton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                handleButtonClick(nombre);
	            }
	        });
	        return boton;
	    }

	    private void handleButtonClick(String nombre) {
	        if ("NUEVO".equals(nombre)) {
	            padre.juegoNuevo();
	        } else if ("REINICIAR".equals(nombre)) {
	            padre.reiniciar();
	        } else if ("TOP-10".equals(nombre)) {
	            padre.top10();
	        } else if ("CAMBIAR JUGADOR".equals(nombre)) {
	            padre.cambiarDeJugador();
	        }
	    }
	}
