package cli;

import domainLogic.GenericCargo;
import domainLogic.Owner;
import eventsInfrastructure.Event;
import eventsInfrastructure.EventHandler;
import view.View;

import java.math.BigDecimal;
import java.util.Scanner;

public class CLI implements View {

    private EventHandler addCargoHandler;
    Owner owner = new Owner("Bob");
    GenericCargo cargo = new GenericCargo(owner, BigDecimal.valueOf(100));

    public void setAddCargoHandler(EventHandler handler) {
        this.addCargoHandler = handler;
        this.addCargoHandler.setView(this);
    }

    public void execute() {
        try (Scanner scan = new Scanner(System.in)) {
            do {
                System.out.println("Enter command\nAddCargo: 0");
                Event event = new Event(this, owner, cargo);
                switch(scan.next()) {
                    case "0":
                        if (this.addCargoHandler != null) addCargoHandler.handle(event);
                        break;
                }
            } while(true);
        }
    }

    @Override
    public void inform(String information) {
        System.out.println(information);
    }
}
