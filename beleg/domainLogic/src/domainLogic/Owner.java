package domainLogic;

import administration.Customer;

public class Owner implements Customer {

    final private String name;
    private int numberOfContainers = 0;

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean incrementNumberOfContainers() {
        numberOfContainers++;
        return true;
    }

    public boolean decrementNumberOfContainers() {
        numberOfContainers--;
        return false;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }
}
