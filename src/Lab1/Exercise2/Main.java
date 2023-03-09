package Lab1.Exercise2;

public class Main {
    public static void main(String[] args) {
        // Initialize A
        int[][] A = {
            {2, 3, 1},
            {7, 1, 6},
            {9, 2, 4}
        };
        System.out.println("\u001B[31m" + "A = ");
        printMatrix(A);
        System.out.println();

        // Initialize B
        int[][] B = {
            {8, 5, 3},
            {3, 9, 2},
            {2, 7, 3}
        };
        System.out.println("\u001B[36m" + "B = ");
        printMatrix(B);
        System.out.println();

        // Compute C = A + B
        var C = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("\u001B[32m" + "C = A + B =");
        printMatrix(C);
        System.out.println();

        // Compute D = A * B
        var D = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                D[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    D[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        System.out.println("\u001B[35m" + "D = A * B =");
        printMatrix(D);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
