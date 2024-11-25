package eventsInfrastructure;

import view.View;

import java.util.LinkedList;
import java.util.List;

public class EventHandler {
    private final List<EventListener> listenerList = new LinkedList<>();
    private View view;

    public void add(EventListener listener) {
        listener.setView(view);
        this.listenerList.add(listener);
    }

    public void remove(EventListener listener) {
        this.listenerList.remove(listener);
    }

    public void handle(Event event) {
        for(EventListener listener : listenerList) {
            listener.onStorageEvent(event);
        }
    }

    public void setView(View view) {
        this.view = view;
    }
}
