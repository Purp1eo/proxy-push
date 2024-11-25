import domainLogic.GenericCargo;
import domainLogic.Owner;
import domainLogic.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {

    private Storage storage;
    private GenericCargo cargo;

    @BeforeEach
    void setupStorage() {
        storage = new Storage();
        cargo = new GenericCargo(new Owner("Bob"), BigDecimal.valueOf(100));
    }

    @Test
    void storageIsNullWhenAddingCargo() {
        assertFalse(Utilities.addCargoUtility(null, cargo));
    }

    @Test
    void cargoIsNullWhenAddingCargo() {
        assertFalse(Utilities.addCargoUtility(storage, null));
    }

    @Test
    void cargoAddedSuccessfully() {
        assertTrue(Utilities.addCargoUtility(storage, cargo));
    }

    @Test
    void storageIsNullWhenListingCargo() {
        assertFalse(Utilities.listCargoUtility(null));
    }

    @Test
    void cargoListedSuccessfully() {
        assertTrue(Utilities.listCargoUtility(storage));
    }

    @Test
    void storageIsNullWhenUpdatingInspectionDate() {
        assertFalse(Utilities.updateInspectionDateUtility(null, cargo, Date.valueOf(LocalDate.now())));
    }

    @Test
    void cargoIsNullWhenUpdatingInspectionDate() {
        assertFalse(Utilities.updateInspectionDateUtility(storage, null, Date.valueOf(LocalDate.now())));
    }

    @Test
    void dateIsNullWhenUpdatingInspectionDate() {
        assertFalse(Utilities.updateInspectionDateUtility(storage, cargo, null));
    }

    @Test
    void inspectionDateUpdatedSuccessfully() {
        Utilities.addCargoUtility(storage, cargo);
        assertTrue(Utilities.updateInspectionDateUtility(storage, cargo, Date.valueOf(LocalDate.now())));
    }

    @Test
    void storageIsNullWhenRemovingCargo() {
        assertFalse(Utilities.removeCargoUtility(null, cargo));
    }

    @Test
    void cargoIsNullWhenRemovingCargo() {
        assertFalse(Utilities.removeCargoUtility(storage, null));
    }

    @Test
    void cargoRemovedSuccessfully() {
        Utilities.addCargoUtility(storage, cargo);
        assertTrue(Utilities.removeCargoUtility(storage, cargo));
    }
}