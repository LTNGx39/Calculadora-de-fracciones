package logic;

public class Fraction {

    private Integer numerator;
    private Integer denominator;

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
