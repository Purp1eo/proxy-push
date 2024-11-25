import java.io.IOException;
import cli.CLI;
import domainLogic.Storage;
import eventsInfrastructure.EventHandler;
import eventsInfrastructure.EventListener;
import listener.AddCargoListener;

public class Main {
    public static void main(String[] args) throws IOException {
        Storage storage = new Storage();
        CLI console = new CLI();
        EventHandler addCargoHandler = new EventHandler();
        console.setAddCargoHandler(addCargoHandler);

        EventListener addCargoListener = new AddCargoListener(storage);
        addCargoHandler.add(addCargoListener);

        console.execute();
    }
}
