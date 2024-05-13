import java.lang.Math;
import java.io.File;
import java.util.Scanner;

public class aufg_42 {

    public static double adjustCharges(String client) {
        
        String[] clientData = client.split(",");
        int clientChildren = Integer.parseInt(clientData[3]);
        double clientCharges = Double.parseDouble(clientData[6]);

        clientCharges /= 12; // monthly payments
	clientCharges *= Math.pow(0.01, 12); // adjust for 1% increase
        if (clientChildren > 2) clientCharges /= 2; // adjust for people with more than 2 kids (-50%)

        System.out.println(clientCharges);

        return clientCharges;
    }
}
