package logic;

public class Fractions {

    public static Fraction suma(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator + fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result.simplify();
    }

    public static Fraction resta(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator - fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result.simplify();
    }

    public static Fraction multiplicacion(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.numerator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result.simplify();
    }

    public static Fraction division(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator;
        result.denominator = fractionA.denominator * fractionB.numerator;
        return result.simplify();
    }
}