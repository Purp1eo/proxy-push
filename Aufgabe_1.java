import java.util.*;

public class Aufgabe_1 {

    public static void main(String[] args) {
        double[] myArray = { 2, 3, 87, 87, 51345, 1, 345, 151, 51, 10 };

        System.out.println(Arrays.toString(myArray));
        System.out.println(Arrays.toString(getMetrics(myArray)));
        System.out.println(getIndexOfValue(myArray, 87));
        System.out.println(Arrays.toString(removeValueAtIndex(myArray, 9)));
        // addValueAtIndex(myArray, 7.77, 5);
        // System.out.println(Arrays.toString(myArray));
    }

    public static double getAvg(double[] passedArray) {

        double sum = 0;
        double avg = 0;

        for (double element : passedArray) {
            sum += element;
        }

        avg = sum / passedArray.length;

        return avg;
    }

    public static double getSD(double[] passedArray) {

        double avg = 0;
        double SDSum = 0;
        double sd = 0;

        for (double element : passedArray) {
            SDSum += Math.pow(element - avg, 2);
        }

        sd = Math.sqrt(SDSum / passedArray.length);

        return sd;
    }

    public static double getBiggestValue(double[] passedArray) {

        double maxValue = 0;

        double[] sortedArray = Arrays.copyOf(passedArray, passedArray.length);
        Arrays.sort(sortedArray);

        maxValue = sortedArray[passedArray.length - 1];

        return maxValue;
    }

    public static double getSmallestValue(double[] passedArray) {

        double minValue = 0;

        double[] sortedArray = Arrays.copyOf(passedArray, passedArray.length);
        Arrays.sort(sortedArray);

        minValue = sortedArray[0];

        return minValue;
    }

    static double[] getMetrics(double[] passedArray) {

        double avg = getAvg(passedArray);
        double sd = getSD(passedArray);
        double maxValue = getBiggestValue(passedArray);
        double minValue = getSmallestValue(passedArray);

        double[] metricsArray = { avg, sd, maxValue, minValue };

        return metricsArray;
    }

    public static String getIndexOfValue(double[] passedArray, double value) {

        StringBuilder indeces = new StringBuilder();
        indeces.append("Matching value(s) at indeces:");
        for (int i = 0; i < passedArray.length; i++) {
            if (passedArray[i] == value) {
                indeces.append(String.format(" [%s]", i));
            }
        }
        return indeces.toString();
    }

    public static double[] removeValueAtIndex(double[] passedArray, int index) {
        
        double[] newArray = new double[passedArray.length-1];

        for(int i = 0, j = 0; i < passedArray.length; i++, j++) {
            if (i == index) {
                j--;
                continue;
            }
            newArray[j] = passedArray[i];
        }

        passedArray = newArray;
        return newArray;
    }

    public static double[] addValueAtIndex(double[] passedArray, double value, int index) {
        
        double[] newArray = new double[passedArray.length+1];
        
        for(int i = 0, j = 0; i < passedArray.length; i++, j++) {
            if (i == index) {
                newArray[j] = value;
                i--;
                continue;
            }
            newArray[j] = passedArray[i];
        }

        passedArray = newArray;
        return newArray;
    }
}
