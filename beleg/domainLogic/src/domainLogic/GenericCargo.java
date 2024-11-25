package domainLogic;

import cargo.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Duration;
import java.util.EnumSet;

public class GenericCargo implements LiquidBulkCargo, DryBulkCargo, UnitisedCargo {

    private final Owner owner;
    private Duration durationOfStorage;
    private Date lastInspectionDate;
    private int storageLocation;
    private final BigDecimal value;
    private final EnumSet<Hazard> hazards;
    private Boolean isPressurized;
    private int grainSize;
    private Boolean isFragile;

    public GenericCargo(Owner owner, BigDecimal value) {
        this.owner = owner;
        this.value = value;
        this.hazards = EnumSet.noneOf(Hazard.class);
    }

    GenericCargo(Owner owner, BigDecimal value, Hazard hazard) {
        this.owner = owner;
        this.value = value;
        this.hazards = EnumSet.of(hazard);
    }

    GenericCargo(Owner owner, BigDecimal value, Hazard hazardOne, Hazard hazardTwo) {
        this.owner = owner;
        this.value = value;
        this.hazards = EnumSet.of(hazardOne, hazardTwo);
    }

    GenericCargo(Owner owner, BigDecimal value, Hazard hazardOne, Hazard hazardTwo, Hazard hazardThree) {
        this.owner = owner;
        this.value = value;
        this.hazards = EnumSet.of(hazardOne, hazardTwo, hazardThree);
    }

    GenericCargo(Owner owner, BigDecimal value, Hazard hazardOne, Hazard hazardTwo, Hazard hazardThree, Hazard hazardFour) {
        this.owner = owner;
        this.value = value;
        this.hazards = EnumSet.of(hazardOne, hazardTwo, hazardThree, hazardFour);
    }

    @Override
    public Owner getOwner() {
        return owner;
    }

    public boolean setDurationOfStorage(Duration duration) {
        this.durationOfStorage = duration;
        return true;
    }

    @Override
    public Duration getDurationOfStorage() {
        return durationOfStorage;
    }

    public boolean setLastInspectionDate(Date date) {
        this.lastInspectionDate = date;
        return true;
    }

    @Override
    public Date getLastInspectionDate() {
        return lastInspectionDate;
    }

    public boolean setStorageLocation(int location) {
        this.storageLocation = location;
        return true;
    }

    @Override
    public int getStorageLocation() {
        return storageLocation;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public EnumSet<Hazard> getHazards() {
        return hazards;
    }

    public GenericCargo setIsPressurized(boolean isPressurized) {

        if (grainSize != Integer.MIN_VALUE && isFragile != null) return this;

        this.isPressurized = isPressurized;
        return this;
    }

    @Override
    public boolean isPressurized() {
        return isPressurized;
    }

    public GenericCargo setGrainSize(int grainSize) {

        if (isPressurized != null && isFragile != null) return this;

        this.grainSize = grainSize;
        return this;
    }

    @Override
    public int getGrainSize() {
        return grainSize;
    }

    public GenericCargo setIsFragile(boolean isFragile) {

        if (isPressurized != null && grainSize != Integer.MIN_VALUE) return this;

        this.isFragile = isFragile;
        return this;
    }

    @Override
    public boolean isFragile() {
        return isFragile;
    }
}
