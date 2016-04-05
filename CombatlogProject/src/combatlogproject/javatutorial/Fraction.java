package combatlogproject.javatutorial;

/**
 *
 * @author Domenik Irrgang
 */
public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction multiply(Fraction fraction) {
        int resultNumerator = numerator * fraction.numerator;
        int resultDenominator = denominator * fraction.denominator;

        return new Fraction(resultNumerator, resultDenominator);
    }

    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    public Fraction divide(Fraction fraction) {
        return multiply(fraction.invert());
    }

    public Fraction add(Fraction fraction) {
        int resultNumerator = numerator * fraction.denominator + fraction.numerator * denominator;
        int resultDenominator = fraction.denominator * denominator;

        return new Fraction(resultNumerator, resultDenominator);
    }

    public Fraction subtract(Fraction fraction) {
        return add(fraction.multiply(new Fraction(-1, 1)));
    }

    @Override
    public String toString() {
        return "Numerator: " + numerator + " Denominator: " + denominator;
    }

    private int ggt(int zahl1, int zahl2) {
        while (zahl2 != 0) {
            if (zahl1 > zahl2) {
                zahl1 = zahl1 - zahl2;
            } else {
                zahl2 = zahl2 - zahl1;
            }
        }
        return zahl1;
    }
    
    public Fraction reduce() {
        int gcd = ggt(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }
    
    @Override
    public boolean equals(Object object) {
        if (object instanceof Fraction) {
            Fraction fraction = (Fraction) object;
            if (numerator == fraction.numerator && denominator == fraction.denominator) {
                return true;
            }
        }   
        return false;
    }

    public static void main(String... args) {
        Fraction fraction = new Fraction(6, 8);
        Fraction result = fraction.add(new Fraction(1, 4));
        System.out.println(result.reduce());
    }
}
