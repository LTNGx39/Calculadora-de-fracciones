package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * JPanel donde se muestra el nombre de la aplicacion y el boton de salida
 */

public class TitleBar extends javax.swing.JPanel {

    private Ventana ventana;
    private JLabel title;
    private JButton close;

    public TitleBar(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion de barra de titulo
        setPreferredSize(new Dimension(ventana.getUsableWidth(), 40));
        setMinimumSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        setBorder(BorderFactory.createEmptyBorder(9, 31, 9, 9));
        setLayout(new GridBagLayout());
        setBackground(Colors.BLACK);
        setOpaque(false);
        MouseAdapter drag = new MouseAdapter() {

            int mouseX, mouseY;

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;

                ventana.setLocation(x, y);
            } 
        };
        addMouseListener(drag);
        addMouseMotionListener(drag);

        // Configuracion de titulo
        title = new JLabel("Calculadora de fracciones");
        title.setPreferredSize(new Dimension(ventana.getUsableWidth() - 62, 22));
        title.setFont(new Font("Arial Nova", Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Colors.WHITE);

        // Configuracion del boton close
        close = new JButton() {

            boolean isMouseIn = false;
            {
                // Configuraciones
                setPreferredSize(new Dimension(22, 22));
                setBackground(Colors.RED);
                setFocusPainted(false);
                setBorderPainted(false);
                setContentAreaFilled(false);

                // Listeners
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        isMouseIn = true;
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        isMouseIn = false;
                    }
                });
            }

            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Ellipse2D circle = new Ellipse2D.Double(0, 0, 22, 22);
                
                if (isMouseIn) {
                    g2.setColor(Colors.RED.brighter().brighter());
                } else {
                    g2.setColor(getBackground());
                }
                g2.fill(circle);

            }
        };

        // Adicion de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(title, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(close, gbc);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        Rectangle2D rectangle = new Rectangle2D.Double(0, getHeight() / 2, getWidth(), getHeight());
        
        g2.setColor(getBackground());
        g2.fill(rounded);
        g2.fill(rectangle);

    }

}
