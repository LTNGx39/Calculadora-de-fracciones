package logic;

public class Fractions {
    
    protected int numerator;
    protected int denominator;

    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

<<<<<<< HEAD:src/logic/Fractions.java
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
=======
    public Fraction add(Fraction fractionA, Fraction fractionB) {
        Fraction result = new Fraction(0, 0);
        result.numerator = fractionA.numerator * fractionB.denominator + fractionB.numerator * fractionA.denominator;
        result.denominator = fractionA.denominator * fractionB.denominator;
        return result;
    }
>>>>>>> 369a47b (ready add method):src/Fractions.java
}