package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.Window.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class ButtonPanel extends javax.swing.JPanel {

    private Ventana ventana;
    private CustomButton plus, minus, mult, div, file;
    
    public ButtonPanel(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion de panel
        setPreferredSize(new Dimension(ventana.getUsableWidth(), (ventana.getUsableWidth() - 240) / 5 + 40));
        setMinimumSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        setBorder(BorderFactory.createEmptyBorder(0, 40, 40, 40));
        setLayout(new GridLayout(1, 5, 40, 40));
        setBackground(ventana.getBackground());

        // Configuracion de componentes
        plus = new CustomButton(ventana, "+") {
            {
                addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        

                    }

                });
            }
        };
        minus = new CustomButton(ventana, "−");
        mult = new CustomButton(ventana, "×");
        div = new CustomButton(ventana, "÷");
        file = new CustomButton(ventana, "F");

        // Adicion de componentes
        add(plus);
        add(minus);
        add(mult);
        add(div);
        add(file);

    }
}

// Clase CustomButton

class CustomButton extends javax.swing.JButton {

    private boolean isMouseIn = false;
    private Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    private Color defaultColor = Colors.BLACK;

    public CustomButton(Ventana ventana, String title) {

        super(title);

        setBackground(defaultColor);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFont(new Font("Arial Nova", Font.BOLD, 48));
        setForeground(Colors.WHITE);
        
        // Configuraciones
        setPreferredSize(new Dimension(22, 22));
        setBackground(Colors.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);

        // Listeners
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseIn = true;
                ventana.setCursor(handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseIn = false;
                ventana.setCursor(normalCursor);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);

        if (isMouseIn) {
            g2.setColor(Colors.GRAY);
        } else {
            g2.setColor(getBackground());
        }
        g2.fill(rounded);

        super.paintComponent(g);

    }
}
