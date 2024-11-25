import domainLogic.GenericCargo;
import domainLogic.Storage;

import java.sql.Date;

final class Utilities {

    private Utilities() {}

    public static boolean addCargoUtility(Storage storage, GenericCargo cargo) {

        if (storage == null || cargo == null) return false;

        storage.addCargo(cargo);
        return true;
    }

    public static boolean listCargoUtility(Storage storage) {

        if (storage == null) return false;

        for (GenericCargo element : storage.listCargo()) {
            System.out.println(element.toString());
        }
        return true;
    }

    public static boolean updateInspectionDateUtility(Storage storage, GenericCargo cargo, Date date) {

        if (storage == null || cargo == null || date == null) return false;

        storage.updateInspectionDate(cargo, date);
        return true;
    }

    public static boolean removeCargoUtility(Storage storage, GenericCargo cargo) {

        if (storage == null || cargo == null) return false;

        storage.removeCargo(cargo);
        return true;
    }
}
