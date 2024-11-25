package domainLogic;

import cargo.Hazard;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private ArrayList<GenericCargo> storageLot;
    private final int maxCapacity = 5;
    private ArrayList<Owner> owners;

    public Storage() {
        this.storageLot = new ArrayList<>();
        this.owners = new ArrayList<>();
    }

    // customer utilities
    public boolean addOwner(Owner owner) {

        if (owner == null) return false;
        for (Owner element : owners) if (owner.getName().equals(element.getName())) return false;

        owners.add(owner);
        return true;
    }

    public Owner[] listOwners() {

        Owner[] ownersList = new Owner[owners.size()];
        for (int i = 0; i < owners.size(); i++) {
            ownersList[i] = owners.get(i);
        }
        return ownersList;
    }

    public boolean removeOwner(Owner owner) {

        if (owner == null) return false;
        if (!owners.contains(owner)) return false;

        owners.remove(owner);
        return true;
    }

    // cargo utilities
    public boolean addCargo(GenericCargo cargo) {

        if (cargo == null) return false;
        if (maxCapacity <= storageLot.size()) return false;
        if (storageLot.contains(cargo)) return false;

        boolean createNew = true;
        for (Owner element : owners) {
            if (cargo.getOwner().getName().equals(element.getName())) {
                createNew = false;
                break;
            }
        }
        if (createNew) addOwner(cargo.getOwner());
        storageLot.add(cargo);
        cargo.getOwner().incrementNumberOfContainers();
        cargo.setStorageLocation(storageLot.indexOf(cargo));
        return true;
    }

    public List<GenericCargo> listCargo() {

        return List.copyOf(this.storageLot);
    }

    public boolean updateInspectionDate(GenericCargo cargo, Date date) {

        if (cargo == null) return false;
        if (!storageLot.contains(cargo)) return false;

        cargo.setLastInspectionDate(date);
        return true;
    }

    public boolean removeCargo(GenericCargo cargo) {

        if (cargo == null) return false;
        if (!storageLot.contains(cargo)) return false;

        storageLot.remove(cargo);
        cargo.setDurationOfStorage(null);
        cargo.getOwner().decrementNumberOfContainers();
        return true;
    }

    // hazards utilities
    public String[] listHazards() {

        boolean expl = false;
        boolean flam = false;
        boolean toxic = false;
        boolean rad = false;
        String[] hazards = new String[4];

        for (GenericCargo element : storageLot) {
            if (expl && flam && toxic && rad) break;
            if (element.getHazards().contains(Hazard.explosive)) expl = true;
            if (element.getHazards().contains(Hazard.flammable)) flam = true;
            if (element.getHazards().contains(Hazard.toxic)) toxic = true;
            if (element.getHazards().contains(Hazard.radioactive)) rad = true;
        }

        hazards[0] = "explosive cargo: " + expl;
        hazards[1] = "flammable cargo: " + flam;
        hazards[2] = "toxic cargo: " + toxic;
        hazards[3] = "radioactive cargo: " + rad;
        return hazards;
    }
}
