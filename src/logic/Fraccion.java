package logic;
// Clase principal para representar una Fracción
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Excepción personalizada para manejar errores de fracción
class FraccionException extends Exception {
    public FraccionException(String mensaje) {
        super(mensaje);
    }
}

class Fraccion {
    private int numerador;
    private int denominador;

    // Constructores
    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(int numerador, int denominador) throws FraccionException {
        if (denominador == 0) {
            throw new FraccionException("El denominador no puede ser cero");
        }
        
        // Normalizar el signo
        if (denominador < 0) {
            numerador = -numerador;
            denominador = Math.abs(denominador);
        }
        
        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    // Método recursivo para calcular el Máximo Común Divisor (MCD)
    private int calcularMCD(int a, int b) {
        return b == 0 ? a : calcularMCD(b, a % b);
    }

    // Método recursivo para calcular el Mínimo Común Múltiplo (MCM)
    private int calcularMCM(int a, int b) {
        return Math.abs(a * b) / calcularMCD(a, b);
    }

    // Operaciones básicas
    public Fraccion sumar(Fraccion otra) throws FraccionException {
        int mcm = calcularMCM(this.denominador, otra.denominador);
        int nuevoNumerador = (this.numerador * (mcm / this.denominador)) + 
                             (otra.numerador * (mcm / otra.denominador));
        return new Fraccion(nuevoNumerador, mcm);
    }

    public Fraccion restar(Fraccion otra) throws FraccionException {
        int mcm = calcularMCM(this.denominador, otra.denominador);
        int nuevoNumerador = (this.numerador * (mcm / this.denominador)) - 
                             (otra.numerador * (mcm / otra.denominador));
        return new Fraccion(nuevoNumerador, mcm);
    }

    public Fraccion multiplicar(Fraccion otra) throws FraccionException {
        return new Fraccion(this.numerador * otra.numerador, 
                            this.denominador * otra.denominador);
    }

    public Fraccion dividir(Fraccion otra) throws FraccionException {
        if (otra.numerador == 0) {
            throw new FraccionException("No se puede dividir por cero");
        }
        return new Fraccion(this.numerador * otra.denominador, 
                            this.denominador * otra.numerador);
    }

    // Getters
    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}

// Interfaz de usuario gráfica
class CalculadoraFraccionesGUI extends JFrame {
    private JTextField numerador1Field, denominador1Field;
    private JTextField numerador2Field, denominador2Field;
    private JTextField resultadoField;
    private JButton sumarBtn, restarBtn, multiplicarBtn, dividirBtn;
    private JButton guardarBtn, cargarBtn;

    public CalculadoraFraccionesGUI() {
        setTitle("Calculadora de Fracciones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Campos de entrada para la primera fracción
        add(new JLabel("Numerador 1:"));
        numerador1Field = new JTextField();
        add(numerador1Field);

        add(new JLabel("Denominador 1:"));
        denominador1Field = new JTextField();
        add(denominador1Field);

        // Campos de entrada para la segunda fracción
        add(new JLabel("Numerador 2:"));
        numerador2Field = new JTextField();
        add(numerador2Field);

        add(new JLabel("Denominador 2:"));
        denominador2Field = new JTextField();
        add(denominador2Field);

        // Botones de operaciones
        sumarBtn = new JButton("Sumar");
        add(sumarBtn);
        restarBtn = new JButton("Restar");
        add(restarBtn);
        multiplicarBtn = new JButton("Multiplicar");
        add(multiplicarBtn);
        dividirBtn = new JButton("Dividir");
        add(dividirBtn);

        // Botones de archivo
        guardarBtn = new JButton("Guardar");
        add(guardarBtn);
        cargarBtn = new JButton("Cargar");
        add(cargarBtn);

        // Campo de resultado
        add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        resultadoField.setEditable(false);
        add(resultadoField);

        // Agregar listeners
        agregarListeners();
    }

    private void agregarListeners() {
        sumarBtn.addActionListener(e -> realizarOperacion("sumar"));
        restarBtn.addActionListener(e -> realizarOperacion("restar"));
        multiplicarBtn.addActionListener(e -> realizarOperacion("multiplicar"));
        dividirBtn.addActionListener(e -> realizarOperacion("dividir"));
        
        guardarBtn.addActionListener(e -> guardarResultado());
        cargarBtn.addActionListener(e -> cargarFracciones());
    }

    private void realizarOperacion(String operacion) {
        try {
            // Parsear fracciones
            Fraccion f1 = new Fraccion(
                Integer.parseInt(numerador1Field.getText()), 
                Integer.parseInt(denominador1Field.getText())
            );
            Fraccion f2 = new Fraccion(
                Integer.parseInt(numerador2Field.getText()), 
                Integer.parseInt(denominador2Field.getText())
            );

            // Realizar operación
            Fraccion resultado = switch(operacion) {
                case "sumar" -> f1.sumar(f2);
                case "restar" -> f1.restar(f2);
                case "multiplicar" -> f1.multiplicar(f2);
                case "dividir" -> f1.dividir(f2);
                default -> throw new FraccionException("Operación no válida");
            };

            // Mostrar resultado
            resultadoField.setText(resultado.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, ingrese números válidos", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE);
        } catch (FraccionException ex) {
            JOptionPane.showMessageDialog(this, 
                ex.getMessage(), 
                "Error de Fracción", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarResultado() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultado.txt"))) {
            writer.println(resultadoField.getText());
            JOptionPane.showMessageDialog(this, "Resultado guardado exitosamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al guardar el archivo", 
                "Error de Archivo", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarFracciones() {
        try (BufferedReader reader = new BufferedReader(new FileReader("fracciones.txt"))) {
            String[] fracciones = reader.readLine().split(",");
            if (fracciones.length == 4) {
                numerador1Field.setText(fracciones[0]);
                denominador1Field.setText(fracciones[1]);
                numerador2Field.setText(fracciones[2]);
                denominador2Field.setText(fracciones[3]);
            }
            JOptionPane.showMessageDialog(this, "Fracciones cargadas exitosamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al cargar el archivo", 
                "Error de Archivo", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraFraccionesGUI().setVisible(true);
        });
    }
}