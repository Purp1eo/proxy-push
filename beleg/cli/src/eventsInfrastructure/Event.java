package eventsInfrastructure;

import domainLogic.*;
import java.util.EventObject;

public class Event extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    private Owner owner;
    private GenericCargo cargo;

    public Event(Object source, Owner owner, GenericCargo cargo) {
        super(source);
        this.owner = owner;
        this.cargo = cargo;
    }

    public Owner getOwner() {
        return owner;
    }

    public GenericCargo getCargo() {
        return cargo;
    }
}
