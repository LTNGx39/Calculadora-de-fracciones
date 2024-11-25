package logic;

import java.io.*;
import java.nio.file.*;

public class FraccionReader {

    public static Fraction fraccion1;
    public static Fraction fraccion2;
    public static String operador;
    public static Fraction resultado;

    // Método estático para leer y procesar el archivo
    public static void procesarArchivo(String rutaArchivo) throws IOException {

        // Lee el archivo
        String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

        // Divide en líneas si hay múltiples operaciones
        String[] lineas = contenido.split("\\n");

        // Procesa cada línea
        for (String linea : lineas) {

            String[] partes = linea.split(" ");
            fraccion1 = parsearFraccion(partes[0]);
            fraccion2 = parsearFraccion(partes[2]);
            operador = partes[1];

            // Operar las fracciones según el operador
            switch (operador) {
                case "+":
                    resultado = Fractions.suma(fraccion1, fraccion2);
                    break;
                case "-":
                    resultado = Fractions.resta(fraccion1, fraccion2);
                    break;
                case "*":
                    resultado = Fractions.multiplicacion(fraccion1, fraccion2);
                    break;
                case "/":
                    resultado = Fractions.division(fraccion1, fraccion2);
                    break;
                default:
                    throw new IllegalArgumentException("Operador no soportado: " + operador);
            }
            resultado.simplify();
        }
        guardarResultado();

    }

    // Convierte una cadena en Fraction
    private static Fraction parsearFraccion(String texto) {
        String[] partes = texto.split("/");
        int numerador = Integer.parseInt(partes[0]);
        int denominador = Integer.parseInt(partes[1]);
        return new Fraction(numerador, denominador);
    }

    // Guarda el resultado en un archivo
    private static void guardarResultado() throws IOException {

        String carpetaOutput = "src/output";

        // Crear la carpeta si no existe
        Files.createDirectories(Paths.get(carpetaOutput));

        // Crear y/o sobre-escribe el archivo
        String rutaResultado = carpetaOutput + "/resultado.txt";
        String textoResultado = resultado.getNumerator() + "/" + resultado.getDenominator();
        Files.write(Paths.get(rutaResultado), textoResultado.getBytes());
    }
}
