package eventsInfrastructure;

import view.View;

public interface EventListener extends java.util.EventListener {
    void onStorageEvent(Event event);
    void setView(View view);
}
