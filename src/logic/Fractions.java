package logic;

public class Fractions {
    
    protected int numerator;
    protected int denominator;

    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction suma(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator + fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }
}