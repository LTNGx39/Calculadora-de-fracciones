package logic;

public class Fraction {
<<<<<<< HEAD:src/logic/Fraction.java

    private Integer numerator;
    private Integer denominator;
=======
    public Integer numerator;
    public Integer denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
>>>>>>> 369a47b (ready add method):src/Fraction.java

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

    public Fraction simplify(Fraction fraction) {
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
