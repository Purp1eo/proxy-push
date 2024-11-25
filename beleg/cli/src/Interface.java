import domainLogic.GenericCargo;
import domainLogic.Owner;
import domainLogic.Storage;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

class Interface {

    static Storage storageLot;
    static GenericCargo cargo;

    public Interface() throws IOException {
        storageLot = new Storage();
        cargo = new GenericCargo(new Owner("Bob"), new BigDecimal(100));
        startUpInterface();
    }

    public void startUpInterface() throws IOException {
        boolean toContinue = true;
        while(toContinue) {
            System.out.println();
            System.out.println("Folgende Befehle stehen zu Verfuegung:");
            System.out.println("1. Einfuegen eines Frachtstuecks");
            System.out.println("2. Anzeigen aller Frachtstuecke");
            System.out.println("3. Aendern des Inspektionsdatums eines Frachtstuecks");
            System.out.println("4. Entfernen eines Frachtstuecks");
            System.out.println("5. Abbrechen");
            System.out.println("Waehlen Sie {1/2/3/4/5}");
            char choice = (char) System.in.read();
            System.in.read(); // prevents prompt from appearing twice by catching the return character

            switch(choice) {
                case '1':
                    Utilities.addCargoUtility(storageLot, cargo);
                    break;
                case '2':
                    System.out.println();
                    Utilities.listCargoUtility(storageLot);
                    break;
                case '3':
                    Utilities.updateInspectionDateUtility(storageLot, cargo, Date.valueOf(LocalDate.now()));
                    break;
                case '4':
                    Utilities.removeCargoUtility(storageLot, cargo);
                    break;
                case '5':
                    toContinue = false;
            }
        }
    }
}
