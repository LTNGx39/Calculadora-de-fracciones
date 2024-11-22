package logic;

public class Fraction {
    public Integer numerator;
    public Integer denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Integer getNumerator() {
        return this.numerator;
    }

    public Integer getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction simplify() { // Simplificar fracción con los datos que tenga actualmente
        Fraction fraction = new Fraction(this.numerator, this.denominator);
        int gcd = this.gcd(fraction.getNumerator(), fraction.getDenominator());
        fraction.setNumerator(fraction.getNumerator() / gcd);
        fraction.setDenominator(fraction.getDenominator() / gcd);
        return fraction;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public String toString(boolean sign, boolean parenthesis) {
        return this.numerator + "/" + this.denominator;
    }
}
