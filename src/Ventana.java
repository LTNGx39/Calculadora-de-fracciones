import javax.swing.*;
import java.awt.*;

/**
 * Ventana donde se ve la ejecucion principal del programa
 */

public class Ventana extends javax.swing.JFrame {

    int usableWidth, usableHeight;

    // Constructor para la ventana
    public Ventana() {

        // Tamaño de pantalla
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screen.setSize(screen.width / 3, screen.width / 4);

        // Configuracion de ventana
        setSize(screen);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setContentPane(new RoundPane(this));
        setBackground(new Color(0, 0, 0, 0));

        // Llenado de variables
        usableWidth = getWidth() - 2;
        usableHeight = getHeight() - 2;

    }
}