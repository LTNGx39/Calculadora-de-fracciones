package ui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

/**
 * JPanel donde se muestra el nombre de la aplicacion y el boton de salida
 */

public class TitleBar extends javax.swing.JPanel {

    Ventana ventana;
    
    public TitleBar(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion de barra de titulo
        setPreferredSize(new Dimension(ventana.getUsableWidth(), 40));
        setMaximumSize(getPreferredSize());
        setBackground(Colors.BLACK);

    }

}
