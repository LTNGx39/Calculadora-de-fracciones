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

    public Fraction simplify() throws ArithmeticException{ // Simplificar fracción con los datos que tenga actualmente

        Fraction fraction = new Fraction(0, 0);
        try {
            fraction = new Fraction(this.numerator, this.denominator);
            int gcd = this.gcd(fraction.getNumerator(), fraction.getDenominator());
            fraction.setNumerator(fraction.getNumerator() / gcd);
            fraction.setDenominator(fraction.getDenominator() / gcd);
            return fraction;
        } catch (ArithmeticException e) {
            return fraction;
        }
        

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public String toString(boolean sign, boolean parenthesis) {
        String fraction = this.numerator + " / " + this.denominator;
        if(sign){
            fraction = "-" + fraction;
        }
        if (parenthesis) {
            fraction = "(" + fraction + ")";
        }
        return fraction;
    }

    public boolean valid() {
        if (this.denominator == 0) {
            return true;
        }
        return false;
    }

    public boolean checkZero(Fraction fraction) {
        if (fraction.numerator == 0) {
            return true;
        }
        return false;
    }
}
