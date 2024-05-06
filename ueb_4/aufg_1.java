package ueb_4;

import java.util.Arrays;

public class aufg_1 {

    public static double mainDiag(int[][] matrix) {
        double sum = 0;        

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    public static double getAverage(int[][] matrix) {
        int elementCount = 0;
        double sum = 0;
        double avg = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                elementCount++;
            }
        }

        avg = sum / elementCount;
        return avg;
    }

    public static double[] getVectorAverages(int[][] matrix) {
        double[] avgs = new double[matrix.length];
        int elementCount = 0;
        double sum = 0;
        double avg = 0;
        

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];
                elementCount++;
            }
            avgs[i] = sum / elementCount;
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
            for (int j = 0; j < matrix.length; j++) {
                matrixXOR[i][j] = (matrixXOR[i][j] <= 0) ? 0 : 1;
            }
        }

        return matrixXOR;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("\n");

        int[][] matrixNew = transpose(matrix);

        for (int i = 0; i < matrixNew.length; i++) {
            System.out.println(Arrays.toString(matrixNew[i]));
        }
    }
}