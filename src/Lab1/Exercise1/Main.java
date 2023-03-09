package Lab1.Exercise1;

public class Main {
    public static void main(String[] args) {
        var c1 = new ComplexNumber(2, 5);
        var c2 = new ComplexNumber(4, -1);

        System.out.println("\u001B[33m c1 = " + c1);
        System.out.println("\u001B[33m c2 = " + c2);

        System.out.println("\u001B[32m c1 + c2 = " + c1.add(c2));
        System.out.println("\u001B[32m c1 * c2 = " + c1.multiply(c2));
    }
}
