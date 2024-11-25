package ui;

import javax.swing.*;

import logic.Fraction;
import logic.Fractions;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.geom.RoundRectangle2D;

public class FractionPanel extends javax.swing.JPanel {

    private Ventana ventana;
    private CustomText n1, d1, n2, d2, n3, d3;
    private JLabel symbol, equal;

    // Values
    private Fraction fraction1 = new Fraction(1, 2);
    private Fraction fraction2 = new Fraction(2, 4);
    private Fraction fraction3 = new Fraction(1, 1);

    public FractionPanel(Ventana ventana) {

        // Llenado de variables
        this.ventana = ventana;

        // Configuracion del panel
        int borderSize = ventana.getWidth() / 16;
        setBorder(BorderFactory.createEmptyBorder(borderSize * 2, borderSize * 5 / 2, borderSize * 2, borderSize * 5 / 2));
        setLayout(new GridBagLayout());
        setBackground(ventana.getBackground());

        // Configuracion de componentes
        n1 = new CustomText(ventana, "1", true, 'N', 1);
        n2 = new CustomText(ventana, "2", true, 'N',  2);
        n3 = new CustomText(ventana, "1", false, 'N',  3);
        d1 = new CustomText(ventana, "2", true, 'D',  1);
        d2 = new CustomText(ventana, "4", true, 'D',  2);
        d3 = new CustomText(ventana, "1", false, 'D',  3);

        n1.setPair(d1);
        n2.setPair(d2);
        n3.setPair(d3);
        d1.setPair(n1);
        d2.setPair(n2);
        d3.setPair(n3);

        symbol = new JLabel("+");
        symbol.setFont(new Font("Arial Nova", Font.BOLD, ventana.getWidth() / 14));
        symbol.setHorizontalAlignment(SwingConstants.CENTER);
        symbol.setForeground(Colors.WHITE);
        symbol.setPreferredSize(getSize());

        equal = new JLabel("=");
        equal.setFont(new Font("Arial Nova", Font.BOLD, ventana.getWidth() / 14));
        equal.setHorizontalAlignment(SwingConstants.CENTER);
        equal.setForeground(Colors.WHITE);

        // Adicion de componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        Insets bottom = new Insets(0, 0, 15, 0);
        Insets top = new Insets(15, 0, 0, 0);
        Insets none = new Insets(0, 0, 0, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        // gbc.insets = bottom;
        add(n1, gbc);
        
        gbc.gridx = 1;
        gbc.gridheight = 3;
        // gbc.insets = none;
        add(symbol, gbc);

        gbc.gridx = 2;
        gbc.gridheight = 1;
        // gbc.insets = bottom;
        add(n2, gbc);

        gbc.gridx = 3;
        gbc.gridheight = 3;
        // gbc.insets = none;
        add(equal, gbc);

        gbc.gridx = 4;
        gbc.gridheight = 1;
        // gbc.insets = bottom;
        add(n3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        // gbc.insets = none;
        add(new Bar(ventana), gbc);

        gbc.gridx = 2;
        add(new Bar(ventana), gbc);

        gbc.gridx = 4;
        add(new Bar(ventana), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        // gbc.insets = top;
        add(d1, gbc);

        gbc.gridx = 2;
        add(d2, gbc);

        gbc.gridx = 4;
        add(d3, gbc);

    }

    public void setFraction1(Fraction value) {
        fraction1 = value;
    }

    public void setFraction2(Fraction value) {
        fraction2 = value;
    }

    public Fraction getFraction1() {
        return fraction1;
    }

    public Fraction getFraction2() {
        return fraction2;
    }

    public Fraction getFraction3() {
        return fraction3;
    }

    public void setFraction3(Fraction fraction) {

        fraction3 = fraction;
        n3.setText("" + fraction.getNumerator());
        n3.setValue(fraction.getNumerator());
        d3.setText("" + fraction.getDenominator());
        d3.setValue(fraction.getDenominator());

    }

    public JLabel getSymbol() {
        return symbol;
    }

}

// Clase CustomText

class CustomText extends javax.swing.JTextField {

    private Ventana ventana;

    private int value;
    private char type;
    private CustomText pair;
    private int number = 0;

    public CustomText(Ventana ventana, String text, Boolean editable, char type, int number) {

        super(text);
        this.ventana = ventana;
        this.type = type;
        this.number = number;
        value = Integer.parseInt(text);

        // Configuraciones
        setFont(new Font("Arial Nova", Font.BOLD, ventana.getWidth() / 20));

        if (editable) {
            setBackground(Colors.GRAY);
            setCaretColor(Colors.WHITE);
        } else {
            setBackground(Colors.BLACK);
            setCaretColor(getBackground());
        }

        setEditable(editable);
        setSelectedTextColor(Colors.WHITE);
        setSelectionColor(Colors.DARK_GRAY);
        setForeground(Colors.WHITE);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);

        addKeyListener(new KeyAdapter() { 
            
            @Override
            public void keyTyped(KeyEvent e) {

                char key = e.getKeyChar();

                if (key == '\n' && !getText().equals("")) {

                    // Asigna la fraccion
                    value = Integer.parseInt(getText());
                    setFraction(pair, number);

                    // Busca la operacion
                    char simbolo = ventana.getFractionPanel().getSymbol().getText().charAt(0);
                    
                    Fraction opera = new Fraction(0, 0);
                    if (simbolo == '+') {

                        System.out.println("mas");
                        opera = Fractions.suma(ventana.getFractionPanel().getFraction1(), ventana.getFractionPanel().getFraction2());

                    } else if (simbolo == '−') {

                        System.out.println("menos");
                        opera = Fractions.restas(ventana.getFractionPanel().getFraction1(), ventana.getFractionPanel().getFraction2());

                    } else if (simbolo == '×') {

                        System.out.println("equis");
                        opera = Fractions.division(ventana.getFractionPanel().getFraction1(), ventana.getFractionPanel().getFraction2());

                    } else {

                        System.out.println("div");
                        opera = Fractions.multiplicacion(ventana.getFractionPanel().getFraction1(), ventana.getFractionPanel().getFraction2());

                    }

                    // Opera las fracciones y asigna a la 3ra
                    ventana.getFractionPanel().setFraction3(opera);

                } else if (!Character.isDigit(key)) {
                    e.consume();
                    System.err.println("Se ingreso un caracter no numerico");
                } else if (getText().length() >= 4) {
                    e.consume();
                    System.err.println("Se ingreso un numero muy grande");
                }

            }
        });
        
    }

    public void setPair(CustomText pair) {
        this.pair = pair;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setFraction(CustomText pair, int id) {

        Fraction fraction;

        if (type == 'N') {
            fraction = new Fraction(value, pair.getValue());
        } else {
            fraction = new Fraction(pair.getValue(), value);
        }

        if (id == 1) {
            ventana.getFractionPanel().setFraction1(fraction);
        } else {
            ventana.getFractionPanel().setFraction2(fraction);
        }
        // System.out.println(fraction.getNumerator() + " : " + fraction.getDenominator());
        System.out.println(ventana.getFractionPanel().getFraction1().getNumerator() + " : " + ventana.getFractionPanel().getFraction1().getDenominator());
        System.out.println(ventana.getFractionPanel().getFraction2().getNumerator() + " : " + ventana.getFractionPanel().getFraction2().getDenominator());

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        g2.setColor(getBackground());
        g2.fill(rounded);

        super.paintComponent(g);

    }

}

// Clase bar

class Bar extends javax.swing.JPanel {

    Ventana ventana;

    public Bar(Ventana ventana) {

        super();
        this.ventana = ventana;
        setOpaque(false);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height = ventana.getWidth() / 64;
        RoundRectangle2D bar = new RoundRectangle2D.Double(0, getHeight() / 2 - height / 2, getWidth(), height, height, height);
        g2.setColor(Colors.WHITE);
        g2.fill(bar);

    }

}
