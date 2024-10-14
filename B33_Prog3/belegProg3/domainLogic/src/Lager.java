import cargo.Cargo;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Lager {
    private Set<Object> cargoLot = new HashSet<>();

    public boolean create(Object cargo) {
        if (cargo == null) return false;
        if (cargoLot.contains(cargo)) return false;

        cargoLot.add(cargo);
        return true;
    }

    public boolean read(Object cargo) {
        if (cargo == null) return false;
        if (cargoLot.contains(cargo)) return false;

        return true;
    }

    public boolean update(Object cargo, Date date) {
        if (cargo == null) return false;
        if (!cargoLot.contains(cargo)) return false;

        cargoLot.remove(cargo);

        return true;
    }

    public boolean delete(Object cargo) {
        if (cargo == null) return false;
        if (!cargoLot.contains(cargo)) return false;

        cargoLot.remove(cargo);
        return true;
    }
}
