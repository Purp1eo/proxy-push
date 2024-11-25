package listener;

import domainLogic.Storage;
import eventsInfrastructure.Event;
import eventsInfrastructure.EventListener;
import view.View;

public class AddCargoListener implements EventListener {

    private Storage storage;
    private View view;

    public AddCargoListener(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void onStorageEvent(Event event) {
        boolean result = this.storage.addCargo(event.getCargo());

        view.inform((result) ? "cargo added" : "cargo not added");
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
