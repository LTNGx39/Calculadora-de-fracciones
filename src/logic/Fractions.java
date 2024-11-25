package logic;

public class Fractions {

    public static Fraction suma(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator + fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }

    public static Fraction resta(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator - fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }

    public static Fraction multiplicacion(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.numerator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }

    public static Fraction division(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator;
        result.denominator = fractionA.denominator * fractionB.numerator;
        return result;
    }

    public boolean valid(Fraction fraction) {
        if (fraction.denominator == 0) {
            return false;
        }
        return true;
    }

    public Integer checkZero(Fraction fraction) {
        if (fraction.numerator == 0) {
            return 1;
        }
        return 0;
    }
}