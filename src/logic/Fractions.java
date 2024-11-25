package logic;

public class Fractions {

    public static Fraction add(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator + fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }

    public static Fraction sustract(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator - fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }

    public static Fraction multiply(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.numerator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }

    public static Fraction divide(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator;
        result.denominator = fractionA.denominator * fractionB.numerator;
        return result;
    }
}