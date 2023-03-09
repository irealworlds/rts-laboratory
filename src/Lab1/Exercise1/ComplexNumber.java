package Lab1.Exercise1;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(this.real + c.real, this.imaginary + c.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber c) {
        return new ComplexNumber(
            this.real * c.real - this.imaginary * c.imaginary,
            this.real * c.imaginary + this.imaginary * c.real
        );
    }

    @Override
    public String toString() {
        if (this.imaginary < 0) {
            return String.format("%02f - %02fi", this.real, -this.imaginary);
        } else {
            return String.format("%02f + %02fi", this.real, this.imaginary);
        }
    }
}
