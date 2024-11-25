import domainLogic.GenericCargo;
import domainLogic.Owner;
import domainLogic.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {

    private Storage storage;
    private Owner owner;
    private GenericCargo cargo;

    @BeforeEach
    void setupStorage() {
        storage = new Storage();
    }

    // customer tests
    @Test
    void customerIsNullWhenAdding() {
        assertFalse(storage.addOwner(null));
    }

    @Test
    void customerAlreadyExistsInListWhenAdding() {
        storage.addOwner(new Owner("Bob"));

        assertFalse(storage.addOwner(new Owner("Bob")));
    }

    @Test
    void customerAddedSuccessfully() {
        assertTrue(storage.addOwner(new Owner("Bob")));
    }

    @Test
    void customerIsNullWhenRemoving() {
        assertFalse(storage.removeOwner(null));
    }

    @Test
    void customerNotInListWhenRemoving() {
        assertFalse(storage.removeOwner(new Owner("Bob")));
    }

    @Test
    void customerRemovedSuccessfully() {
        owner = new Owner("Bob");
        storage.addOwner(owner);

        assertTrue(storage.removeOwner(owner));
    }

    // cargo tests
    @Test
    void cargoIsNullWhenAdding() {
        assertFalse(storage.addCargo(null));
    }

    @Test
    void cargoAlreadyExistsInListWhenAdding() {
        cargo = new GenericCargo(new Owner("Bob"), new BigDecimal(100));
        storage.addCargo(cargo);

        assertFalse(storage.addCargo(cargo));
    }

    @Test
    void cargoOwnerDoesNotExistYetWhenAdding() {
        cargo = new GenericCargo(new Owner("Bob"), new BigDecimal(100));
        storage.addCargo(cargo);
        boolean ownerAddedSuccessfully = false;

        for (GenericCargo element : storage.listCargo()) {
            if (cargo.getOwner().getName().equals(element.getOwner().getName())) {
                ownerAddedSuccessfully = true;
                break;
            }
        }

        assertTrue(ownerAddedSuccessfully);
    }

    @Test
    void maxCapacityReached() {
        owner = new Owner("Bob");
        storage.addOwner(owner);

        storage.addCargo(new GenericCargo(owner, new BigDecimal(100)));
        storage.addCargo(new GenericCargo(owner, new BigDecimal(200)));
        storage.addCargo(new GenericCargo(owner, new BigDecimal(300)));
        storage.addCargo(new GenericCargo(owner, new BigDecimal(400)));
        storage.addCargo(new GenericCargo(owner, new BigDecimal(500)));

        boolean isFalse = storage.addCargo(new GenericCargo(owner, new BigDecimal(100)));

        assertFalse(isFalse);
    }

    @Test
    void ownerContainerCountIncrements() {
        owner = new Owner("Bob");
        storage.addOwner(owner);
        int containerCountBefore = owner.getNumberOfContainers();
        storage.addCargo(new GenericCargo(owner, new BigDecimal(100)));
        int containerCountAfter = owner.getNumberOfContainers();

        assertTrue(containerCountBefore < containerCountAfter);
    }

    @Test
    void cargoLocationUpdatedSuccessfully() {
        owner = new Owner("Bob");
        storage.addCargo(new GenericCargo(owner, new BigDecimal(100)));
        // needs to be tested with second cargo; default location is null (0 when called), so still 0 when updated for first cargo
        cargo = new GenericCargo(owner, new BigDecimal(100));
        int cargoLocationBefore = cargo.getStorageLocation();
        storage.addCargo(cargo);
        int cargoLocationAfter = cargo.getStorageLocation();

        assertNotEquals(cargoLocationBefore, cargoLocationAfter);
    }

    @Test
    void cargoAddedSuccessfully() {
        
    }

    @Test
    void cargoIsNullWhenUpdatingInspectionDate() {
        assertFalse(storage.updateInspectionDate(null, Date.valueOf(LocalDate.now())));
    }

    @Test
    void cargoIsNotInListWhenUpdatingInspectionDate() {
        cargo = new GenericCargo(new Owner("Bob"), new BigDecimal(100));

        assertFalse(storage.updateInspectionDate(cargo, Date.valueOf(LocalDate.now())));
    }

    @Test
    void inspectionDateUpdatedSuccessfully() {
        cargo = new GenericCargo(new Owner("Bob"), new BigDecimal(100));
        storage.addCargo(cargo);

        assertTrue(storage.updateInspectionDate(cargo, Date.valueOf(LocalDate.now())));
    }

    @Test
    void cargoIsNullWhenRemoving() {
        assertFalse(storage.removeCargo(null));
    }

    @Test
    void cargoIsNotInListWhenRemoving() {
        assertFalse(storage.removeOwner(new Owner("Bob")));
    }

    @Test
    void ownerContainerCountDecrements() {
        owner = new Owner("Bob");
        storage.addOwner(owner);
        cargo = new GenericCargo(owner, new BigDecimal(100));
        storage.addCargo(cargo);
        int containerCountBefore = owner.getNumberOfContainers();
        storage.removeCargo(cargo);
        int containerCountAfter = owner.getNumberOfContainers();

        assertTrue(containerCountBefore > containerCountAfter);
    }

    @Test
    void cargoRemovedSuccessfully() {
        cargo = new GenericCargo(new Owner("Bob"), new BigDecimal(100));
        storage.addCargo(cargo);

        assertTrue(storage.removeCargo(cargo));
    }
}