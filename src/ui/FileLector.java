package ui;

import javax.swing.*;

import logic.FraccionReader;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import java.io.IOException;

public class FileLector extends javax.swing.JFrame {
    
    private Ventana ventana;
    private JLabel text;
    private JTextField location;

    private String rute = "";

    public FileLector(Ventana ventana) {

        super();
        this.ventana = ventana;
        // Tamaño de pantalla
        Dimension size = new Dimension(ventana.getWidth() / 3 * 2, ventana.getWidth() / 7);

        // Configuracion de ventana
        setSize(size);
        setLocationRelativeTo(ventana);
        setUndecorated(true);
        setType(Type.UTILITY);
        setContentPane(new FilePane(this));
        setBackground(new Color(0, 0, 0, 0));

        // Configuracion de componentes
        text = new JLabel("Ingrese la ruta del archivo:") {
            {
                setFont(new Font("Arial Nova", Font.BOLD, ventana.getWidth() / 32));
                setForeground(Colors.WHITE);
            }
        };

        location = new JTextField() {
            {
                setFont(new Font("Arial Nova", Font.BOLD, ventana.getWidth() / 32));
                setEditable(true);
                setSelectedTextColor(Colors.WHITE);
                setSelectionColor(Colors.GRAY);
                setBackground(Colors.DARK_GRAY);
                setForeground(Colors.WHITE);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                setCaretColor(getForeground());

                addKeyListener(new KeyAdapter() {
                    
                    @Override
                    public void keyTyped(KeyEvent e) {

                        if (e.getKeyChar() == '\n') {
                            rute = getText();
                            dispose();

                            try {

                                FraccionReader.procesarArchivo(rute);

                                ventana.getFractionPanel().getN1().setText("" + FraccionReader.fraccion1.getNumerator());
                                ventana.getFractionPanel().getN1().setValue(FraccionReader.fraccion1.getNumerator());
                                ventana.getFractionPanel().getD1().setText("" + FraccionReader.fraccion1.getDenominator());
                                ventana.getFractionPanel().getD1().setValue(FraccionReader.fraccion1.getDenominator());
                                ventana.getFractionPanel().setFraction1(FraccionReader.fraccion1);

                                ventana.getFractionPanel().getN2().setText("" + FraccionReader.fraccion2.getNumerator());
                                ventana.getFractionPanel().getN2().setValue(FraccionReader.fraccion2.getNumerator());
                                ventana.getFractionPanel().getD2().setText("" + FraccionReader.fraccion2.getDenominator());
                                ventana.getFractionPanel().getD2().setValue(FraccionReader.fraccion2.getDenominator());
                                ventana.getFractionPanel().setFraction2(FraccionReader.fraccion2);

                                char symbol = ' ';
                                if (FraccionReader.operador.charAt(0) == '+') {
                                    symbol = '+';
                                } else if (FraccionReader.operador.charAt(0) == '-') {
                                    symbol = '−';
                                } else if (FraccionReader.operador.charAt(0) == 'x') {
                                    symbol = '×';
                                } else {
                                    symbol = '÷';
                                }
                                ventana.getFractionPanel().getSymbol().setText("" + symbol);
                                ventana.repaint();

                                ventana.getFractionPanel().getN3().setText("" + FraccionReader.resultado.getNumerator());
                                ventana.getFractionPanel().getD3().setText("" + FraccionReader.resultado.getDenominator());

                            } catch (IOException e1) {
                                System.err.println("Archivo no encontrado");
                            }
                        }

                    }
                });
            }
        };

        // Adicion de los componentes
        add(text);
        add(location);

    }

}

class FilePane extends javax.swing.JPanel {

    private FileLector fileLector;

    public FilePane(FileLector fileLector) {

        super();
        this.fileLector = fileLector;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D border = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 22, 22);
        g2.setColor(Colors.GRAY);
        g2.fill(border);

        RoundRectangle2D rectangle = new RoundRectangle2D.Double(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);
        g2.setColor(Colors.BLACK);
        g2.fill(rectangle);

    }

}
