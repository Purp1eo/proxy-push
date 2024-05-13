package ueb_4;

import java.util.Arrays;

public class aufg_41 {

    public static double mainDiag(int[][] matrix) {
        double sum = 0;        

        for (int i = 0; i < matrix.length; i++) {
            if (i >= matrix[i].length) break;
            sum += matrix[i][i];
        }

        return sum;
    }

    public static double getAverage(int[][] matrix) {
        double sum = 0;
        double avg = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        avg = sum / (matrix.length * matrix[0].length);
        return avg;
    }

    public static double[] getVectorAverages(int[][] matrix) {
        double[] avgs = new double[matrix.length];
        double sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            avgs[i] = sum / matrix[i].length;
        }

        return avgs;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] matrixT = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixT[j][i] = matrix[i][j];
            }
        }

        return matrixT;
    }

    public static int[][] replaceElements(int[][] matrix) {
        int[][] matrixXOR = matrix.clone();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixXOR[i][j] = (matrix[i][j] <= 0) ? 0 : 1;
            }
        }

        return matrixXOR;
    }

    public static int[][] diagonalise(int[][] matrix) {
        int[][] diagMatrix = matrix.clone();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                diagMatrix[i][j] = (i == j) ? 1 : 0;
            }
        }

        return diagMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{0,0,0}};

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("\n" + mainDiag(matrix));

        System.out.println("\n" + getAverage(matrix));

        double[] vectorAvgs = getVectorAverages(matrix);

        System.out.println("\n" + Arrays.toString(vectorAvgs) + "\n");

        int[][] matrixNew = transpose(matrix);

        for (int i = 0; i < matrixNew.length; i++) {
            System.out.println(Arrays.toString(matrixNew[i]));
        }

        System.out.println();

        int[][] matrixXOR = replaceElements(matrix);

        for (int i = 0; i < matrixXOR.length; i++) {
            System.out.println(Arrays.toString(matrixXOR[i]));
        }

        System.out.println();

        int[][] diagMatrix = diagonalise(matrix);
        int[][] diagedMatrix = diagonalise(matrixNew);

        for (int i = 0; i < diagMatrix.length; i++) {
            System.out.println(Arrays.toString(diagMatrix[i]));
        }

        System.out.println();

        for (int i = 0; i < diagedMatrix.length; i++) {
            System.out.println(Arrays.toString(diagedMatrix[i]));
        }
    }
}
